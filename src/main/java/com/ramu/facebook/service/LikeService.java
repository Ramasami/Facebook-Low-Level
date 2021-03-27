package com.ramu.facebook.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ramu.facebook.dao.LikeDAO;
import com.ramu.facebook.dao.PostDAO;
import com.ramu.facebook.dao.UserDAO;
import com.ramu.facebook.model.LikeDTO;
import com.ramu.facebook.model.PostDTO;
import com.ramu.facebook.model.UserDTO;
import com.ramu.facebook.utils.exceptions.LikeException;
import com.ramu.facebook.utils.exceptions.PostException;
import com.ramu.facebook.utils.exceptions.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeService {

    @Autowired
    private LikeDAO likeDAO;

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private PostDAO postDAO;

    public LikeDTO addLike(LikeDTO likeDTO) throws JsonProcessingException, LikeException, UserException, PostException {
        userDAO.getUser(new UserDTO(likeDTO.getUserId(), null, null, null));
        postDAO.getPost(new PostDTO(likeDTO.getPostId(), null, null,null));
        return likeDAO.addLike(likeDTO);
    }

    public List<LikeDTO> getLike(LikeDTO likeDTO) throws JsonProcessingException, LikeException {
        return likeDAO.getLike(likeDTO);
    }
    
    
}
