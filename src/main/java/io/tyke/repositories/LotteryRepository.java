package io.tyke.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.tyke.models.Lottery;

@Component
public class LotteryRepository extends BaseRepository<Lottery> {

	public LotteryRepository() {
		super(RepositoryType.Lottery);
	}
	
	@Override
	public List<Lottery> findAll(){
		return super.findAll();
	}
	

}
