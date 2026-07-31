package com.esun.social.dto;


import java.time.LocalDateTime;


public class CommentResponse {


    private Long id;


    private String userName;


    private String content;


    private LocalDateTime createdAt;



    public Long getId() {

        return id;

    }


    public void setId(Long id) {

        this.id = id;

    }



    public String getUserName() {

        return userName;

    }


    public void setUserName(String userName) {

        this.userName = userName;

    }



    public String getContent() {

        return content;

    }


    public void setContent(String content) {

        this.content = content;

    }



    public LocalDateTime getCreatedAt() {

        return createdAt;

    }


    public void setCreatedAt(LocalDateTime createdAt) {

        this.createdAt = createdAt;

    }

}