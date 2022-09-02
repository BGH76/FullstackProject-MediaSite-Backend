package com.fullstackproject.GsFullStackProjectMediaSite.Service;

import com.fullstackproject.GsFullStackProjectMediaSite.Entity.Comment;
import com.fullstackproject.GsFullStackProjectMediaSite.Entity.Friends;
import com.fullstackproject.GsFullStackProjectMediaSite.Entity.Post;
import com.fullstackproject.GsFullStackProjectMediaSite.Entity.UserProfile;
import org.apache.catalina.User;
import org.json.JSONObject;

import java.util.List;
import java.util.Map;

public interface Service {
    Map<String,Object> login(String[] uNamePass);
    UserProfile findByUsername(String username);
    List<Map<String,Object>> onLogIn(Long id);
    List<Map<String,Object>> findAllPostByUserAsString(UserProfile u);
    Map<Long,Map<String,String>> findAllCommentByPostAsString(Long id);
    UserProfile createProfile(UserProfile user);
    UserProfile findUser(Long iD);
    List<UserProfile> findAllUsers();
    List<Comment> findAllComment();
    List<Post> findAllPost();
    List<Post> findAllPostByUser(Long id);
    List<Comment> findAllCommentByPost(Long id);
    Post createPost(Post post);
    Comment commentOnPost(Comment comment);
    Friends requestFrienship(Friends friends);
    List<UserProfile> showAllFriends(Long id);
    UserProfile updateProfile(UserProfile profile);
    Post updatePost(Post post);
    Comment updateComment(Comment comment);
    String deletePost(Long id);
    String deleteComment(Long id);
    String deleteUser(Long id);

        /*
    List<JSONObject> onLogIn(Long id);
    List<JSONObject> findAllPostByUserAsString(UserProfile u);
    String findAllCommentByPostAsString(Long id);*/
}
