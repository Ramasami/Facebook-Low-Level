package com.ramu.facebook.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ramu.facebook.model.PostDTO;
import com.ramu.facebook.model.UserDTO;
import com.ramu.facebook.service.FeedsService;
import com.ramu.facebook.utils.exceptions.FollowException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/feeds")
public class FeedsController {

    @Autowired
    private FeedsService commentService;

    @PostMapping
    public List<PostDTO> getFeed(@RequestBody UserDTO userDTO) throws JsonProcessingException, FollowException {
        return commentService.getFeeds(userDTO);
    }
}
