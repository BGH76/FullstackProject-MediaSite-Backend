package com.fullstackproject.GsFullStackProjectMediaSite.Service;

import com.fullstackproject.GsFullStackProjectMediaSite.Entity.Comment;
import com.fullstackproject.GsFullStackProjectMediaSite.Entity.Post;
import com.fullstackproject.GsFullStackProjectMediaSite.Entity.UserProfile;

public interface Service {
    UserProfile createProfile(UserProfile user);
    UserProfile logIn(Long iD);
    Post createPost(Post post);
    Comment commentOnPost(Comment comment);
}
