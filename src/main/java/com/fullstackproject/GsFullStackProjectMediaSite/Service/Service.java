package com.fullstackproject.GsFullStackProjectMediaSite.Service;

import com.fullstackproject.GsFullStackProjectMediaSite.Entity.UserProfile;

public interface Service {
    UserProfile createProfile(UserProfile user);
    UserProfile logIn(Long iD);
}
