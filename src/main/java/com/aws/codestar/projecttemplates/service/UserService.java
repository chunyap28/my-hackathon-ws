/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aws.codestar.projecttemplates.service;

import com.aws.codestar.projecttemplates.entity.User;
import com.aws.codestar.projecttemplates.repository.UserRepository;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author chunyap
 */
@Service
public class UserService {
    
    @Autowired
    private UserRepository repo;
 
    //@Autowired
    //UserRepository repository;
    
    public User addUser(String name){
        User newUser = new User(UUID.randomUUID().toString(), name);
        repo.save(newUser);
        return newUser;
    }
    
    public User getUser(String id){
        //return new User("test");
        return repo.findOne(id);
    }
}
