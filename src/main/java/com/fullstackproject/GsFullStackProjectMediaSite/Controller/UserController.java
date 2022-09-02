package com.fullstackproject.GsFullStackProjectMediaSite.Controller;

import com.fullstackproject.GsFullStackProjectMediaSite.Entity.Comment;
import com.fullstackproject.GsFullStackProjectMediaSite.Entity.Friends;
import com.fullstackproject.GsFullStackProjectMediaSite.Entity.Post;
import com.fullstackproject.GsFullStackProjectMediaSite.Entity.UserProfile;
import com.fullstackproject.GsFullStackProjectMediaSite.Service.Service;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

@RestController
public class UserController {

    @Autowired
    Service service;

    UserProfile findByUsername(String username){
        return this.service.findByUsername(username);
    }

    @GetMapping("/")
    public String welcome(){
        return "Hello";
    }

    @GetMapping("/user/friends_post/{id}") //Use this to extract the Jason you need for the front end
    public List<Map<String,Object>> userFriendPost(@PathVariable String id){
        return this.service.onLogIn(Long.parseLong(id));
    }

    @GetMapping("/post/{id}")
    public List<Post> findAllPostByUser(@PathVariable Long id){
        return this.service.findAllPostByUser(id);
    }

    @GetMapping("/post/comment/{id}")
    public List<Comment> findAllCommentByPost(@PathVariable Long id){
        return this.service.findAllCommentByPost(id);
    }

    @GetMapping("/users")
    public List<UserProfile> findAllUsers(){
        return this.service.findAllUsers();
    }

    @GetMapping("/post/comment")
    public List<Comment> findAllComments(){
        return this.service.findAllComment();
    }

    @GetMapping("/post")
    public List<Post> findAllPosts(){
        return this.service.findAllPost();
    }

    @PostMapping("/create_profile")
    public UserProfile addUser(@RequestBody UserProfile profile){
        System.out.println("Last name"+profile.getFirstName());
        return this.service.createProfile(profile);
    }

    @GetMapping("/user/{id}")
    public UserProfile userLogIn(@PathVariable String id){
        return this.service.findUser(Long.parseLong(id));
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
    public String deActivateAccount(@PathVariable String id){
        return this.service.deleteUser(Long.parseLong(id));
    }

    @PostMapping("/login/friend_request")
    public Friends requestFriendship(@RequestBody Friends friends){
        return this.service.requestFrienship(friends);
    }

    @GetMapping("/login/friends/{id}")
    public List<UserProfile> showAllFriends(@PathVariable Long id){
        return this.service.showAllFriends(id);
    }

    /*
    @GetMapping("/user/friends_post/{id}")
    public List<JSONObject> userFriendPost(@PathVariable String id){
        System.out.println("*************************************************");
        System.out.println(this.service.onLogIn(Long.parseLong(id)));
        System.out.println("*************************************************");

        return this.service.onLogIn(Long.parseLong(id));
    }*/

}
