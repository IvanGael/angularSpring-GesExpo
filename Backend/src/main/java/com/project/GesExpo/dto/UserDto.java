package com.project.GesExpo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDto {

    private Long id;

    @NotBlank(message = "this field must not be blank")
    @NotEmpty(message = "this field must not be empty")
    @NotNull(message = "this is required field!")
    @Size(min = 4, message = "this field require minimum 4 charaters.")
    private String username;


    @NotBlank(message = "this field must not be blank")
    @NotEmpty(message = "this field must not be empty")
    @NotNull(message = "this is required field!")
    @Size(min = 8, message = "this field require minimum 4 charaters.")
    private String password;


    @NotBlank(message = "this field must not be blank")
    @NotEmpty(message = "this field must not be empty")
    @NotNull(message = "this is required field!")
    @Email(message = "adresse email invalide!")
    private String email;


    @NotBlank(message = "this field must not be blank")
    @NotEmpty(message = "this field must not be empty")
    @NotNull(message = "this is required field!")
    @Size(min = 10, message = "this field require minimum 4 charaters.")
    private String about;


    private int active;
    private int blocked;
    private String role;
    private String permission;
}
