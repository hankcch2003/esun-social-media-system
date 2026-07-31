package com.esun.social.service;


import com.esun.social.entity.Post;
import com.esun.social.repository.PostRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class PostService {


    private final PostRepository postRepository;



    public PostService(PostRepository postRepository) {

        this.postRepository = postRepository;

    }



    @Transactional(readOnly = true)
    public List<Post> getAllPosts() {

        return postRepository.getAllPosts();

    }



    @Transactional(readOnly = true)
    public Post getPostById(Long postId) {

        return postRepository.getPostById(postId);

    }



    @Transactional
    public Long createPost(
            Long userId,
            String content,
            String image
    ) {

        return postRepository.createPost(
                userId,
                content,
                image
        );

    }



    @Transactional
    public void updatePost(
            Long postId,
            String content,
            String image
    ) {


        Long currentUserId =
                getCurrentUserId();



        Post post =
                postRepository.getPostById(postId);



        if (post == null) {

            throw new RuntimeException(
                    "Post not found"
            );

        }



        if (!post.getUser().getId()
                .equals(currentUserId)) {


            throw new RuntimeException(
                    "You cannot update this post"
            );

        }



        postRepository.updatePost(
                postId,
                content,
                image
        );

    }




    @Transactional
    public void deletePost(Long postId) {


        Long currentUserId =
                getCurrentUserId();



        Post post =
                postRepository.getPostById(postId);



        if (post == null) {

            throw new RuntimeException(
                    "Post not found"
            );

        }



        if (!post.getUser().getId()
                .equals(currentUserId)) {


            throw new RuntimeException(
                    "You cannot delete this post"
            );

        }



        postRepository.deletePost(
                postId
        );

    }




    private Long getCurrentUserId() {


        Authentication authentication =
                SecurityContextHolder
                        .getContext()
                        .getAuthentication();



        return (Long) authentication.getPrincipal();

    }


}