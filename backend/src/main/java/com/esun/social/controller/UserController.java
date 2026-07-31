package com.esun.social.controller;


import com.esun.social.common.ApiResponse;
import com.esun.social.dto.LoginResponse;
import com.esun.social.dto.RegisterRequest;
import com.esun.social.dto.UserLoginRequest;
import com.esun.social.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users")
public class UserController {


    private final UserService userService;



    public UserController(UserService userService) {

        this.userService = userService;

    }



    @PostMapping("/register")
    public ApiResponse<Long> register(
            @Valid
            @RequestBody RegisterRequest request
    ) {


        Long userId =
                userService.register(request);



        return new ApiResponse<>(
                true,
                "Register Success",
                userId
        );

    }



    @PostMapping("/login")
    public ApiResponse<LoginResponse> login(
            @Valid
            @RequestBody UserLoginRequest request
    ) {


        LoginResponse response =
                userService.login(request);



        return new ApiResponse<>(
                true,
                "Login Success",
                response
        );

    }


}