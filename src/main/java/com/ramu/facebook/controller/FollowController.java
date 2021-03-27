package com.ramu.facebook.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ramu.facebook.model.FollowDTO;
import com.ramu.facebook.service.FollowService;
import com.ramu.facebook.utils.exceptions.FollowException;
import com.ramu.facebook.utils.exceptions.PostException;
import com.ramu.facebook.utils.exceptions.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/follow")
public class FollowController {

    @Autowired
    private FollowService followService;

    @PutMapping
    public FollowDTO addFollow(@RequestBody FollowDTO followDTO) throws JsonProcessingException, UserException, FollowException, PostException {
        return followService.addFollow(followDTO);
    }

    @PostMapping
    public List<FollowDTO> getFollow(@RequestBody FollowDTO followDTO) throws JsonProcessingException, FollowException {
        return followService.getFollow(followDTO);
    }
}
