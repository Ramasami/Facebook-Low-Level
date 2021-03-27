package com.ramu.facebook.db;

import com.ramu.facebook.model.FollowDO;
import com.ramu.facebook.utils.exceptions.FollowException;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class FollowDB {

    private static final AtomicInteger currentId = new AtomicInteger(0);
    private static final Map<Integer, FollowDO> followsID = new ConcurrentHashMap<>();
    private static final Map<Integer, Map<Integer, FollowDO>> followsUserId = new ConcurrentHashMap<>();
    private static final Map<Integer, Map<Integer, FollowDO>> followedByUserId = new ConcurrentHashMap<>();



    public synchronized FollowDO addFollow(FollowDO followDO) throws FollowException {
        int id = currentId.getAndIncrement();
        Date now = new Date();
        followDO.setId(id);
        followDO.setCreatedDate(now);
        followDO.setModifiedDate(now);
        followsID.put(id, followDO);

        if (!followsUserId.containsKey(followDO.getFromUserId()))
            followsUserId.put(followDO.getFromUserId(), new ConcurrentHashMap<>());
        followsUserId.get(followDO.getFromUserId()).put(followDO.getToUserId(), followDO);

        if (!followedByUserId.containsKey(followDO.getToUserId()))
            followedByUserId.put(followDO.getToUserId(), new ConcurrentHashMap<>());
        followedByUserId.get(followDO.getToUserId()).put(followDO.getFromUserId(), followDO);

        return followDO;
    }

    public List<FollowDO> getFollow(FollowDO followDO) throws FollowException {
        if (followDO.getId() != null) {
            if ((followDO = followsID.get(followDO.getId())) == null) {
                throw new FollowException("Follow ID doesnt exist");
            }
            return Collections.singletonList(followDO);
        }

        if(followDO.getFromUserId() != null && followDO.getToUserId() != null) {
            return Collections.singletonList(followsUserId.getOrDefault(followDO.getFromUserId(),new HashMap<>()).get(followDO.getToUserId()));
        } else if(followDO.getFromUserId() != null) {
            return new ArrayList<>(followsUserId.getOrDefault(followDO.getFromUserId(),new HashMap<>()).values());
        } else
            return new ArrayList<>(followedByUserId.getOrDefault(followDO.getToUserId(),new HashMap<>()).values());
    }
}
