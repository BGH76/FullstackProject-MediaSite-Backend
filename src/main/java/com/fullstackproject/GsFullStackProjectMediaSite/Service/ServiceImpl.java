package com.fullstackproject.GsFullStackProjectMediaSite.Service;

import com.fullstackproject.GsFullStackProjectMediaSite.Dao.CommentsDao;
import com.fullstackproject.GsFullStackProjectMediaSite.Dao.PostDao;
import com.fullstackproject.GsFullStackProjectMediaSite.Dao.UserDao;
import com.fullstackproject.GsFullStackProjectMediaSite.Entity.Comment;
import com.fullstackproject.GsFullStackProjectMediaSite.Entity.Post;
import com.fullstackproject.GsFullStackProjectMediaSite.Entity.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@org.springframework.stereotype.Service
public class ServiceImpl implements Service{

    @Autowired
    UserDao userDao;
    @Autowired
    PostDao postDao;
    @Autowired
    CommentsDao commentsDao;

    @Override
    public UserProfile createProfile(UserProfile user) {
        return this.userDao.save(user);
    }

    @Override
    public UserProfile logIn(Long iD) {
        UserProfile user = null;
        Optional<UserProfile> opt = this.userDao.findById(iD);
        if(opt.isPresent())
            user = opt.get();
        else {
            throw new RuntimeException("Thee is no user with this iD");
        }
        return user;
    }

    @Override
    public Post createPost(Post post) {
        return this.postDao.save(post);
    }

    @Override
    public Comment commentOnPost(Comment comment) {
        return this.commentsDao.save(comment);
    }

    @Override
    public UserProfile updateProfile(UserProfile profile) {
        return this.userDao.save(profile);
    }

    @Override
    public Post updatePost(Post post) {
        return this.postDao.save(post);
    }

    @Override
    public Comment updateComment(Comment comment) {
        return this.commentsDao.save(comment);
    }

    @Override
    public String deletePost(Long id) {
        this.postDao.deleteById(id);
        return "Successfully Deleted";
    }

    @Override
    public String deleteComment(Long id) {
        this.commentsDao.deleteById(id);
        return "Successfully Deleted";
    }

    @Override
    public String deleteUser(Long id) {
        UserProfile profile = null;
        Optional<UserProfile> opt = this.userDao.findById(id);
        if(opt.isPresent()){
            profile=opt.get();
            profile.setActive(Boolean.FALSE);
        }
        updateProfile(profile);
        return "Account is successfully deactivated";
    }


}
