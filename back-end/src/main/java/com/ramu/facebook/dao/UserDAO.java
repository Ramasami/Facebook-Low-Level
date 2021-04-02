package com.ramu.facebook.dao;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ramu.facebook.db.UserDB;
import com.ramu.facebook.model.UserDO;
import com.ramu.facebook.model.UserDTO;
import com.ramu.facebook.utils.exceptions.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDAO {

    @Autowired
    private UserDB userDB;

    private ObjectMapper mapper = new ObjectMapper();

    private UserDTO do2dto(UserDO userDO) throws JsonProcessingException {
        return mapper.readValue(mapper.writeValueAsString(userDO), UserDTO.class);
    }

    private UserDO dto2do(UserDTO userDTO) throws JsonProcessingException {
        return mapper.readValue(mapper.writeValueAsString(userDTO), UserDO.class);
    }

    public UserDTO addUser(UserDTO userDTO) throws JsonProcessingException, UserException {
        UserDO userDO = dto2do(userDTO);
        userDO = userDB.addUser(userDO);
        return do2dto(userDO);
    }

    public UserDTO getUser(UserDTO userDTO) throws JsonProcessingException, UserException {
        UserDO userDO = dto2do(userDTO);
        userDO = userDB.getUser(userDO);
        return do2dto(userDO);
    }
}
