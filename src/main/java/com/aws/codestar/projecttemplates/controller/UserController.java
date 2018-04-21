/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aws.codestar.projecttemplates.controller;

import com.aws.codestar.projecttemplates.entity.User;
import com.aws.codestar.projecttemplates.service.UserService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 *
 * @author chunyap
 */
@RestController
@EnableWebMvc
public class UserController {
    @Autowired private UserService serv;
    
    @RequestMapping(path = "/user", method = RequestMethod.POST)
    public Map<String,String> addUser(
            @RequestParam(value="name") String name){
        User user = serv.addUser(name);
        return user.toMap();
    }
    
    @RequestMapping(path = "/user", method = RequestMethod.GET)
    public Map<String,String> getUser(
            @RequestParam(value="id") String id){
        return serv.getUser(id).toMap();
    }
}
