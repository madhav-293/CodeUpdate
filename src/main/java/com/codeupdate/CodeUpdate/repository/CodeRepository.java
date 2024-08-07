package com.codeupdate.CodeUpdate.repository;

import com.codeupdate.CodeUpdate.entity.CodeEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CodeRepository extends MongoRepository<CodeEntity,String> {
}
