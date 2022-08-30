package com.fullstackproject.GsFullStackProjectMediaSite.Dao;

import com.fullstackproject.GsFullStackProjectMediaSite.Entity.Comment;
import com.fullstackproject.GsFullStackProjectMediaSite.Entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentsDao extends JpaRepository<Comment, Long> {
}
