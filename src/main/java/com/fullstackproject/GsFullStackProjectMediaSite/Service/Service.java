package com.fullstackproject.GsFullStackProjectMediaSite.Service;

import com.fullstackproject.GsFullStackProjectMediaSite.Entity.Comment;
import com.fullstackproject.GsFullStackProjectMediaSite.Entity.Post;
import com.fullstackproject.GsFullStackProjectMediaSite.Entity.UserProfile;
import org.apache.catalina.User;

import java.util.List;

public interface Service {
    UserProfile createProfile(UserProfile user);
    UserProfile logIn(Long iD);
    List<UserProfile> findAllUsers();
    List<Comment> findAllComment();
    List<Post> findAllPost();
    List<Post> findAllPostByUser(Long id);
    List<Comment> findAllCommentByPost(Long id);
    Post createPost(Post post);
    Comment commentOnPost(Comment comment);
    UserProfile updateProfile(UserProfile profile);
    Post updatePost(Post post);
    Comment updateComment(Comment comment);
    String deletePost(Long id);
    String deleteComment(Long id);
    String deleteUser(Long id);
}
