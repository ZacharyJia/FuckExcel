package me.zacharyjia.fuckexcel.service;

import me.zacharyjia.fuckexcel.model.Admin;
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
public class AdminService {

    private static String ADMIN_COLLECTION = "admin";

    @Autowired
    MongoTemplate mongoTemplate;

    public void saveAdmin(Admin admin) {
        mongoTemplate.save(admin, ADMIN_COLLECTION);
    }

    public void deleteById(String id) {
        mongoTemplate.findAndRemove(new Query(Criteria.where("id").is(id)), Admin.class, ADMIN_COLLECTION);
    }

    public Admin findAdminById(String id) {
        return mongoTemplate.findOne(new Query(Criteria.where("id").is(id)), Admin.class, ADMIN_COLLECTION);
    }
}
