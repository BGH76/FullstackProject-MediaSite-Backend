package com.fullstackproject.GsFullStackProjectMediaSite.Service;

import com.fullstackproject.GsFullStackProjectMediaSite.Dao.CommentsDao;
import com.fullstackproject.GsFullStackProjectMediaSite.Dao.FriendsDao;
import com.fullstackproject.GsFullStackProjectMediaSite.Dao.PostDao;
import com.fullstackproject.GsFullStackProjectMediaSite.Dao.UserDao;
import com.fullstackproject.GsFullStackProjectMediaSite.Entity.Comment;
import com.fullstackproject.GsFullStackProjectMediaSite.Entity.Friends;
import com.fullstackproject.GsFullStackProjectMediaSite.Entity.Post;
import com.fullstackproject.GsFullStackProjectMediaSite.Entity.UserProfile;
import netscape.javascript.JSObject;
import org.hibernate.annotations.LazyToOne;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

import org.json.JSONObject;
import org.json.JSONException;

@org.springframework.stereotype.Service
public class ServiceImpl implements Service{

    @Autowired
    UserDao userDao;
    @Autowired
    PostDao postDao;
    @Autowired
    CommentsDao commentsDao;

    @Autowired
    FriendsDao friendsDao;

    @Override
    public List<Map<String,Object>> onLogIn(Long id){

        List<Map<String,Object>> list = new ArrayList<>();
        Optional<UserProfile> opt = this.userDao.findById(id);
        if(opt.isPresent())
        {
            for(UserProfile u : showAllFriends(id)){
                list.addAll(findAllPostByUserAsString(u));
            }
        };
        return list;
    }
    @Override
    public List<Map<String,Object>> findAllPostByUserAsString(UserProfile u){
        List<Map<String,Object>> list = new ArrayList<>();
        Map<String,Object> map;

        for(Post p:findAllPostByUser(u.getId())) {
            map = new HashMap<>();
            map.put("name",u.getName());
            map.put("date",p.getDate());
            map.put("post",p.getPost());
            map.put("comments",findAllCommentByPostAsString(p.getId()));
            list.add(map);
        }

        return list;
    }

    @Override
    public Map<Long,String> findAllCommentByPostAsString(Long id) {
        List<Comment> list = findAllCommentByPost(id);
        Map<Long,String> map= new HashMap<>();

        for(Comment c: list){
            map.put(c.getId(),c.getComment());
        }
        return  map;
    }

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
    public List<UserProfile> findAllUsers() {
        return this.userDao.findAll();
    }

    @Override
    public List<Comment> findAllComment() {
        return this.commentsDao.findAll();
    }

    @Override
    public List<Post> findAllPost() {
        return this.postDao.findAll();
    }

    @Override
    public List<Post> findAllPostByUser(Long id) {
        List<Post> res = new ArrayList<>();
        for(Post p : this.postDao.findAll()){
            if(p.getUserId() == id){
                res.add(p);
            }
        }
        return res;
    }

    @Override
    public List<Comment> findAllCommentByPost(Long id) {
        List<Comment> res = new ArrayList<>();
        for(Comment c : this.commentsDao.findAll()){
            if(c.getPostId() == id){
                res.add(c);
            }
        }
        return res;
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
    public Friends requestFrienship(Friends friends) {
        return this.friendsDao.save(friends);
    }

    @Override
    public List<UserProfile> showAllFriends(Long id) {
        List<UserProfile> res = new ArrayList<>();
        for(Friends f : this.friendsDao.findAll()){

            if(f.getUserOneId() == id & f.isFriend()){
                res.add(this.userDao.findById(f.getUserTwoId()).get());
            }
            else if (f.getUserTwoId() == id & f.isFriend()){
                res.add(this.userDao.findById(f.getUserOneId()).get());
            }
        }
        return res;
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

    /*
    @Override
    public List<JSONObject> onLogIn(Long id){

        List<JSONObject> list = new ArrayList<>();
        Optional<UserProfile> opt = this.userDao.findById(id);
        if(opt.isPresent())
        {
            for(UserProfile u : showAllFriends(id)){
                //System.out.println(findAllPostByUserAsString(u));
                list.addAll(findAllPostByUserAsString(u));
            }
        }
        //System.out.println(list);
        return list;
    }

    @Override
    public List<JSONObject> findAllPostByUserAsString(UserProfile u){
        String str = "{";
        List<JSONObject> jsonList = new ArrayList<>();

        for(Post p:findAllPostByUser(u.getId())) {

            str += "\"name\":\""+ u.getName()+"\",\"date\":\"" + p.getDate() +"\",\"post\":\"" +p.getPost()+"\",\"comments\":" + findAllCommentByPostAsString(p.getId())+"}";
            jsonList.add(new JSONObject(str));
        }

        return jsonList;
    }

    @Override
    public String findAllCommentByPostAsString(Long id) {
        String str = "{";
        List<Comment> list = findAllCommentByPost(id);
        Comment c;
        for(int i = 0 ; i < list.size(); i++){

            c = list.get(i);
            str += "\""+c.getId() +"\":\""+c.getComment()+"\"";

            if(i != list.size()-1)
                str += ",";
        }
        str += "}";
        return str;
    }
*/


}
