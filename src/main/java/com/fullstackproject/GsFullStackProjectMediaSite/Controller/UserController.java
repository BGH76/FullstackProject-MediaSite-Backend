package com.fullstackproject.GsFullStackProjectMediaSite.Controller;

import com.fullstackproject.GsFullStackProjectMediaSite.Entity.Comment;
import com.fullstackproject.GsFullStackProjectMediaSite.Entity.Post;
import com.fullstackproject.GsFullStackProjectMediaSite.Entity.UserProfile;
import com.fullstackproject.GsFullStackProjectMediaSite.Service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    Service service;

    @GetMapping("/")
    public String welcome(){
        return "Hello";
    }

    @PostMapping("/createProfile")
    public UserProfile addUser(@RequestBody UserProfile profile){
        System.out.println("Last name"+profile.getFirstName());
        return this.service.createProfile(profile);
    }

    @GetMapping("/login/{id}")
    public UserProfile logIn(@PathVariable String id){
        return this.service.logIn(Long.parseLong(id));
    }

    @PostMapping("/post")
    public Post createPost(@RequestBody Post post){
        return this.service.createPost(post);
    }

    @PostMapping("/post/comment")
    public Comment commentOnPost(@RequestBody Comment comment){
        return this.service.commentOnPost(comment);
    }

    @PutMapping("/post/update")
    public Post editPost(@RequestBody Post post){
        return this.service.updatePost(post);
    }

    @PutMapping("/post/comment/update")
    public Comment editComment(@RequestBody Comment comment){
        return this.service.updateComment(comment);
    }

    @DeleteMapping("/post/{id}")
    public String deletePost(@PathVariable String id){
        return this.service.deletePost(Long.parseLong(id));
    }

    @DeleteMapping("/post/comment/{id}")
    public String deleteComment(@PathVariable String id){
        return this.service.deleteComment(Long.parseLong(id));
    }

    @DeleteMapping("/login/{id}")
    public String deleteAccount(@PathVariable String id){
        return this.service.deleteUser(Long.parseLong(id));
    }
}
