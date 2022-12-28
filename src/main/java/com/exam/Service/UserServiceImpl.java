package com.exam.Service;

import com.exam.Entity.User;
import com.exam.Entity.UserRole;
import com.exam.Repository.RoleRepository;
import com.exam.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.script.ScriptTemplateConfig;

import java.util.List;
import java.util.Set;


@Service
public class UserServiceImpl implements  UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    // Creating user
    @Override
    public User createUser(User user, Set<UserRole> userRoles) throws Exception {

        User local=this.userRepository.findByUsername(user.getUsername());
        if (local!=null){
            System.out.println("User is already present !");
            throw new Exception("user is already present !!");
        }else {
            for (UserRole ur:userRoles){
                this.roleRepository.save(ur.getRole());
            }
            user.getUserRole().addAll(userRoles);
            User user1=this.userRepository.save(user);
            return user1;
        }

    }

    @Override
    public User getUserByName(String username) {
        return this.userRepository.findByUsername(username);
    }

    @Override
    public void deleteById(Long userId) {
        this.userRepository.deleteById(userId);
    }

    @Override
    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }


    @Override
    public User updateUserById(Long id, User user) {

        User user1=this.userRepository.findById(id).orElseThrow();
        user1.setFirstName(user.getFirstName());
        user1.setLastName(user.getLastName());
        user1.setPhone(user.getPhone());

        return user1;
    }
}
