package io.tyke.repositories;

import org.springframework.stereotype.Component;

import io.tyke.models.Brand;

@Component
public class BrandRepository extends BaseRepository<Brand> {

	public BrandRepository() {
		super(RepositoryType.Brand);
	}
}
