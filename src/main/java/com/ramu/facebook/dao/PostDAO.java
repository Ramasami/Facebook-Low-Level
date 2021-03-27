package com.ramu.facebook.dao;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ramu.facebook.db.PostDB;
import com.ramu.facebook.model.PostDTO;
import com.ramu.facebook.model.PostDO;
import com.ramu.facebook.model.UserDTO;
import com.ramu.facebook.utils.exceptions.PostException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class PostDAO {

    @Autowired
    private PostDB postDB;

    private ObjectMapper mapper = new ObjectMapper();

    private PostDTO do2dto(PostDO postDO) throws JsonProcessingException {
        return mapper.readValue(mapper.writeValueAsString(postDO), PostDTO.class);
    }

    private PostDO dto2do(PostDTO postDTO) throws JsonProcessingException {
        return mapper.readValue(mapper.writeValueAsString(postDTO), PostDO.class);
    }

    public PostDTO addPost(PostDTO postDTO) throws JsonProcessingException, PostException {
        PostDO postDO = dto2do(postDTO);
        postDO = postDB.addPost(postDO);
        return do2dto(postDO);
    }

    public List<PostDTO> getPost(PostDTO postDTO) throws JsonProcessingException, PostException {
        PostDO postDO = dto2do(postDTO);
        List<PostDO> postDOList = postDB.getPost(postDO);
        return postDOList
                .stream()
                .map(post-> {
                    try {
                        return do2dto(post);
                    } catch (JsonProcessingException e) {
                        e.printStackTrace();
                    }
                    return null;
                })
                .sorted(Comparator.comparing(PostDTO::getCreatedDate))
                .collect(Collectors.toList());
    }
}
