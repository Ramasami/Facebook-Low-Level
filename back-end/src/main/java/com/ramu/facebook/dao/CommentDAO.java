package com.ramu.facebook.dao;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ramu.facebook.db.CommentDB;
import com.ramu.facebook.model.CommentDO;
import com.ramu.facebook.model.CommentDTO;
import com.ramu.facebook.utils.exceptions.CommentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CommentDAO {

    @Autowired
    private CommentDB commentDB;

    private ObjectMapper mapper = new ObjectMapper();

    private CommentDTO do2dto(CommentDO commentDO) throws JsonProcessingException {
        return mapper.readValue(mapper.writeValueAsString(commentDO), CommentDTO.class);
    }

    private CommentDO dto2do(CommentDTO commentDTO) throws JsonProcessingException {
        return mapper.readValue(mapper.writeValueAsString(commentDTO), CommentDO.class);
    }

    public CommentDTO addComment(CommentDTO commentDTO) throws JsonProcessingException, CommentException {
        CommentDO commentDO = dto2do(commentDTO);
        commentDO = commentDB.addComment(commentDO);
        return do2dto(commentDO);
    }

    public List<CommentDTO> getComment(CommentDTO commentDTO) throws JsonProcessingException, CommentException {
        CommentDO commentDO = dto2do(commentDTO);
        List<CommentDO> commentDOList = commentDB.getComment(commentDO);
        return commentDOList
                .stream()
                .map(comment-> {
                    try {
                        return do2dto(comment);
                    } catch (JsonProcessingException e) {
                        e.printStackTrace();
                    }
                    return null;
                })
                .sorted(Comparator.comparing(CommentDTO::getCreatedDate))
                .collect(Collectors.toList());
    }
}
