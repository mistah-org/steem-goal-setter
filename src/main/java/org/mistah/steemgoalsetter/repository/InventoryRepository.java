package org.mistah.steemgoalsetter.repository;

import org.mistah.steemgoalsetter.model.inventory.Inventory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends MongoRepository<Inventory, String> {
}