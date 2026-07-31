package com.esun.social.controller;


import com.esun.social.common.ApiResponse;
import com.esun.social.dto.CommentRequest;
import com.esun.social.dto.CommentResponse;
import com.esun.social.entity.Comment;
import com.esun.social.service.CommentService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/comments")
public class CommentController {


    private final CommentService commentService;



    public CommentController(CommentService commentService) {

        this.commentService = commentService;

    }



    @GetMapping("/post/{postId}")
    public ApiResponse<List<CommentResponse>> getCommentsByPostId(
            @PathVariable Long postId
    ) {


        List<CommentResponse> comments =
                commentService.getCommentsByPostId(postId)
                        .stream()
                        .map(this::convertToResponse)
                        .toList();



        return new ApiResponse<>(
                true,
                "Get Comments Success",
                comments
        );

    }



    @PostMapping
    public ApiResponse<Long> createComment(
            @RequestBody CommentRequest request
    ) {


        Authentication authentication =
                SecurityContextHolder
                        .getContext()
                        .getAuthentication();



        Long userId =
                (Long) authentication.getPrincipal();



        Long commentId =
                commentService.createComment(
                        userId,
                        request.getPostId(),
                        request.getContent()
                );



        return new ApiResponse<>(
                true,
                "Create Comment Success",
                commentId
        );

    }



    private CommentResponse convertToResponse(Comment comment) {


        CommentResponse response =
                new CommentResponse();



        response.setId(
                comment.getId()
        );



        response.setUserName(
                comment.getUser().getUserName()
        );



        response.setContent(
                comment.getContent()
        );



        response.setCreatedAt(
                comment.getCreatedAt()
        );



        return response;

    }


}