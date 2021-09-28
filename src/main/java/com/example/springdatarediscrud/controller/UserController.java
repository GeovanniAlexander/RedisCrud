package com.example.springdatarediscrud.controller;

import com.example.springdatarediscrud.controllerDto.UserControllerDto;
import com.example.springdatarediscrud.service.IUserService;
import com.example.springdatarediscrud.serviceDto.UserServiceDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/user")
@AllArgsConstructor
public class UserController {

    private final IUserService userService;

    @PostMapping
    public UserControllerDto save(@RequestBody UserControllerDto user){
        return toUserControllerDto(userService.save(toUserServiceDto(user)));
    }

    @GetMapping
    public List<UserControllerDto> getUsers(){
        return userService.findAll()
                .stream()
                .map(this::toUserControllerDto)
                .collect(Collectors.toList());
    }

    @GetMapping(value = "/{id}")
    public UserControllerDto getUser(@PathVariable("id") Long userId){
        return toUserControllerDto(userService.findById(userId));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId){
        return ResponseEntity.ok(userService.deleteUser(userId));
    }

    private UserServiceDto toUserServiceDto(UserControllerDto user) {
        UserServiceDto userServiceDto = new UserServiceDto();
        BeanUtils.copyProperties(user, userServiceDto);
        return userServiceDto;
    }

    private UserControllerDto toUserControllerDto(UserServiceDto userServiceDto){
        UserControllerDto userControllerDto = new UserControllerDto();
        BeanUtils.copyProperties(userServiceDto, userControllerDto);
        return userControllerDto;
    }


}
