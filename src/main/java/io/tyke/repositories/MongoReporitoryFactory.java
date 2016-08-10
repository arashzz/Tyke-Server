package io.tyke.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

@Component
public class MongoReporitoryFactory {
	
	@Autowired
	static LotteryMongoRepository lotteryRepository;
	@Autowired
	static BrandMongoRepository brandRepository;
	
	public MongoRepository getMongoRepositoryForType(RepositoryType type){
		switch (type) {
			case Lottery:
				return lotteryRepository;
			case Brand:
				return brandRepository;
			default:
				return null;
		}
		
	}

}
