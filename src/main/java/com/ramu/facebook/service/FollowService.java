package com.ramu.facebook.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ramu.facebook.dao.FollowDAO;
import com.ramu.facebook.dao.UserDAO;
import com.ramu.facebook.model.FollowDTO;
import com.ramu.facebook.model.UserDTO;
import com.ramu.facebook.utils.exceptions.FollowException;
import com.ramu.facebook.utils.exceptions.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FollowService {

    @Autowired
    private FollowDAO followDAO;

    @Autowired
    private UserDAO userDAO;

    public FollowDTO addFollow(FollowDTO followDTO) throws JsonProcessingException, FollowException, UserException {
        userDAO.getUser(new UserDTO(followDTO.getFromUserId(), null, null, null));
        userDAO.getUser(new UserDTO(followDTO.getToUserId(), null, null, null));
        return followDAO.addFollow(followDTO);
    }

    public List<FollowDTO> getFollow(FollowDTO followDTO) throws JsonProcessingException, FollowException {
        return followDAO.getFollow(followDTO);
    }
}
