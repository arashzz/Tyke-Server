package io.tyke.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import io.tyke.models.Lottery;

public interface LotteryMongoRepository extends MongoRepository<Lottery, String> {
	public List<Lottery> findByName(String name);
}
