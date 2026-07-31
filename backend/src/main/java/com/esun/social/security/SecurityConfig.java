package com.esun.social.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
public class SecurityConfig {


    private final JwtAuthenticationFilter jwtAuthenticationFilter;



    public SecurityConfig(
            JwtAuthenticationFilter jwtAuthenticationFilter
    ) {

        this.jwtAuthenticationFilter =
                jwtAuthenticationFilter;

    }



    @Bean
    public SecurityFilterChain securityFilterChain(
            HttpSecurity http
    ) throws Exception {


        http

                // 開啟 CORS
                .cors(
                        cors -> {}
                )


                .csrf(
                        csrf -> csrf.disable()
                )


                .sessionManagement(
                        session ->
                                session.sessionCreationPolicy(
                                        SessionCreationPolicy.STATELESS
                                )
                )


                .authorizeHttpRequests(
                        auth -> auth


                                .requestMatchers(
                                        "/users/register",
                                        "/users/login"
                                )
                                .permitAll()



                                .requestMatchers(
                                        "/posts",
                                        "/posts/**",
                                        "/comments",
                                        "/comments/**"
                                )
                                .authenticated()



                                .anyRequest()
                                .permitAll()

                )



                .addFilterBefore(
                        jwtAuthenticationFilter,
                        UsernamePasswordAuthenticationFilter.class
                );



        return http.build();

    }


}