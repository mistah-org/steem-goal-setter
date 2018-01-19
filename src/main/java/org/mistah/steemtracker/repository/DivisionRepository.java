package org.mistah.steemtracker.repository;

import org.mistah.steemtracker.model.admin.Division;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DivisionRepository extends MongoRepository<Division, String> {
}