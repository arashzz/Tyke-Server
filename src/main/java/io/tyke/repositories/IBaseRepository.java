package io.tyke.repositories;

import java.util.List;

import io.tyke.models.TykeModel;

public interface IBaseRepository<T extends TykeModel> {
	List<T> findAll();
	T findOne(String id);
	T save(T entity);
	void deleteAll();
	void delete(T entity);
}
