package com.codeupdate.CodeUpdate.service;

import com.codeupdate.CodeUpdate.entity.CodeEntity;
import com.codeupdate.CodeUpdate.repository.CodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class CodeService {

    private static final Logger logger = LoggerFactory.getLogger(CodeService.class);

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private CodeRepository codeRepository;

    public void updateIsActive(String id) {
        try {
            Query query = new Query(Criteria.where("_id").is(id));
            Update update = new Update().set("isActive", true);
            long result = mongoTemplate.updateFirst(query, update, CodeEntity.class).getMatchedCount();

            if (result > 0) {
                logger.info("Successfully updated id: {}", id);
            } else {
                logger.warn("No document found with id: {}", id);
            }
        } catch (Exception e) {
            logger.error("Error while updating 'isActive' field : {}", id, e);
        }
    }

    public void updateByCodeVersion(String name,Double version){
        try {
            Query query = new Query(Criteria.where("cName").is(name)
                    .and("version").is(version));
            Update update = new Update().set("isActive", true);
            long result = mongoTemplate.updateFirst(query, update, CodeEntity.class).getMatchedCount();

            if (result > 0) {
                logger.info("Successfully updated code with name: {} and version :{}", name,version);
            } else {
                logger.warn("No document found with name: {} and version: {}", name,version);
            }
        } catch (Exception e) {
            logger.error("Error while updating 'isActive' field : {}", name, e);
        }
    }
}
