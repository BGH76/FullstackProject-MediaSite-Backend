package com.fullstackproject.GsFullStackProjectMediaSite.Dao;

import com.fullstackproject.GsFullStackProjectMediaSite.Entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostDao extends JpaRepository<Post, Long> {
}
