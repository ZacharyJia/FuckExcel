package me.zacharyjia.fuckexcel.service;

import me.zacharyjia.fuckexcel.model.Form;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zachary on 16/7/9.
 */
@Service
public class FormService {

    private static final String FORM_COLLECTION = "form";

    @Autowired
    MongoTemplate mongoTemplate;

    public void saveForm(Form form) {
        mongoTemplate.save(form, FORM_COLLECTION);
    }

    public List<Form> findByCreator(String creatorId) {
        return mongoTemplate.find(new Query(Criteria.where("creator").is(creatorId)),
                Form.class, FORM_COLLECTION);
    }

    public Form findById(String id) {
        return mongoTemplate.findOne(new Query(Criteria.where("id").is(id)),
                Form.class, FORM_COLLECTION);
    }

}
