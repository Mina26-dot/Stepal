package com.iktpreobuka.stepal.repository;

import org.springframework.data.repository.CrudRepository;

import com.iktpreobuka.stepal.entity.MaterijalEntity;


public interface MaterijalRepository extends CrudRepository<MaterijalEntity,Integer> {


	Iterable<MaterijalEntity> findAll();

	MaterijalEntity findById(int id);

}
