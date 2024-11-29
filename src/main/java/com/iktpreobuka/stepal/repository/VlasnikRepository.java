package com.iktpreobuka.stepal.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iktpreobuka.stepal.entity.VlasnikEntity;

@Repository
public interface VlasnikRepository extends CrudRepository<VlasnikEntity,Integer> {

	VlasnikEntity findVlasnikById(int id);

}
