package com.example.Usermanagesystem.service;

import com.example.Usermanagesystem.model.User;
import com.example.Usermanagesystem.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class UserService {

    @Autowired
    UserRepo userRepo;
    public  String addUsers(List<User> users) {

        for(User user : users) {
            userRepo.addUser(user);
        }
        return "users are added!!!";
    }


    public List<User> getusers() {
        return userRepo.getAll();
    }

    public String updateUserById(Integer Id,User users) {


        User user = userRepo.getUserById(Id);
        user.setName(users.getName());
        user.setUserName( users.getUserName());
        user.setAddress( users.getAddress());
        user.setPhoneNumber( users.getPhoneNumber());


        return "Users Updated";


    }

    public  String removeUser(Integer id) {


        User user =userRepo.getUserById(id);
        if(user!=null)
        {
            userRepo.remove(id);
            return id + " removed!!!";
        }
        else {
            return id + " not found!!!";
        }
    }

    public User getAllUsersbyId(Integer id) {
        return userRepo.getUserById(id);
    }

}
