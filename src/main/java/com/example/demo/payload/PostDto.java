package com.example.demo.payload;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Set;

@ApiModel(description = "Post model information")
@Data
public class PostDto {
    @ApiModelProperty(value = "Post id")
    private long id;

    @ApiModelProperty(value = "Post title")
//    title not null or empty and at least 2 characters
    @NotEmpty
    @Size(min = 2, message = "Post title should have at least 2 characters")
    private String title;

    @ApiModelProperty(value = "Post description")
    //    title not null or empty and at least 10 characters
    @NotEmpty
    @Size(min = 10, message = "Post description should have at least 10 characters")
    private String description;

    @ApiModelProperty(value = "Post content")
    @NotEmpty
    private String content;

    @ApiModelProperty(value = "Post comments")
    private Set<CommentDto> comments;
}
