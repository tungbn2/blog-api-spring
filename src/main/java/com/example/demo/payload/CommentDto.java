package com.example.demo.payload;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Api(value = "Comment data")
@Data
public class CommentDto {
    @ApiModelProperty(value = "Comment Id")
    private long id;

    @ApiModelProperty(value = "Comment user")
    @NotEmpty(message = "Name should not be empty")
    private String name;

    @ApiModelProperty(value = "Comment email")
    @NotEmpty(message = "Email should not be empty")
    @Email
    private String email;

    @ApiModelProperty(value = "Comment content")
    @NotEmpty
    @Size(min = 10, message = "body should be min 10 characters")
    private String body;
}
