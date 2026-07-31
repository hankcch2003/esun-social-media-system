package com.esun.social.dto;


import jakarta.validation.constraints.NotBlank;


public class UserLoginRequest {


    @NotBlank(message = "Phone cannot be empty")
    private String phone;


    @NotBlank(message = "Password cannot be empty")
    private String password;



    public String getPhone() {
        return phone;
    }


    public void setPhone(String phone) {
        this.phone = phone;
    }



    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }


}