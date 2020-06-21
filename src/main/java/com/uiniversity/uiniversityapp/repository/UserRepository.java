package com.uiniversity.uiniversityapp.repository;

import java.util.HashMap;

import com.uiniversity.uiniversityapp.model.User;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    public HashMap<String, User> hm = new HashMap<String, User>();

    public UserRepository(){
        hm.put("mateus", new User("mateus", "Mateus Gomes","1234"));
    }
    
    public User getUserByLogin(String login){
        return hm.get(login);
    }
}