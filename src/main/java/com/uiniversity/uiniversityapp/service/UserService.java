package com.uiniversity.uiniversityapp.service;

import com.uiniversity.uiniversityapp.model.User;
import com.uiniversity.uiniversityapp.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    @Autowired
    private UserRepository ur;

    public User getUserByLogin(String login, String pwd){
        User user = ur.getUserByLogin(login);

        if (user != null){
            if (!user.getPwd().equals(pwd)) {
                user = null;
            }
        }

        return user;

    }
}