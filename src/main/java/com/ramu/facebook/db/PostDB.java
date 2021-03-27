package com.ramu.facebook.db;

import com.ramu.facebook.model.PostDO;
import com.ramu.facebook.utils.exceptions.PostException;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class PostDB {

    private static final AtomicInteger currentId = new AtomicInteger(0);
    private static final Map<Integer, PostDO> postsID = new ConcurrentHashMap<>();
    private static final Map<Integer, Map<Integer, PostDO>> postsUserId = new ConcurrentHashMap<>();


    public synchronized PostDO addPost(PostDO postDO) throws PostException {
        int id = currentId.getAndIncrement();
        Date now = new Date();
        postDO.setId(id);
        postDO.setCreatedDate(now);
        postDO.setModifiedDate(now);
        postsID.put(id, postDO);
        if (!postsUserId.containsKey(postDO.getUserId()))
            postsUserId.put(postDO.getUserId(), new ConcurrentHashMap<>());
        postsUserId.get(postDO.getUserId()).put(postDO.getId(), postDO);
        return postDO;
    }

    public List<PostDO> getPost(PostDO postDO) throws PostException {
        if (postDO.getId() != null) {
            if ((postDO = postsID.get(postDO.getId())) == null) {
                throw new PostException("Post ID doesnt exist");
            }
            return Collections.singletonList(postDO);
        }
        Map<Integer, PostDO> postDOList;
        if ((postDOList = postsUserId.get(postDO.getUserId())) == null) {
            return new ArrayList<>();
        }
        return new ArrayList<>(postDOList.values());
    }
}
