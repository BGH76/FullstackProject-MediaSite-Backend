package com.fullstackproject.GsFullStackProjectMediaSite.Controller;

import com.fullstackproject.GsFullStackProjectMediaSite.Entity.UserProfile;
import com.fullstackproject.GsFullStackProjectMediaSite.Service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    Service service;

    @GetMapping("/")
    public String welcome(){
        return "Hello";
    }

    @PostMapping("/newUser")
    public UserProfile addUser(UserProfile profile){
        return this.service.createProfile(profile);
    }

    @GetMapping("/login")
    public UserProfile logIn(Long id){
        return this.service.logIn(id);
    }
}
