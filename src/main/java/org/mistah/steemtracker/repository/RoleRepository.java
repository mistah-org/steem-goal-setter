package org.mistah.steemtracker.repository;

import org.mistah.steemtracker.model.admin.Role;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends MongoRepository<Role, String> {
}