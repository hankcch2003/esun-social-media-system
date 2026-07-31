package com.esun.social.repository;


import com.esun.social.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public interface PostRepository extends JpaRepository<Post, Long> {


    @Transactional(readOnly = true)
    @Procedure(procedureName = "sp_GetAllPosts")
    List<Post> getAllPosts();



    @Transactional(readOnly = true)
    @Procedure(procedureName = "sp_GetPostById")
    Post getPostById(
            @Param("post_id") Long postId
    );



    @Procedure(procedureName = "sp_CreatePost")
    Long createPost(
            @Param("user_id") Long userId,
            @Param("content") String content,
            @Param("image") String image
    );



    @Transactional
    @Procedure(procedureName = "sp_UpdatePost")
    void updatePost(
            @Param("post_id") Long postId,
            @Param("content") String content,
            @Param("image") String image
    );



    @Transactional
    @Procedure(procedureName = "sp_DeletePost")
    void deletePost(
            @Param("post_id") Long postId
    );


}