package org.mistah.steemgoalsetter.repository;

import org.mistah.steemgoalsetter.model.admin.Role;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends MongoRepository<Role, String> {
}