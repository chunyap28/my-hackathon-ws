/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aws.codestar.projecttemplates.controller;

import com.aws.codestar.projecttemplates.service.ComprehendService;
import java.util.HashMap;
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
public class TestController {
    
    @Autowired private ComprehendService serv;        
    
    @RequestMapping(path = "/comprehend", method = RequestMethod.GET)
    public Map<String, String> getComprehend(
            @RequestParam(value="input") String input){

        return serv.getSentiment(input);        
    }
}
