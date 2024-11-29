package com.iktpreobuka.stepal.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iktpreobuka.stepal.entity.ProizvodiEntity;
import com.iktpreobuka.stepal.repository.ProizvodiRepository;

@RestController
@RequestMapping("/proizvodi")
public class ProizvodiController {

	private final ProizvodiRepository proizvodiRepository;
	
	private static final Logger logger = LoggerFactory.getLogger(ProizvodiController.class);

	
	public ProizvodiController(ProizvodiRepository proizvodiRepository) {
		this.proizvodiRepository = proizvodiRepository;
	}
	
	@GetMapping("/all")
	public Iterable<ProizvodiEntity> GetAll() {
		LocalDateTime currentTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String formattedTime = currentTime.format(formatter);
		logger.info("[{}]Pozvana metoda getAll.",formattedTime);
		return proizvodiRepository.findAll();
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<ProizvodiEntity> getProizvodById(@PathVariable int id) {
		LocalDateTime currentTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String formattedTime = currentTime.format(formatter);
		logger.info("[{}]Pozvana metoda getProizvodById.",formattedTime);
		ProizvodiEntity proizvodi = proizvodiRepository.findById(id);
		return new ResponseEntity<>(proizvodi, HttpStatus.OK);
	}

	
	@PostMapping("/create")
	public ResponseEntity<ProizvodiEntity> createNew(@RequestParam String naziv, @RequestParam double visina, @RequestParam double sirina , @RequestParam int kolicina, @RequestParam double cena) {
		LocalDateTime currentTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String formattedTime = currentTime.format(formatter);
		logger.info("[{}]Pozvana metoda createNew.",formattedTime);
		ProizvodiEntity noviProizvod = new ProizvodiEntity();
		noviProizvod.setNaziv(naziv);
		noviProizvod.setVisina(visina);
		noviProizvod.setSirina(sirina);
		noviProizvod.setKolicina(kolicina);
		noviProizvod.setCena(cena);
		proizvodiRepository.save(noviProizvod);
		return new ResponseEntity<>(noviProizvod, HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<ProizvodiEntity> updateProizvod(@PathVariable int id, @RequestParam String izmenjenNaziv, @RequestParam int izmenjenaKolicina) {
		LocalDateTime currentTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String formattedTime = currentTime.format(formatter);
		logger.info("[{}]Pozvana metoda updateProizvod.",formattedTime);
		ProizvodiEntity proizvod = proizvodiRepository.findById(id);
		proizvod.setNaziv(izmenjenNaziv);
		proizvod.setKolicina(izmenjenaKolicina);
		proizvodiRepository.save(proizvod);
		return new ResponseEntity<>(proizvod, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<ProizvodiEntity> deleteProzivod(@PathVariable int id){
		LocalDateTime currentTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String formattedTime = currentTime.format(formatter);
		logger.info("[{}]Pozvana metoda deleteProizvod.",formattedTime);
		ProizvodiEntity proizvod = proizvodiRepository.findById(id);
		proizvodiRepository.deleteById(id);
		return new ResponseEntity<ProizvodiEntity>(proizvod, HttpStatus.OK);
	}
	
		
}

