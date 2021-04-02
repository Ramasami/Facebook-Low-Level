package com.ramu.facebook.dao;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ramu.facebook.db.FollowDB;
import com.ramu.facebook.model.FollowDO;
import com.ramu.facebook.model.FollowDTO;
import com.ramu.facebook.utils.exceptions.FollowException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class FollowDAO {

    @Autowired
    private FollowDB followDB;

    private ObjectMapper mapper = new ObjectMapper();

    private FollowDTO do2dto(FollowDO followDO) throws JsonProcessingException {
        return mapper.readValue(mapper.writeValueAsString(followDO), FollowDTO.class);
    }

    private FollowDO dto2do(FollowDTO followDTO) throws JsonProcessingException {
        return mapper.readValue(mapper.writeValueAsString(followDTO), FollowDO.class);
    }

    public FollowDTO addFollow(FollowDTO followDTO) throws JsonProcessingException, FollowException {
        FollowDO followDO = dto2do(followDTO);
        followDO = followDB.addFollow(followDO);
        return do2dto(followDO);
    }

    public List<FollowDTO> getFollow(FollowDTO followDTO) throws JsonProcessingException, FollowException {
        FollowDO followDO = dto2do(followDTO);
        List<FollowDO> followDOList = followDB.getFollow(followDO);
        return followDOList
                .stream()
                .map(follow-> {
                    try {
                        return do2dto(follow);
                    } catch (JsonProcessingException e) {
                        e.printStackTrace();
                    }
                    return null;
                })
                .sorted(Comparator.comparing(FollowDTO::getCreatedDate))
                .collect(Collectors.toList());
    }
}
