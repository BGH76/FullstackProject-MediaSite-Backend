package com.fullstackproject.GsFullStackProjectMediaSite;

import com.fullstackproject.GsFullStackProjectMediaSite.Dao.CommentsDao;
import com.fullstackproject.GsFullStackProjectMediaSite.Dao.FriendsDao;
import com.fullstackproject.GsFullStackProjectMediaSite.Dao.PostDao;
import com.fullstackproject.GsFullStackProjectMediaSite.Dao.UserDao;
import com.fullstackproject.GsFullStackProjectMediaSite.Entity.Comment;
import com.fullstackproject.GsFullStackProjectMediaSite.Entity.Friends;
import com.fullstackproject.GsFullStackProjectMediaSite.Entity.Post;
import com.fullstackproject.GsFullStackProjectMediaSite.Entity.UserProfile;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Arrays;

@SpringBootApplication
public class GsFullStackProjectMediaSiteApplication {

	public static void main(String[] args) {
		SpringApplication.run(GsFullStackProjectMediaSiteApplication.class, args);
	}

	@Bean
	ApplicationRunner init(UserDao userDao, FriendsDao friendsDao,PostDao postDao, CommentsDao commentsDao){
		return args -> {
			userDao.saveAll(Arrays.asList(UserProfile.builder().id(1L).firstName("Geo").lastName("Leo").email("Geo@gmail.com").password("12345").userName("GLeo").active(Boolean.TRUE).build(),
					UserProfile.builder().id(2L).firstName("Mark").lastName("Smith").email("Smith@gmail.com").password("12345").userName("MSmith").active(Boolean.TRUE).build(),
					UserProfile.builder().id(3L).firstName("Tom").lastName("Hanks").email("Hanks@gmail.com").password("12345").userName("THanks").active(Boolean.TRUE).build(),
					UserProfile.builder().id(4L).firstName("Ray").lastName("Light").email("Light@gmail.com").password("12345").userName("RLight").active(Boolean.TRUE).build()));
			friendsDao.saveAll(Arrays.asList(Friends.builder().id(10L).userOneId(1L).userTwoId(2L).friend(Boolean.TRUE).requested(Boolean.TRUE).build(),
					Friends.builder().id(12L).userOneId(1L).userTwoId(3L).friend(Boolean.TRUE).requested(Boolean.TRUE).build(),
					Friends.builder().id(13L).userOneId(1L).userTwoId(4L).friend(Boolean.TRUE).requested(Boolean.TRUE).build(),
					Friends.builder().id(14L).userOneId(2L).userTwoId(3L).friend(Boolean.TRUE).requested(Boolean.TRUE).build()));
			postDao.saveAll(Arrays.asList(Post.builder().id(10L).userId(1L).post("This is post1 by 1").date(LocalDate.now()).build(),
					Post.builder().id(11L).userId(1L).post("This is post2 by 1").date(LocalDate.now()).build(),
					Post.builder().id(12L).userId(2L).post("This is post1 by 2").date(LocalDate.now()).build(),
					Post.builder().id(13L).userId(2L).post("This is post2 by 2").date(LocalDate.now()).build(),
					Post.builder().id(14L).userId(2L).post("This is post3 by 3").date(LocalDate.now()).build(),
					Post.builder().id(15L).userId(3L).post("This is post1 by 3").date(LocalDate.now()).build()));
			commentsDao.saveAll(Arrays.asList(Comment.builder().id(16L).postId(10L).userId(2L).comment("This is the comment on 10L by 2").build(),
					Comment.builder().id(17L).postId(10L).userId(3L).comment("This is the comment on 10L by 3").build(),
					Comment.builder().id(18L).postId(10L).userId(4L).comment("This is the comment on 10L by 4").build(),
					Comment.builder().id(19L).postId(11L).userId(2L).comment("This is the comment on 11L by 2").build(),
					Comment.builder().id(20L).postId(11L).userId(4L).comment("This is the comment on 11L by 4").build(),
					Comment.builder().id(21L).postId(12L).userId(1L).comment("This is the comment on 12L by 1").build(),
					Comment.builder().id(22L).postId(12L).userId(3L).comment("This is the comment on 12L by 3").build(),
					Comment.builder().id(23L).postId(13L).userId(1L).comment("This is the comment on 13L by 1").build(),
					Comment.builder().id(24L).postId(15L).userId(2L).comment("This is the comment on 15L by 2").build(),
					Comment.builder().id(25L).postId(15L).userId(1L).comment("This is the comment on 16L by 1").build()));
		};
	}

}
