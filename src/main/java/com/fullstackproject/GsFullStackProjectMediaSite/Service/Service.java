package com.fullstackproject.GsFullStackProjectMediaSite.Service;

import com.fullstackproject.GsFullStackProjectMediaSite.Entity.Comment;
import com.fullstackproject.GsFullStackProjectMediaSite.Entity.Post;
import com.fullstackproject.GsFullStackProjectMediaSite.Entity.UserProfile;
import org.apache.catalina.User;

public interface Service {
    UserProfile createProfile(UserProfile user);
    UserProfile logIn(Long iD);
    Post createPost(Post post);
    Comment commentOnPost(Comment comment);
    UserProfile updateProfile(UserProfile profile);
    Post updatePost(Post post);
    Comment updateComment(Comment comment);
    String deletePost(Long id);
    String deleteComment(Long id);
    String deleteUser(Long id);
}
