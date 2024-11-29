package com.iktpreobuka.stepal.repository;

import org.springframework.data.repository.CrudRepository;

import com.iktpreobuka.stepal.entity.RadniciEntity;

public interface RadniciRepository extends CrudRepository<RadniciEntity,Integer> {

	Iterable<RadniciEntity> findAll();

	RadniciEntity findById(int id);

}
