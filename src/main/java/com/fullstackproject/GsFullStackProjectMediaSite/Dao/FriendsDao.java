package com.fullstackproject.GsFullStackProjectMediaSite.Dao;

import com.fullstackproject.GsFullStackProjectMediaSite.Entity.Friends;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FriendsDao extends JpaRepository<Friends, Long> {
}
