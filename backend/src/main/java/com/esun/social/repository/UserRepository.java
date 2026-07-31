package com.esun.social.repository;


import com.esun.social.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {


    @Transactional(readOnly = true)
    @Query("""
            SELECT u
            FROM User u
            WHERE u.phone = :phone
            """)
    User getUserByPhone(
            @Param("phone") String phone
    );



    @Transactional
    @Procedure(procedureName = "sp_CreateUser")
    Long createUser(
            @Param("user_name") String userName,
            @Param("phone") String phone,
            @Param("email") String email,
            @Param("password") String password,
            @Param("salt") String salt
    );


}