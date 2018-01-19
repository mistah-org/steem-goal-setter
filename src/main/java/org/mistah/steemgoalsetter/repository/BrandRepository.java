package org.mistah.steemgoalsetter.repository;

import org.mistah.steemgoalsetter.model.admin.Brand;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends MongoRepository<Brand, String> {

    Brand findByCompanyName(String companyName);
}