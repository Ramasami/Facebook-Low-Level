package com.ramu.facebook.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ramu.facebook.dao.*;
import com.ramu.facebook.model.*;
import com.ramu.facebook.utils.exceptions.CommentException;
import com.ramu.facebook.utils.exceptions.FollowException;
import com.ramu.facebook.utils.exceptions.LikeException;
import com.ramu.facebook.utils.exceptions.PostException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FeedsService {

    @Autowired
    private FollowDAO followDAO;

    @Autowired
    private PostDAO postDAO;

    @Autowired
    private CommentDAO commentDAO;

    @Autowired
    private LikeDAO likeDAO;

    @Autowired
    private UserDAO userDAO;

    public List<PostDTO> getFeeds(UserDTO userDTO) throws JsonProcessingException, FollowException {
        List<FollowDTO> follows = followDAO.getFollow(new FollowDTO(null, userDTO.getId(), null, null));
        List<PostDTO> posts = follows
                .stream()
                .map(FollowDTO::getToUserId)
                .map(user -> {
                    try {
                        return postDAO.getPost(new PostDTO(null, user, null, null));
                    } catch (JsonProcessingException e) {
                        e.printStackTrace();
                    } catch (PostException e) {
                        e.printStackTrace();
                    }
                    return new ArrayList<PostDTO>();
                }).flatMap(Collection::stream)
                .collect(Collectors.toList());
        posts.forEach(post -> {
            try {
                post.setComments(commentDAO.getComment(new CommentDTO(null, null, post.getId(), null, null)));
                post.setLikes(likeDAO.getLike(new LikeDTO(null, null, post.getId(), null, null)));
            } catch (JsonProcessingException | CommentException | LikeException e) {
                e.printStackTrace();
            }
        });
        return posts;
    }
}
