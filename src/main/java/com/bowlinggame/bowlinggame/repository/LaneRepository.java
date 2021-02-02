package com.bowlinggame.bowlinggame.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bowlinggame.bowlinggame.model.Lane;


public interface LaneRepository extends CrudRepository<Lane, Integer> {
	
	List<Lane> findAll();
	Lane findById(int id);
}