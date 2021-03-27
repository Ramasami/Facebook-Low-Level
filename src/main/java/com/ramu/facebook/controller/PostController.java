package com.ramu.facebook.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ramu.facebook.model.PostDTO;
import com.ramu.facebook.model.UserDTO;
import com.ramu.facebook.service.PostService;
import com.ramu.facebook.service.UserService;
import com.ramu.facebook.utils.exceptions.PostException;
import com.ramu.facebook.utils.exceptions.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;

    @PutMapping
    public PostDTO addPost(@RequestBody PostDTO postDTO) throws JsonProcessingException, UserException, PostException {
        return postService.addPost(postDTO);
    }

    @PostMapping
    public List<PostDTO> getPost(@RequestBody PostDTO postDTO) throws JsonProcessingException, PostException {
        return postService.getPost(postDTO);
    }
}
