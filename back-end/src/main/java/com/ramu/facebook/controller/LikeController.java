package com.ramu.facebook.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ramu.facebook.model.LikeDTO;
import com.ramu.facebook.service.LikeService;
import com.ramu.facebook.utils.exceptions.LikeException;
import com.ramu.facebook.utils.exceptions.PostException;
import com.ramu.facebook.utils.exceptions.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/like")
public class LikeController {

    @Autowired
    private LikeService likeService;

    @PutMapping
    public LikeDTO addLike(@RequestBody LikeDTO likeDTO) throws JsonProcessingException, UserException, LikeException, PostException {
        return likeService.addLike(likeDTO);
    }

    @PostMapping
    public List<LikeDTO> getLike(@RequestBody LikeDTO likeDTO) throws JsonProcessingException, LikeException {
        return likeService.getLike(likeDTO);
    }
}
