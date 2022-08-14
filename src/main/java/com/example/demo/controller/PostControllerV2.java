package com.example.demo.controller;

import com.example.demo.exception.BlogAPIException;
import com.example.demo.payload.PostDto;
import com.example.demo.payload.PostDtoV2;
import com.example.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/")
public class PostControllerV2 {

//    Version RestAPI
    @Autowired
    PostService postService;

    @GetMapping(value = "post/headers/{id}", headers = "X-API-VERSION=1" )
    public RedirectView getPostByIdHeader( @PathVariable(name = "id") long id) {
        return new RedirectView("/api/v1/post/"+id);
    }

//    Define Accept field in Header request
    @GetMapping(value = "post/produces/{id}", produces = "application/vnd.javaguides.v1+json" )
    public RedirectView getPostByIdProduces( @PathVariable(name = "id") long id) {
        return new RedirectView("/api/v1/post/"+id);
    }

    @GetMapping("post/{id}")
    public RedirectView getPostById(
            @RequestParam(value = "version", defaultValue = "", required = false) String versionParam,
            @RequestHeader(value = "version-api", defaultValue = "", required = false)String versionHeader,
            @PathVariable(name = "id") long id
    ) {
        String version;

        if (versionHeader.equals("") && versionParam.equals("")) {
            throw new BlogAPIException(HttpStatus.BAD_REQUEST, "Version should not empty");
        } else if (!(versionHeader.equals("") || versionParam.equals("")) && !versionHeader.equals(versionParam)) {
            throw new BlogAPIException(HttpStatus.BAD_REQUEST, "Can not check version");
        }

        if (versionHeader.equals("")) {
            version = versionParam;
        } else {
            version = versionHeader;
        }

        return new RedirectView("/api/v"+version+"/post/"+id);
    }

    @GetMapping("v2/post/{id}")
    public ResponseEntity<PostDtoV2> getPostByIdV2(@PathVariable(name = "id") long id) {
        PostDto postDtoNew = postService.getPostById(id);

        PostDtoV2 postDtoV2 = new PostDtoV2();
        postDtoV2.setId(postDtoNew.getId());
        postDtoV2.setTitle(postDtoNew.getTitle());
        postDtoV2.setDescription(postDtoNew.getDescription());
        postDtoV2.setContent(postDtoNew.getContent());
        postDtoV2.setComments(postDtoV2.getComments());

        List<String> tags = new ArrayList<>();
        tags.add("Java");
        tags.add("Spring");

        postDtoV2.setTags(tags);
        return ResponseEntity.ok(postDtoV2);
    }
}
