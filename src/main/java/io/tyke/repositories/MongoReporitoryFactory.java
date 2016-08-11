package io.tyke.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import io.tyke.application.ApplicationContextHolder;

@Component
public class MongoReporitoryFactory {
	
	@Autowired
	LotteryMongoRepository lotteryRepository;
	@Autowired
	BrandMongoRepository brandRepository;
	
	protected LotteryMongoRepository getLotteryMongoRepository(){
		if(this.lotteryRepository == null){
			this.lotteryRepository = ApplicationContextHolder.getContext().getBean(LotteryMongoRepository.class);
		}
		return this.lotteryRepository;
	}
	protected BrandMongoRepository getBrandMongoRepository(){
		if(this.brandRepository == null){
			this.brandRepository = ApplicationContextHolder.getContext().getBean(BrandMongoRepository.class);
		}
		return this.brandRepository;
	}
	public MongoRepository getMongoRepositoryForType(RepositoryType type){
		switch (type) {
			case Lottery:
				return this.getLotteryMongoRepository();
			case Brand:
				return this.getBrandMongoRepository();
			default:
				return null;
		}
		
	}

}
