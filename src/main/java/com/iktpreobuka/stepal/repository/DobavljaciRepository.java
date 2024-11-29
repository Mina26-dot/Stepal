package com.iktpreobuka.stepal.repository;

import org.springframework.data.repository.CrudRepository;

import com.iktpreobuka.stepal.entity.DobavljaciEntity;

public interface DobavljaciRepository extends CrudRepository<DobavljaciEntity,Integer> {

	Iterable<DobavljaciEntity> findAll();

	DobavljaciEntity findById(int id);

	void deleteById(int id);

}
