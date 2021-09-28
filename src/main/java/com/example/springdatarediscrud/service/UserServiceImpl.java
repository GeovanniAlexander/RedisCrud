package com.example.springdatarediscrud.service;

import com.example.springdatarediscrud.entity.User;
import com.example.springdatarediscrud.repository.service.IUserRepositoryService;
import com.example.springdatarediscrud.serviceDto.UserServiceDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements IUserService{

    private final IUserRepositoryService userRepository;

    @Override
    public UserServiceDto save(UserServiceDto user) {
        return saveUserToRepository(user);
    }

    private UserServiceDto saveUserToRepository(UserServiceDto userServiceDto) {
        return toUserServiceDto(userRepository.save(toUser(userServiceDto)));
    }

    @Override
    public List<UserServiceDto> findAll() {
        return getUsersFromRepository();
    }

    private List<UserServiceDto> getUsersFromRepository(){
        return userRepository.findAll()
                .stream()
                .map(this::toUserServiceDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserServiceDto findById(Long id) {
        return toUserServiceDto(userRepository.findById(id));
    }

    @Override
    public String deleteUser(Long id) {
        return userRepository.deleteUser(id);
    }

    private User toUser(UserServiceDto userServiceDto) {
        User user = new User();
        BeanUtils.copyProperties(userServiceDto, user);
        return user;
    }

    private UserServiceDto toUserServiceDto(User user){
        UserServiceDto userServiceDto = new UserServiceDto();
        BeanUtils.copyProperties(user, userServiceDto);
        return userServiceDto;
    }
}
