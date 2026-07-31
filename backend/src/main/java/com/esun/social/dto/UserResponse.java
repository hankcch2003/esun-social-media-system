package com.esun.social.dto;

public class UserResponse {

    private Long id;

    private String userName;

    private String phone;

    private String email;

    private String coverImage;

    private String biography;


    public UserResponse(
            Long id,
            String userName,
            String phone,
            String email,
            String coverImage,
            String biography
    ) {

        this.id = id;
        this.userName = userName;
        this.phone = phone;
        this.email = email;
        this.coverImage = coverImage;
        this.biography = biography;

    }


    public Long getId() {
        return id;
    }


    public String getUserName() {
        return userName;
    }


    public String getPhone() {
        return phone;
    }


    public String getEmail() {
        return email;
    }


    public String getCoverImage() {
        return coverImage;
    }


    public String getBiography() {
        return biography;
    }

}