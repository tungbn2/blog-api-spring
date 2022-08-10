package com.example.demo.controller;

import com.example.demo.payload.PostDto;
import com.example.demo.payload.PostResponse;
import com.example.demo.service.PostService;
import com.example.demo.ultils.AppConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class PostController {
    @Autowired
    PostService postService;

    //    create post
    @PostMapping("/posts")
    public ResponseEntity<PostDto> createPost(@Valid @RequestBody PostDto postDto) {
        return new ResponseEntity<>(postService.createPost(postDto), HttpStatus.CREATED);
    }

    //    Get all posts
    @GetMapping("/posts")
    public PostResponse getAllPost(
            @RequestParam(name = "pageNo",defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(name = "pageSize",defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(name = "sortBy",defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(name = "sortDir",defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir
    ) {
        return postService.getAllPost(pageNo, pageSize, sortBy, sortDir);
    }

    //    Get post by Id
    @GetMapping("/post/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable(name = "id") long id) {
        return ResponseEntity.ok(postService.getPostById(id));
    }

    //  update post by id
    @PutMapping("/post/{id}")
    public ResponseEntity<PostDto> updatePostById(
            @PathVariable(name = "id") long id,
            @Valid @RequestBody PostDto postDto) {
        return new ResponseEntity<>(postService.updatePost(postDto, id), HttpStatus.OK);
    }

//    delete post by id
    @DeleteMapping("/post/{id}")
    public ResponseEntity<String> deletePost(@PathVariable(name = "id") long id) {
        postService.deletePostById(id);
        return new ResponseEntity<>("Post deleted successfully!", HttpStatus.OK);
    }

}
