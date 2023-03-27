package com.usermanager.usermanager.service;

import com.usermanager.usermanager.model.User;
import com.usermanager.usermanager.repository.UserMangerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author guru5
 */
@Service
public class UserService {

    @Autowired
    UserMangerRepository userMangerRepository;

    //Create serviceImplementation class that has methods to (getById, GetAll, create record, update record, delete record, deleteall records)

    //Create a new user

    /**
     *
     * @param user
     * @return user
     */
    public User createUser(User user){
        return userMangerRepository.save(user);
    }

    //Get All Users

    /**
     *
     * @return List<User>
     */
    public List<User> getAllUsers(){
        return userMangerRepository.findAll();
    }

    //Get user By Id
    public Optional<User> getUserById(int userId){
        return userMangerRepository.findById(userId);
    }

    //Update user
    public User updateUser(User user){
        if(userMangerRepository.findById(user.getUserId()) !=null){
            return userMangerRepository.save(user);
        }
        return null;
    }

    //Delete user
    public boolean deleteUser(User user){
        if(userMangerRepository.findById(user.getUserId()) !=null){
            userMangerRepository.deleteById(user.getUserId());
            return true;
        }
        return false;
    }

    //Delete all records
    public boolean deleteAllUser(){
       userMangerRepository.deleteAll();
       return true;
    }
}
