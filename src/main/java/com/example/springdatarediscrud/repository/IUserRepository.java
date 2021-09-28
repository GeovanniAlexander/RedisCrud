package com.example.springdatarediscrud.repository;

import com.example.springdatarediscrud.entity.User;
import org.springframework.data.redis.core.HashOperations;

import java.util.List;

public interface IUserRepository {
    public User save(User user);
    public List<User> findAll();
    public User findById(Long id);
    public String deleteUser(Long id);
}
