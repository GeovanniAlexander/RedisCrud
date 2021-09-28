package com.example.springdatarediscrud.repository.service;

import com.example.springdatarediscrud.entity.User;
import com.example.springdatarediscrud.repository.IUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserRepositoryServiceImpl implements IUserRepositoryService{

    private final IUserRepository userRepository;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public String deleteUser(Long id) {
        return userRepository.deleteUser(id);
    }
}
