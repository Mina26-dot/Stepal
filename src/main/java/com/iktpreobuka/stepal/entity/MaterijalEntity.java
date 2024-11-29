package com.iktpreobuka.stepal.entity;

import com.fasterxml.jackson.annotation.JsonView;
import com.iktpreobuka.stepal.security.Views;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "materijal")
public class MaterijalEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	@JsonView(Views.Administrator.class)
	public int id;
	
	@Column(name = "naziv", nullable = false)
	@JsonView(Views.Private.class)
	public String naziv;
	
	@Column(name = "kolicina", nullable = false)
	@JsonView(Views.Private.class)
	public int kolicina;

	public MaterijalEntity() {

	}

	public MaterijalEntity(int id, String naziv, int kolicina) {
		this.id = id;
		this.naziv = naziv;
		this.kolicina = kolicina;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public int getKolicina() {
		return kolicina;
	}

	public void setKolicina(int kolicina) {
		this.kolicina = kolicina;
	}
	
	

}
