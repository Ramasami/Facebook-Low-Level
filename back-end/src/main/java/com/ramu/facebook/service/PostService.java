package com.ramu.facebook.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ramu.facebook.dao.PostDAO;
import com.ramu.facebook.dao.UserDAO;
import com.ramu.facebook.model.PostDTO;
import com.ramu.facebook.model.UserDTO;
import com.ramu.facebook.utils.exceptions.PostException;
import com.ramu.facebook.utils.exceptions.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostDAO postDAO;

    @Autowired
    private UserDAO userDAO;

    public PostDTO addPost(PostDTO postDTO) throws JsonProcessingException, PostException, UserException {
        userDAO.getUser(new UserDTO(postDTO.getUserId(), null, null, null));
        return postDAO.addPost(postDTO);
    }

    public List<PostDTO> getPost(PostDTO postDTO) throws JsonProcessingException, PostException {
        return postDAO.getPost(postDTO);
    }
}
