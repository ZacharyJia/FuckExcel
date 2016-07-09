package me.zacharyjia.fuckexcel.service;

import me.zacharyjia.fuckexcel.model.FilledForm;
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
public class FilledFormService {

    private static final String FILLED_FORM_COLLECTION = "filled";

    @Autowired
    MongoTemplate mongoTemplate;

    public void saveFilledForm(FilledForm filledForm) {
        mongoTemplate.save(filledForm, FILLED_FORM_COLLECTION);
    }

    public List<FilledForm> findByFormId(String formId) {
        return mongoTemplate.find(new Query(Criteria.where("formId").is(formId)),
                FilledForm.class, FILLED_FORM_COLLECTION);
    }

    public List<FilledForm> findByUserId(String userId) {
        return mongoTemplate.find(new Query(Criteria.where("userId").is(userId)),
                FilledForm.class, FILLED_FORM_COLLECTION);
    }

    public FilledForm findById(String id) {
        return mongoTemplate.findOne(new Query(Criteria.where("id").is(id)),
                FilledForm.class, FILLED_FORM_COLLECTION);
    }

}
