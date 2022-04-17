package com.cragardev.candycrud.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cragardev.candycrud.models.Candy;

@Repository
public interface CandyRepo extends CrudRepository<Candy, Long> {
	
	List<Candy> findAll();

}
