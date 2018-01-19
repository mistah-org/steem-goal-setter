package org.mistah.steemtracker.repository;

import org.mistah.steemtracker.model.inventory.LocaleInventory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocaleInventoryRepository extends MongoRepository<LocaleInventory, String> {
}