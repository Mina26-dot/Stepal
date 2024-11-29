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
@Table(name = "proizvodi")
public class ProizvodiEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	@JsonView(Views.Administrator.class)
	public int id;
	
	@Column(name = "naziv", nullable = false)
	@JsonView(Views.Private.class)
	public String naziv;
	
	@Column(name = "visina", nullable = false)
	@JsonView(Views.Private.class)
	public double visina;
	
	@Column(name = "sirina", nullable = false)
	@JsonView(Views.Private.class)
	public double sirina;
	
	@Column(name = "kolicina", nullable = false)
	@JsonView(Views.Private.class)
	public int kolicina;
	
	@Column(name = "cena", nullable = false)
	@JsonView(Views.Private.class)
	public double cena;
	
	
	public ProizvodiEntity(int id, String naziv, double visina, double sirina, int kolicina, double cena) {
		this.id = id;
		this.naziv = naziv;
		this.visina = visina;
		this.sirina = sirina;
		this.kolicina = kolicina;
		this.cena = cena;
		
	}
	
	public ProizvodiEntity() {
		
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

	public double getVisina() {
		return visina;
	}

	public void setVisina(double visina) {
		this.visina = visina;
	}

	public double getSirina() {
		return sirina;
	}

	public void setSirina(double sirina) {
		this.sirina = sirina;
	}

	public int getKolicina() {
		return kolicina;
	}

	public void setKolicina(int kolicina) {
		this.kolicina = kolicina;
	}

	public double getCena() {
		return cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}

	

	
	
	
}
