package com.example.springdatarediscrud.serviceDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserServiceDto {
    private Long id;
    private String name;
    private String lastName;
}
