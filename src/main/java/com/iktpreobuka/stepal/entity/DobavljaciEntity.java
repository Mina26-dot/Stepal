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
@Table(name = "dobavljaci")
public class DobavljaciEntity {

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
	
	@Column(name = "pib", nullable = false)
	@JsonView(Views.Private.class)
	public int pib;
	
	@Column(name = "nazivFirme", nullable = false)
	@JsonView(Views.Private.class)
	public String nazivFirme;
	
	public DobavljaciEntity(int id, String ime, String prezime, int pib, String nazivFirme) {
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
		this.pib = pib;
		this.nazivFirme = nazivFirme;
		
	}
	
	public DobavljaciEntity() {
		
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

	public int getPib() {
		return pib;
	}

	public void setPib(int pib) {
		this.pib = pib;
	}

	public String getNazivFirme() {
		return nazivFirme;
	}

	public void setNazivFirme(String nazivFirme) {
		this.nazivFirme = nazivFirme;
	}
	
	

	
	
	
}
