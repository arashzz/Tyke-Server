package io.tyke.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import io.tyke.application.ApplicationContextHolder;
import io.tyke.models.TykeModel;

@Service
@Configurable
public class BaseRepository<T extends TykeModel> implements IBaseRepository<T> {
	
	protected MongoRepository<T, String> repository;
	@Autowired
	protected MongoReporitoryFactory mongoRepoFactory;
	
	protected RepositoryType type;
	
	public BaseRepository(){
	}
	
	public BaseRepository(RepositoryType type){
		this.type = type;
		this.mongoRepoFactory = ApplicationContextHolder.getContext().getBean(MongoReporitoryFactory.class);
	}
	
	protected MongoRepository<T, String> getRepository(){
		if(repository == null){
			this.repository = mongoRepoFactory.getMongoRepositoryForType(this.type);
		}
		return repository;
	}
	public List<T> findAll(){
		
		return this.getRepository().findAll();
	}
	public T findOne(String id){
		return this.getRepository().findOne(id);
	}
	public T save(T entity){
		return this.getRepository().save(entity);
	}
	public void deleteAll(){
		this.getRepository().deleteAll();
	}
	public void delete(T entity){
		this.getRepository().delete(entity);
	}

}
