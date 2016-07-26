package me.zacharyjia.fuckexcel.service;

import me.zacharyjia.fuckexcel.model.SuperAdmin;
import me.zacharyjia.fuckexcel.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Created by zachary on 16/7/9.
 */
@Service
public class UserService {

    private static String USER_COLLECTION = "user";

    @Autowired
    MongoTemplate mongoTemplate;

    public void saveUser(User user) {
        mongoTemplate.save(user, USER_COLLECTION);
    }

    public boolean createUser(User user) {
        if (user == null) {
            return false;
        }
        long count = mongoTemplate.count(new Query(Criteria.where("username").is(user.getUsername())),
                User.class, USER_COLLECTION);
        if (count > 0) {
            return false;
        }
        mongoTemplate.save(user, USER_COLLECTION);
        return true;
    }

    public void deleteById(String id) {
        mongoTemplate.findAndRemove(new Query(Criteria.where("id").is(id)), User.class, USER_COLLECTION);
    }

    public User findUserById(String id) {
        return mongoTemplate.findOne(new Query(Criteria.where("id").is(id)), User.class, USER_COLLECTION);
    }

    public User findUserByUsername(String username) {
        return mongoTemplate.findOne(new Query(Criteria.where("username").is(username)),
                User.class, USER_COLLECTION);
    }

    public List<User> findUsersByTag(String tag) {
        return mongoTemplate.find(new Query(Criteria.where("tags").in(tag)),
                User.class, USER_COLLECTION);
    }

    public long getUserCount() {
        return mongoTemplate.count(null, User.class, USER_COLLECTION);
    }

    public List<User> findUsers(int limit, int offset) {
        return mongoTemplate.find(new Query().skip(offset).limit(limit),
                User.class, USER_COLLECTION);
    }

}
