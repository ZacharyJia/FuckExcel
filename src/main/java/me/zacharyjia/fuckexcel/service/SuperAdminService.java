package me.zacharyjia.fuckexcel.service;

import me.zacharyjia.fuckexcel.model.SuperAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

/**
 * Created by zachary on 16/7/9.
 */
@Service
public class SuperAdminService {

    private static String SUPER_ADMIN_COLLECTION = "super_admin";

    @Autowired
    MongoTemplate mongoTemplate;

    public void saveAdmin(SuperAdmin superAdmin) {
        mongoTemplate.save(superAdmin, SUPER_ADMIN_COLLECTION);
    }

    public void deleteById(String id) {
        mongoTemplate.findAndRemove(new Query(Criteria.where("id").is(id)),
                SuperAdmin.class, SUPER_ADMIN_COLLECTION);
    }

    public SuperAdmin findSuperAdminById(String id) {
        return mongoTemplate.findOne(new Query(Criteria.where("id").is(id)),
                SuperAdmin.class, SUPER_ADMIN_COLLECTION);
    }

    public SuperAdmin findSuperAdminByUsername(String username) {
        return mongoTemplate.findOne(new Query(Criteria.where("username").is(username)),
                SuperAdmin.class, SUPER_ADMIN_COLLECTION);
    }
}
