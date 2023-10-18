package com.example.test.controller;

import com.example.test.model.User;
import com.example.test.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;


    @PostMapping(path = "/adduser")
    public @ResponseBody String addUser(@RequestParam String firstName,
                                        @RequestParam String lastName,
                                        @RequestParam String email,
                                        @RequestParam String password,
                                        @RequestParam String gender,
                                        @RequestParam LocalDate dataOfBrith){
        User user=new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPassword(password);
        user.setGender(gender);
        user.setDateOfBrith(dataOfBrith);
        userRepository.save(user);
        return "User was saved";
    }

    @GetMapping(path = "/getusers")
    public @ResponseBody Iterable<User> getAllUsers(){
        return userRepository.findAll();
    }



}
