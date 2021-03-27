package com.ramu.facebook.db;

import com.ramu.facebook.model.CommentDO;
import com.ramu.facebook.utils.exceptions.CommentException;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class CommentDB {

    private static final AtomicInteger currentId = new AtomicInteger(0);
    private static final Map<Integer, CommentDO> commentsID = new ConcurrentHashMap<>();
    private static final Map<Integer, Map<Integer, CommentDO>> commentsPostId = new ConcurrentHashMap<>();


    public synchronized CommentDO addComment(CommentDO commentDO) throws CommentException {
        int id = currentId.getAndIncrement();
        Date now = new Date();
        commentDO.setId(id);
        commentDO.setCreatedDate(now);
        commentDO.setModifiedDate(now);
        commentsID.put(id, commentDO);
        if (!commentsPostId.containsKey(commentDO.getPostId()))
            commentsPostId.put(commentDO.getPostId(), new ConcurrentHashMap<>());
        commentsPostId.get(commentDO.getPostId()).put(commentDO.getId(), commentDO);
        return commentDO;
    }

    public List<CommentDO> getComment(CommentDO commentDO) throws CommentException {
        if (commentDO.getId() != null) {
            if ((commentDO = commentsID.get(commentDO.getId())) == null) {
                throw new CommentException("Comment ID doesnt exist");
            }
            return Collections.singletonList(commentDO);
        }
        Map<Integer, CommentDO> commentDOList;
        if ((commentDOList = commentsPostId.get(commentDO.getPostId())) == null) {
            return new ArrayList<>();
        }
        return new ArrayList<>(commentDOList.values());
    }
}
