package org.mistah.steemtracker.repository;

import org.mistah.steemtracker.model.inventory.StagnantStock;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StagnantStockRepository extends MongoRepository<StagnantStock, String> {
}