package com.saw.backend_fullstack_user_curd.dao;

import com.saw.backend_fullstack_user_curd.entity.Users;

import java.util.List;

public interface UsersDAO {
    // get list of users
    List<Users> findAll();
    // get users by id
    Users findById(int theId);
    // save and update users
    Users save(Users theUser);
    // delete users
    void deleteById(int theId);
}
