package com.ramu.facebook.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ramu.facebook.dao.CommentDAO;
import com.ramu.facebook.dao.PostDAO;
import com.ramu.facebook.dao.UserDAO;
import com.ramu.facebook.model.CommentDTO;
import com.ramu.facebook.model.PostDTO;
import com.ramu.facebook.model.UserDTO;
import com.ramu.facebook.utils.exceptions.CommentException;
import com.ramu.facebook.utils.exceptions.PostException;
import com.ramu.facebook.utils.exceptions.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentDAO commentDAO;

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private PostDAO postDAO;

    public CommentDTO addComment(CommentDTO commentDTO) throws JsonProcessingException, CommentException, UserException, PostException {
        userDAO.getUser(new UserDTO(commentDTO.getUserId(), null, null,null));
        postDAO.getPost(new PostDTO(commentDTO.getPostId(), null, null,null));
        return commentDAO.addComment(commentDTO);
    }

    public List<CommentDTO> getComment(CommentDTO commentDTO) throws JsonProcessingException, CommentException {
        return commentDAO.getComment(commentDTO);
    }
}
