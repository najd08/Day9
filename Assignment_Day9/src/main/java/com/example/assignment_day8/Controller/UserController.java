package com.example.assignment_day8.Controller;

import com.example.assignment_day8.ApiResponse;
import com.example.assignment_day8.Model.User;
import com.example.assignment_day8.Service.UserServices;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequestMapping("/api/v1") @RequiredArgsConstructor
public class UserController {
    private final UserServices userServices;
    @GetMapping("/get")
    public ResponseEntity getUser(){
        List<User> users= userServices.getUser();
        return ResponseEntity.status(200).body(users);
    }
    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody @Valid User user){
        userServices.addUser(user);
        return ResponseEntity.status(200).body(new ApiResponse("User have been added!"));
    }
   @PutMapping("/update/{index}")
    public ResponseEntity updateUser(@PathVariable Integer id, @RequestBody @Valid User user){
        userServices.updateUser(id,user);
        return ResponseEntity.status(200).body(new ApiResponse("User updated!"));
    }
    @DeleteMapping("/delete/{index}")
    public String deleteUser(Integer id){
        userServices.deleteUser(id);
        return "user has been deleted";
    }
    @GetMapping("/byid/{id}")
    public ResponseEntity getUserbyId(@PathVariable Integer id){
        User user=userServices.getUserById(id);
        return ResponseEntity.status(200).body(user);
    }
    @GetMapping("/byemail/{email}")
    public ResponseEntity getUserbyEmail(@PathVariable String email){
        User user=userServices.getUserEmail(email);
        return ResponseEntity.status(200).body(user);
    }
    @GetMapping("/byrole/{role}")
    public ResponseEntity getUserbyRole(@PathVariable String role){
        User user=userServices.getUserByRole(role);
        return ResponseEntity.status(200).body(user);
    }
    @GetMapping("/byagegreater/{age}")
    public ResponseEntity getUserEqorGreater(@PathVariable Integer age){
        User user=userServices.getUserAgeormore(age);
        return ResponseEntity.status(200).body(user);
    }
    @GetMapping("/checkpass/{username}/{password}")
    public ResponseEntity checkUsernameandpass(@PathVariable String username,@PathVariable Integer password){
        User user=userServices.checkUsernameandpass(username,password);
        return ResponseEntity.status(200).body(user);
    }
}
