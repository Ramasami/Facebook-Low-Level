package com.ramu.facebook.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ramu.facebook.model.CommentDTO;
import com.ramu.facebook.service.CommentService;
import com.ramu.facebook.utils.exceptions.CommentException;
import com.ramu.facebook.utils.exceptions.PostException;
import com.ramu.facebook.utils.exceptions.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PutMapping
    public CommentDTO addComment(@RequestBody CommentDTO commentDTO) throws JsonProcessingException, UserException, CommentException, PostException {
        return commentService.addComment(commentDTO);
    }

    @PostMapping
    public List<CommentDTO> getComment(@RequestBody CommentDTO commentDTO) throws JsonProcessingException, CommentException {
        return commentService.getComment(commentDTO);
    }
}
