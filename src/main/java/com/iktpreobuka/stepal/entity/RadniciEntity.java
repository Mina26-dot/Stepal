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
@Table(name = "radnici")
public class RadniciEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	@JsonView(Views.Administrator.class)
	public int id;
	
	@Column(name = "ime", nullable = false)
	@JsonView(Views.Private.class)
	public String ime;
	
	@Column(name = "prezime", nullable = false)
	@JsonView(Views.Private.class)
	public String prezime;
	
	@Column(name = "JMBG", nullable = false)
	@JsonView(Views.Private.class)
	public String JMBG;

	public RadniciEntity(int id, String ime, String prezime, String JMBG) {
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
		this.JMBG = JMBG;
	}

	public RadniciEntity() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getJMBG() {
		return JMBG;
	}

	public void setJMBG(String jMBG) {
		JMBG = jMBG;
	}

}
