package org.mistah.steemtracker.repository;

import org.mistah.steemtracker.model.inventory.Inventory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends MongoRepository<Inventory, String> {
}