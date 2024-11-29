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

import com.iktpreobuka.stepal.entity.VlasnikEntity;
import com.iktpreobuka.stepal.repository.VlasnikRepository;

@RestController
@RequestMapping("/vlasnik")
public class VlasnikController {

	
	private VlasnikRepository vlasnikRepository;
	private static final Logger logger = LoggerFactory.getLogger(VlasnikController.class);
	
	public VlasnikController(VlasnikRepository vlasnikRepository) {
	    this.vlasnikRepository = vlasnikRepository;
	}

	
	@GetMapping("/all")
	public Iterable<VlasnikEntity> getAll(){
		LocalDateTime currentTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String formattedTime = currentTime.format(formatter);
		logger.info("[{}]Pozvana metoda getAll.",formattedTime);
		return vlasnikRepository.findAll();
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<VlasnikEntity> getById(@PathVariable int id){
		LocalDateTime currentTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String formattedTime = currentTime.format(formatter);
		logger.info("[{}]Pozvana metoda getById.",formattedTime);
		VlasnikEntity vlasnik = vlasnikRepository.findVlasnikById(id);
		if(vlasnik != null) {
		return new ResponseEntity<>(vlasnik, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(vlasnik, HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/create")
	public ResponseEntity<VlasnikEntity> addNew(@RequestParam String ime, @RequestParam String prezime, @RequestParam String JMBG){
		LocalDateTime currentTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String formattedTime = currentTime.format(formatter);
//		logger.info("[{}]Pozvana metoda addNew.",formattedTime);
		logger.info("Dodavanje novog vlasnika: ime={}, prezime={}, JMBG={}", ime, prezime, JMBG,formattedTime);
		VlasnikEntity noviVlasnik = new VlasnikEntity();
		noviVlasnik.setIme(ime);
		noviVlasnik.setPrezime(prezime);
		noviVlasnik.setJMBG(JMBG);
		vlasnikRepository.save(noviVlasnik);
		return new ResponseEntity<>(noviVlasnik, HttpStatus.CREATED);
	
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<VlasnikEntity> updateVlasnik(@PathVariable int id, @RequestParam String izmenjenoIme, @RequestParam String izmenjenoPrezime, @RequestParam String izmenjenJMBG){
		LocalDateTime currentTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String formattedTime = currentTime.format(formatter);
		logger.info("[{}]Pozvana metoda updateVlasnik.",formattedTime);
		VlasnikEntity izmenjeniVlasnik = vlasnikRepository.findVlasnikById(id);
		izmenjeniVlasnik.setIme(izmenjenoIme);
		izmenjeniVlasnik.setPrezime(izmenjenoPrezime);
		izmenjeniVlasnik.setJMBG(izmenjenJMBG);
		vlasnikRepository.save(izmenjeniVlasnik);
		return new ResponseEntity<>(izmenjeniVlasnik, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<VlasnikEntity> deleteById(@PathVariable int id){
		LocalDateTime currentTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String formattedTime = currentTime.format(formatter);
		logger.info("[{}]Pozvana metoda deleteById.",formattedTime);
		VlasnikEntity vlasnik = vlasnikRepository.findVlasnikById(id);
		vlasnikRepository.deleteById(id);
		return new ResponseEntity<>(vlasnik, HttpStatus.OK);
	}

}
