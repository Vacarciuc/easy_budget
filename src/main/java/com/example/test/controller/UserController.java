package com.example.test.controller;

import com.example.test.model.User;
import com.example.test.repository.UserRepository;
import com.example.test.security.UserSession;
import com.example.test.services.UserException;
import com.example.test.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    UserSession userSession;

    @Autowired
    UserServices userServices;


    ///adauga verificari si limitari
    @PostMapping(path = "/adduser")
    public @ResponseBody String addUser(@RequestParam String firstName,
                                        @RequestParam String lastName,
                                        @RequestParam String email,
                                        @RequestParam String password,
                                        @RequestParam String gender,
                                        @RequestParam LocalDate dataOfBirth){
//        UserServices userServices=new UserServices();
        userServices.registerUser(firstName, lastName, email, password, gender, dataOfBirth);
        return "User was saved";
    }


    /**Only for test*/
//    @GetMapping(path = "/getusers")
//    public @ResponseBody Iterable<User> getAllUsers(){
//        return userRepository.findAll();
//    }

    @PostMapping(path = "/login")
    public @ResponseBody String login(@RequestParam String email,
                                      @RequestParam String password) throws Exception {
        List<User>userList;
        try {
            userList=userServices.loginUser(email, password);
        }catch (UserException e){
            throw new Exception("Eroare aici");
        }
        userSession.setId(userList.get(0).getId());
        return "Login succes";
    }

}
