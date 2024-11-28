package com.saw.backend_fullstack_user_curd.rest;

import com.saw.backend_fullstack_user_curd.entity.Users;
import com.saw.backend_fullstack_user_curd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@RestController
public class UserRestController {
    private UserService userService;

    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;
    } // end

    // defind endpoint for view all users
    @GetMapping("/users")
    public List<Users> getAllUsers() {
        return userService.findAll();
    } // end

    // defind endpoint for view user by id
    @GetMapping("/users/{userId}")
    public Users getUserById(@PathVariable int userId) {
        Users theUser = userService.findById(userId);
        // trow exceoption if statement to check if user is null or not
        if (theUser== null) {
            throw new RuntimeException("User id not found - " + userId);
        }
        return theUser;
    } // end



    // add endpoint for create user
    @PostMapping("/users")
    public Users createUser(@RequestBody Users theUser) {
        theUser.setId(0);
        Users dbUser = userService.save(theUser);
        return dbUser;
        } // end

    // add endpoint for update user
    @PutMapping("/users")
    public Users updateUser( @RequestBody Users theUser) {
        Users dbUser = userService.save(theUser);
        return dbUser;
    } // end


    // add endpoint for delete user
    @DeleteMapping("/users/{userId}")
    public String deleteUser(@PathVariable int userId) {
       Users tempUser = userService.findById(userId);
       // throw exception if user is null
       if (tempUser == null) {
           throw new RuntimeException("User id not found - " + userId);
       }
       userService.deleteById(userId);
       return "Deleted user id - " + userId;
    }






}
