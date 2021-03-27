package com.ramu.facebook.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ramu.facebook.dao.UserDAO;
import com.ramu.facebook.model.UserDTO;
import com.ramu.facebook.utils.exceptions.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

    public UserDTO addUser(UserDTO userDTO) throws JsonProcessingException, UserException {
        return userDAO.addUser(userDTO);
    }

    public UserDTO getUser(UserDTO userDTO) throws JsonProcessingException, UserException {
        return userDAO.getUser(userDTO);
    }
}
