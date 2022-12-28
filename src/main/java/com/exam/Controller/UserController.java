package com.exam.Controller;

import com.exam.Entity.Role;
import com.exam.Entity.User;
import com.exam.Entity.UserRole;
import com.exam.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @PostMapping("/create")
    public User createUser(@RequestBody User user) throws Exception {

        Set<UserRole> roles=new HashSet<>();

        Role role =new Role();
        role.setRoleName("NORMAL");
        role.setRoleId(24L);

        UserRole userRole =new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);

        roles.add(userRole);

        return this.userService.createUser(user,roles);
    }

    // Get user by Username
    @GetMapping("/{username}")
    public  User getUserByName(@PathVariable("username") String username){
       return  this.userService.getUserByName(username);
    }

    // Get all users
    @GetMapping("/all")
    public List<User> getAllUsers(){
        return this.userService.getAllUsers();
    }

    // Delete user by userId
    @DeleteMapping("/{userId}")
    public  String deleteUserById(@PathVariable("userId") Long userId){
        this.userService.deleteById(userId);
        return "User deleted Successfully with id"+userId;
    }

    // Update user by user id
    @PutMapping("/update/{id}")
    public  User updateUserById(@PathVariable ("id") Long id, @RequestBody  User user){
        return this.userService.updateUserById(id,user);
    }
}
