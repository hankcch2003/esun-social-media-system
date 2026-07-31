package com.esun.social.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;


public class RegisterRequest {


    @NotBlank(message = "User name cannot be empty")
    private String userName;


    @NotBlank(message = "Phone cannot be empty")
    private String phone;


    @Email(message = "Email format incorrect")
    private String email;


    @NotBlank(message = "Password cannot be empty")
    private String password;



    public String getUserName() {
        return userName;
    }


    public void setUserName(String userName) {
        this.userName = userName;
    }



    public String getPhone() {
        return phone;
    }


    public void setPhone(String phone) {
        this.phone = phone;
    }



    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }



    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }


}