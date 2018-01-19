package org.mistah.steemgoalsetter.repository;

import org.mistah.steemgoalsetter.model.admin.SystemUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<SystemUser, String> {
}