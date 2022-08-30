package com.fullstackproject.GsFullStackProjectMediaSite.Service;

import com.fullstackproject.GsFullStackProjectMediaSite.Dao.UserDao;
import com.fullstackproject.GsFullStackProjectMediaSite.Entity.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@org.springframework.stereotype.Service
public class ServiceImpl implements Service{

    @Autowired
    UserDao userDao;

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
}
