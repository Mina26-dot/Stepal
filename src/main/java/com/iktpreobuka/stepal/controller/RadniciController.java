package com.iktpreobuka.stepal.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

import com.iktpreobuka.stepal.entity.RadniciEntity;
import com.iktpreobuka.stepal.repository.RadniciRepository;

@RestController
@RequestMapping("/radnici")
public class RadniciController {

	private RadniciRepository radniciRepository;

	@Autowired
	public RadniciController(RadniciRepository radniciRepository) {
		this.radniciRepository = radniciRepository;
	}

	private static final Logger logger = LoggerFactory.getLogger(RadniciController.class);

	@GetMapping("/all")
	public ResponseEntity<Iterable<RadniciEntity>> GetAll() {
		LocalDateTime currentTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String formattedTime = currentTime.format(formatter);
		logger.info("[{}]Pozvana metoda getAll.", formattedTime);
		Iterable<RadniciEntity> radnik = radniciRepository.findAll();
		return new ResponseEntity<>(radnik, HttpStatus.OK);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<RadniciEntity> getRadnikById(@PathVariable int id) {
		LocalDateTime currentTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String formattedTime = currentTime.format(formatter);
		logger.info("[{}]Pozvana metoda getRadnikById.", formattedTime);
		RadniciEntity radnik = radniciRepository.findById(id);
		return new ResponseEntity<>(radnik, HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<RadniciEntity> addNew(@RequestParam String imeRadnika) {
		LocalDateTime currentTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String formattedTime = currentTime.format(formatter);
		logger.info("[{}]Pozvana metoda addNew.", formattedTime);
		RadniciEntity noviRadnik = new RadniciEntity();
		noviRadnik.setIme(imeRadnika);
		radniciRepository.save(noviRadnik);
		return new ResponseEntity<>(noviRadnik, HttpStatus.OK);

	}

	@PutMapping("/update")
	public ResponseEntity<RadniciEntity> updateRadnik(@PathVariable int id, @RequestParam String izmenjenoImeRadnika) {
		LocalDateTime currentTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String formattedTime = currentTime.format(formatter);
		logger.info("[{}]Pozvana metoda updateRadnik.", formattedTime);

		RadniciEntity radnik = radniciRepository.findById(id);
		radnik.setIme(izmenjenoImeRadnika);
		radniciRepository.save(radnik);
		return new ResponseEntity<>(radnik, HttpStatus.OK);
	}

	@DeleteMapping("/delete")
	public ResponseEntity<RadniciEntity> deleteById(@PathVariable int id) {
		LocalDateTime currentTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String formattedTime = currentTime.format(formatter);
		logger.info("[{}]Pozvana metoda deleteByid.", formattedTime);
		RadniciEntity radnik = radniciRepository.findById(id);
		radniciRepository.deleteById(id);
		return new ResponseEntity<>(radnik, HttpStatus.OK);
	}

}
