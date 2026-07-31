package com.esun.social.controller;


import com.esun.social.common.ApiResponse;
import com.esun.social.dto.PostRequest;
import com.esun.social.dto.PostResponse;
import com.esun.social.entity.Post;
import com.esun.social.service.PostService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/posts")
public class PostController {


    private final PostService postService;



    public PostController(PostService postService) {

        this.postService = postService;

    }



    @GetMapping
    public ApiResponse<List<PostResponse>> getAllPosts() {


        List<PostResponse> posts =
                postService.getAllPosts()
                        .stream()
                        .map(this::convertToResponse)
                        .toList();



        return new ApiResponse<>(
                true,
                "Get Posts Success",
                posts
        );

    }



    @GetMapping("/{id}")
    public ApiResponse<PostResponse> getPostById(
            @PathVariable Long id
    ) {


        Post post =
                postService.getPostById(id);



        return new ApiResponse<>(
                true,
                "Get Post Success",
                convertToResponse(post)
        );

    }



    @PostMapping
    public ApiResponse<Long> createPost(
            @RequestBody PostRequest request
    ) {


        Authentication authentication =
                SecurityContextHolder
                        .getContext()
                        .getAuthentication();



        Long userId =
                (Long) authentication.getPrincipal();



        Long postId =
                postService.createPost(
                        userId,
                        request.getContent(),
                        request.getImage()
                );



        return new ApiResponse<>(
                true,
                "Create Post Success",
                postId
        );

    }



    @PutMapping("/{id}")
    public ApiResponse<String> updatePost(
            @PathVariable Long id,
            @RequestBody PostRequest request
    ) {


        postService.updatePost(
                id,
                request.getContent(),
                request.getImage()
        );



        return new ApiResponse<>(
                true,
                "Update Post Success",
                null
        );

    }



    @DeleteMapping("/{id}")
    public ApiResponse<String> deletePost(
            @PathVariable Long id
    ) {


        postService.deletePost(id);



        return new ApiResponse<>(
                true,
                "Delete Post Success",
                null
        );

    }



    private PostResponse convertToResponse(Post post) {


        PostResponse response =
                new PostResponse();



        response.setId(
                post.getId()
        );



        response.setUserName(
                post.getUser().getUserName()
        );



        response.setContent(
                post.getContent()
        );



        response.setImage(
                post.getImage()
        );



        response.setCreatedAt(
                post.getCreatedAt()
        );



        return response;

    }


}