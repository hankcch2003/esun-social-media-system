package com.esun.social.service;


import com.esun.social.entity.Comment;
import com.esun.social.repository.CommentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class CommentService {


    private final CommentRepository commentRepository;


    public CommentService(CommentRepository commentRepository) {

        this.commentRepository = commentRepository;

    }



    @Transactional(readOnly = true)
    public List<Comment> getCommentsByPostId(Long postId) {

        return commentRepository.getCommentsByPostId(postId);

    }



    @Transactional
    public Long createComment(
            Long userId,
            Long postId,
            String content
    ) {

        return commentRepository.createComment(
                userId,
                postId,
                content
        );

    }


}