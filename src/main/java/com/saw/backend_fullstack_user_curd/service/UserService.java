package com.saw.backend_fullstack_user_curd.service;


import com.saw.backend_fullstack_user_curd.entity.Users;

import java.util.List;

public interface UserService {
    List<Users> findAll();

    Users findById(int userId);

    Users save(Users theUser);

    void deleteById(int userId);
}
