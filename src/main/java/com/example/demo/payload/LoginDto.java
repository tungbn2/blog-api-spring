package com.example.demo.payload;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class LoginDto {
    @NotEmpty
    @Size(min = 2, message = "Post title should have at least 2 characters")
    private String usernameOrEmail;

    @NotEmpty
    @Size(min = 2, message = "Post title should have at least 2 characters")
    private String password;
}
