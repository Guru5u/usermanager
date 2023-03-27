package com.usermanager.usermanager.controller;


import com.usermanager.usermanager.Helper.Helper;
import com.usermanager.usermanager.model.User;
import com.usermanager.usermanager.request.UserRequestBody;
import com.usermanager.usermanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserManagerController {
    @Autowired
    UserService userService;

    @Autowired
    Helper helper;

   // Create Controller class for these operations(getById, GetAll, create record, update record, delete record, deleteall records)
    @PostMapping("/createUser")
    public ResponseEntity<User> createUser(@RequestBody UserRequestBody userRequestBody){

        User user = helper.getUserDetails(userRequestBody.getUserManagerRequest());
        User createdUser = userService.createUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.OK);
    }
    @GetMapping("/getAllUsers")
    public ResponseEntity<List<User>> getAllUsers(){

        List<User> allUsers = userService.getAllUsers();
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }

    @GetMapping("/getUserById/{userId}")
    public ResponseEntity<Optional<User>> getUserById(@PathVariable int userId){
        Optional<User> user = userService.getUserById(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);

    }

    @DeleteMapping("/removeAllUsers")
    public ResponseEntity<Boolean> removeAllUsers(){

        boolean allDeleted = userService.deleteAllUser();
        return new ResponseEntity<>(allDeleted, HttpStatus.OK);
    }

    @DeleteMapping("/removeUserById")
    public ResponseEntity<Boolean> getUserById(@RequestBody UserRequestBody userRequestBody){
        User user = helper.getUserDetails(userRequestBody.getUserManagerRequest());
        boolean userRemoved = userService.deleteUser(user);
        return new ResponseEntity<>(userRemoved, HttpStatus.OK);

    }

    @PutMapping("/updateUserById")
    public ResponseEntity<User> updateUserById(@RequestBody UserRequestBody userRequestBody){
        User user = helper.getUserDetails(userRequestBody.getUserManagerRequest());
        User updatedUser = userService.updateUser(user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);

    }

}
