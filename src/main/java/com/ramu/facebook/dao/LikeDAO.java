package com.ramu.facebook.dao;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ramu.facebook.db.LikeDB;
import com.ramu.facebook.model.LikeDO;
import com.ramu.facebook.model.LikeDTO;
import com.ramu.facebook.utils.exceptions.LikeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class LikeDAO {

    @Autowired
    private LikeDB likeDB;

    private ObjectMapper mapper = new ObjectMapper();

    private LikeDTO do2dto(LikeDO likeDO) throws JsonProcessingException {
        return mapper.readValue(mapper.writeValueAsString(likeDO), LikeDTO.class);
    }

    private LikeDO dto2do(LikeDTO likeDTO) throws JsonProcessingException {
        return mapper.readValue(mapper.writeValueAsString(likeDTO), LikeDO.class);
    }

    public LikeDTO addLike(LikeDTO likeDTO) throws JsonProcessingException, LikeException {
        LikeDO likeDO = dto2do(likeDTO);
        likeDO = likeDB.addLike(likeDO);
        return do2dto(likeDO);
    }

    public List<LikeDTO> getLike(LikeDTO likeDTO) throws JsonProcessingException, LikeException {
        LikeDO likeDO = dto2do(likeDTO);
        List<LikeDO> likeDOList = likeDB.getLike(likeDO);
        return likeDOList
                .stream()
                .map(like-> {
                    try {
                        return do2dto(like);
                    } catch (JsonProcessingException e) {
                        e.printStackTrace();
                    }
                    return null;
                })
                .sorted(Comparator.comparing(LikeDTO::getCreatedDate))
                .collect(Collectors.toList());
    }
}
