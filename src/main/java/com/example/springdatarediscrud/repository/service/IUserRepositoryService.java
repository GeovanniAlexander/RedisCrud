package com.example.springdatarediscrud.repository.service;

import com.example.springdatarediscrud.entity.User;

import java.util.List;

public interface IUserRepositoryService {
    public User save(User user);
    public List<User> findAll();
    public User findById(Long id);
    public String deleteUser(Long id);
}
