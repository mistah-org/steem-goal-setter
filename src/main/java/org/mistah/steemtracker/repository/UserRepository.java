package org.mistah.steemtracker.repository;

import org.mistah.steemtracker.model.admin.SystemUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<SystemUser, String> {
}