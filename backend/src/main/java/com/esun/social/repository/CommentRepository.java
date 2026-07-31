package com.esun.social.repository;


import com.esun.social.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {


    @Transactional(readOnly = true)
    @Procedure(procedureName = "sp_GetCommentsByPostId")
    List<Comment> getCommentsByPostId(
            @Param("post_id") Long postId
    );



    @Transactional
    @Procedure(procedureName = "sp_CreateComment")
    Long createComment(
            @Param("user_id") Long userId,
            @Param("post_id") Long postId,
            @Param("content") String content
    );


}