package com.example.springdatarediscrud.controllerDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserControllerDto {
    private Long id;
    private String name;
    private String lastName;
}
