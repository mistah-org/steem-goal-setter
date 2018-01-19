package org.mistah.steemtracker.repository;

import java.util.List;
import java.util.Set;

import org.mistah.steemtracker.model.product.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
    Product findByName(String name);
    List<Product> findAllByOrderByIdAsc();
    List<Product> findByBrandCompanyName(String brandName);

    List<Product> findByIdInOrderByIdAsc(Set<String> ids);
}