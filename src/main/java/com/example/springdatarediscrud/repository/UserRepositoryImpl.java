package com.example.springdatarediscrud.repository;

import com.example.springdatarediscrud.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class UserRepositoryImpl implements IUserRepository{

    private final RedisTemplate template;
    private static final String HAS_KEY = "user";

    public User save(User user){
        template.opsForHash().put(HAS_KEY, user.getId(), user);
        return user;
    }

    public List<User> findAll(){
        return template.opsForHash().values(HAS_KEY);
    }

    public User findById(Long id){
        return (User) template.opsForHash().get(HAS_KEY, id);
    }

    public String deleteUser(Long id){
        template.opsForHash().delete(HAS_KEY, id);
        return "Removed";
    }


}
