package com.example.demo.payload;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class SignUpDto {
    @NotEmpty
    @Size(min = 2, message = "Post title should have at least 2 characters")
    private String name;

    @NotEmpty
    @Size(min = 2, message = "Post title should have at least 2 characters")
    private String username;

    @NotEmpty
    @Email
    private String email;

    @NotEmpty
    @Size(min = 2, message = "Post title should have at least 2 characters")
    private String password;
}
