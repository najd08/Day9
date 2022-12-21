package com.example.assignment_day8.Service;

import com.example.assignment_day8.Exception.ApiException;
import com.example.assignment_day8.Model.User;
import com.example.assignment_day8.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service @RequiredArgsConstructor
public class UserServices {
    private final UserRepository userRepository;

    public List<User> getUser(){
        return userRepository.findAll();
    }

    public void addUser(User user){
        userRepository.save(user);
    }

    public boolean updateUser(Integer id, User user){
        User preUser= userRepository.getById(id);
        if (preUser==null)
            return false;
        preUser.setAge(user.getAge());
        preUser.setRole(user.getRole());
        preUser.setName(user.getName());
        preUser.setEmail(user.getEmail());
        preUser.setUsername(user.getUsername());
        preUser.setPassword(user.getPassword());

        userRepository.save(preUser);
        return true;
    }

    public boolean deleteUser(Integer id){
        User user= userRepository.getById(id);
        if (user==null)
            return false;

        userRepository.delete(user);
        return true;
    }
    public User getUserById(Integer id){
        User user=userRepository.findUserById(id);
        if (user==null)
            throw new ApiException("no such an id was found");
        return user;
    }
    public User getUserByRole(String role){
        User user=userRepository.findAllByRole(role);
        if (user==null)
            throw new ApiException("there are no users match with role");
        return user;
    }
    public User getUserAgeormore(Integer age){
        User user=userRepository.findAllByAgeGreaterThanEqual(age);
        if (user==null)
            throw new ApiException("no matching age");
        return user;
    }
    public User getUserEmail(String email){
        User user=userRepository.findUserByEmail(email);
        if (user==null)
            throw new ApiException("no matching email was found!");
        return user;
    }
    public User checkUsernameandpass(String username,Integer password){
        User user = userRepository.findUserByUsername(username);
        if(user == null) {
            throw new RuntimeException("User does not exist.");
        }
        if(!user.getPassword().equals(password)){
            throw new RuntimeException("Password mismatch.");
        }
        return user ;
    }

}
