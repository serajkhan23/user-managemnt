package com.example.Usermanagesystem.contoller;

import com.example.Usermanagesystem.model.User;
import com.example.Usermanagesystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("users")
    public String addUsers(@RequestBody List<User> users)
    {
        return userService.addUsers(users);
    }

    @GetMapping("users/byid/{Id}")
    public User getUserId(@PathVariable Integer Id)
    {
        return userService.getAllUsersbyId(Id);
    }

    @GetMapping("users")
    public List<User> getUsers()
    {
        return userService.getusers();
    }

    @PutMapping("users/userid/{Id}")
    public String updateUserbyId(@PathVariable Integer Id,@RequestBody User users)
    {
        return userService.updateUserById(Id,users);
    }
    @DeleteMapping("users/{Id}")
    public String removeUser(@PathVariable Integer Id)
    {
        return userService.removeUser(Id);
    }
}
