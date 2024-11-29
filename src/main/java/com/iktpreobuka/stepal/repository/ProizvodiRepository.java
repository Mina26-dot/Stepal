package com.iktpreobuka.stepal.repository;

import org.springframework.data.repository.CrudRepository;

import com.iktpreobuka.stepal.entity.ProizvodiEntity;

public interface ProizvodiRepository extends CrudRepository<ProizvodiEntity,Integer> {

	Iterable<ProizvodiEntity> findAll();
	ProizvodiEntity findById(int id);
}
