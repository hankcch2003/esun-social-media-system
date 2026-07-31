package com.esun.social.service;


import com.esun.social.common.PasswordUtil;
import com.esun.social.dto.LoginResponse;
import com.esun.social.dto.RegisterRequest;
import com.esun.social.dto.UserLoginRequest;
import com.esun.social.entity.User;
import com.esun.social.repository.UserRepository;
import com.esun.social.security.JwtUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserService {


    private final UserRepository userRepository;

    private final JwtUtil jwtUtil;



    public UserService(
            UserRepository userRepository,
            JwtUtil jwtUtil
    ) {

        this.userRepository = userRepository;
        this.jwtUtil = jwtUtil;

    }



    public Long register(RegisterRequest request) {


        String salt =
                PasswordUtil.generateSalt();



        String hashPassword =
                PasswordUtil.hashPassword(
                        request.getPassword(),
                        salt
                );



        return userRepository.createUser(

                request.getUserName(),

                request.getPhone(),

                request.getEmail(),

                hashPassword,

                salt

        );

    }



    @Transactional(readOnly = true)
    public LoginResponse login(
            UserLoginRequest request
    ) {


        User user =
                userRepository.getUserByPhone(
                        request.getPhone()
                );



        if (user == null) {

            throw new RuntimeException(
                    "User not found"
            );

        }



        String hashPassword =
                PasswordUtil.hashPassword(
                        request.getPassword(),
                        user.getSalt()
                );



        if (!hashPassword.equals(user.getPassword())) {

            throw new RuntimeException(
                    "Password incorrect"
            );

        }



        String token =
                jwtUtil.generateToken(
                        user.getId()
                );



        return new LoginResponse(
                token
        );


    }


}