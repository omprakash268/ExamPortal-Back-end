package com.exam.Service;

import com.exam.Entity.User;
import com.exam.Entity.UserRole;


import java.util.List;
import java.util.Set;


public interface UserService {

    // Creating User
    public  User createUser(User user, Set<UserRole> userRoles) throws Exception;

    // get user by userName
    public  User getUserByName(String username);

    // delete user by userId
    public  void deleteById(Long userId);

    // Get all users list
    public List<User> getAllUsers();

    // Update user by userId
    public  User updateUserById(Long id,User user);
}
