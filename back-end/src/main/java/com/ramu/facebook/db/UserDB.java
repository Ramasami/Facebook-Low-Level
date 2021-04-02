package com.ramu.facebook.db;

import com.ramu.facebook.model.UserDO;
import com.ramu.facebook.utils.exceptions.UserException;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class UserDB {

    private static final AtomicInteger currentId = new AtomicInteger(0);
    private static final Map<Integer, UserDO> usersID = new ConcurrentHashMap<>();
    private static final Map<String, UserDO> usersName = new ConcurrentHashMap<>();


    public synchronized UserDO addUser(UserDO userDO) throws UserException {
        if (usersName.containsKey(userDO.getName()))
            throw new UserException("User Name Already Exists");
        int id = currentId.getAndIncrement();
        Date now = new Date();
        userDO.setId(id);
        userDO.setCreatedDate(now);
        userDO.setModifiedDate(now);
        usersID.put(id, userDO);
        usersName.put(userDO.getName(), userDO);
        return userDO;
    }

    public UserDO getUser(UserDO userDO) throws UserException {
        if (userDO.getId() != null) {
            if ((userDO = usersID.get(userDO.getId())) == null) {
                throw new UserException("User ID doesnt exist");
            }
            return userDO;
        }
        if ((userDO = usersName.get(userDO.getName())) == null) {
            throw new UserException("User Name doesnt exist");
        }
        return userDO;
    }
}
