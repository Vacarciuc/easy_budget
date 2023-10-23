package com.example.test.services;

import com.example.test.dao.UserDao;
import com.example.test.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class UserServices{

    @Autowired
    UserDao userDao;



    public void registerUser(String firstName, String lastName, String email, String password, String gender, LocalDate dataOfBirth){
        User user=new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPassword(password);
        user.setGender(gender);
        user.setDateOfBirth(dataOfBirth);
        userDao.save(user);
    }

    public List<User> loginUser(String email, String password) throws UserException{
        List<User> userList = userDao.findByEmail(email);

        if (userList.isEmpty()) {
            throw new UserException("user/parola incorecte");
        }

        if (!userList.get(0).getPassword().equals(password)) {
            throw new UserException("user/parola incorecte");
        }
        return userList;
    }


}
