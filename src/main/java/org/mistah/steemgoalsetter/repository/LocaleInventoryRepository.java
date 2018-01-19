package org.mistah.steemgoalsetter.repository;

import org.mistah.steemgoalsetter.model.inventory.LocaleInventory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocaleInventoryRepository extends MongoRepository<LocaleInventory, String> {
}