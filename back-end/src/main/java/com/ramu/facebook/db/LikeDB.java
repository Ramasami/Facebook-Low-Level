package com.ramu.facebook.db;

import com.ramu.facebook.model.LikeDO;
import com.ramu.facebook.utils.exceptions.LikeException;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class LikeDB {

    private static final AtomicInteger currentId = new AtomicInteger(0);
    private static final Map<Integer, LikeDO> likesID = new ConcurrentHashMap<>();
    private static final Map<Integer, Map<Integer, LikeDO>> likesPostUserId = new ConcurrentHashMap<>();


    public synchronized LikeDO addLike(LikeDO likeDO) throws LikeException {
        int id = currentId.getAndIncrement();
        Date now = new Date();
        likeDO.setId(id);
        likeDO.setCreatedDate(now);
        likeDO.setModifiedDate(now);
        likesID.put(id, likeDO);
        if (!likesPostUserId.containsKey(likeDO.getPostId()))
            likesPostUserId.put(likeDO.getPostId(), new ConcurrentHashMap<>());
        likesPostUserId.get(likeDO.getPostId()).put(likeDO.getUserId(), likeDO);
        return likeDO;
    }

    public List<LikeDO> getLike(LikeDO likeDO) throws LikeException {
        if (likeDO.getId() != null) {
            if ((likeDO = likesID.get(likeDO.getId())) == null) {
                throw new LikeException("Like ID doesnt exist");
            }
            return Collections.singletonList(likeDO);
        }
        Map<Integer, LikeDO> likeDOList;
        if ((likeDOList = likesPostUserId.get(likeDO.getPostId())) == null) {
            return new ArrayList<>();
        }
        if(likeDO.getUserId()!=null) {
            return Collections.singletonList(likeDOList.get(likeDO.getUserId()));
        }
        return new ArrayList<>(likeDOList.values());
    }
}
