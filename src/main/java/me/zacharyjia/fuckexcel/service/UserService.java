package me.zacharyjia.fuckexcel.service;

import me.zacharyjia.fuckexcel.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

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

    public void createUser(User user) {
        mongoTemplate.insert(user, USER_COLLECTION);
    }

    public void deleteById(String id) {
        mongoTemplate.findAndRemove(new Query(Criteria.where("id").is(id)), User.class, USER_COLLECTION);
    }

    public User findUserById(UUID id) {
        return mongoTemplate.findOne(new Query(Criteria.where("id").is(id)), User.class, USER_COLLECTION);
    }
}
