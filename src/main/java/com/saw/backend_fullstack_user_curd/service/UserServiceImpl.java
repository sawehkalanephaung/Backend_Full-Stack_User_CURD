package com.saw.backend_fullstack_user_curd.service;

import com.saw.backend_fullstack_user_curd.dao.UsersDAO;
import com.saw.backend_fullstack_user_curd.entity.Users;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
   private UsersDAO usersDAO;


   @Autowired
    public UserServiceImpl(UsersDAO usersDAO) {
        this.usersDAO = usersDAO;
    } // end

    @Override
    public List<Users> findAll() {
        return usersDAO.findAll();
    } // end

    @Override
    public Users findById(int userId) {
        return usersDAO.findById(userId);
    } // end

    @Override
    @Transactional
    public Users save(Users theUser) {
        return usersDAO.save(theUser);
    }
    @Override
    @Transactional
    public void deleteById(int userId) {
        usersDAO.deleteById(userId);
    }
}
