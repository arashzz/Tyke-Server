package io.tyke.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import io.tyke.models.Brand;

public interface BrandMongoRepository extends MongoRepository<Brand, String> {

}
