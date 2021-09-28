package com.example.springdatarediscrud.service;

import com.example.springdatarediscrud.entity.User;
import com.example.springdatarediscrud.serviceDto.UserServiceDto;

import java.util.List;

public interface IUserService {
    public UserServiceDto save(UserServiceDto user);
    public List<UserServiceDto> findAll();
    public UserServiceDto findById(Long id);
    public String deleteUser(Long id);
}
