package com.iktpreobuka.stepal.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iktpreobuka.stepal.entity.DobavljaciEntity;
import com.iktpreobuka.stepal.repository.DobavljaciRepository;

@RestController
@RequestMapping("/dobavljaci")
@CrossOrigin(origins = "http://localhost:3000")

public class DobavljaciController {

	private DobavljaciRepository dobavljaciRepository;
	
	 @Autowired
	    public DobavljaciController(DobavljaciRepository dobavljaciRepository) {
	        this.dobavljaciRepository = dobavljaciRepository;
	    }
	private static final Logger logger = LoggerFactory.getLogger(DobavljaciController.class);

	
	@GetMapping("/all")
	public ResponseEntity<Iterable<DobavljaciEntity>> getAll(){
		LocalDateTime currentTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String formattedTime = currentTime.format(formatter);
		logger.info("[{}]Pozvana metoda getAll.", formattedTime);
		Iterable<DobavljaciEntity> dobavljac = dobavljaciRepository.findAll();
		return new ResponseEntity<>(dobavljac, HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<DobavljaciEntity> getById(@PathVariable int id){
		LocalDateTime currentTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String formattedTime = currentTime.format(formatter);
		logger.info("[{}]Pozvana metoda getById.",formattedTime);
		DobavljaciEntity dobavljac = dobavljaciRepository.findById(id);
		if(dobavljac != null) {
			return new ResponseEntity<>(dobavljac, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(dobavljac, HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/create")
	public ResponseEntity<DobavljaciEntity> addNew(@RequestParam String ime, @RequestParam String prezime,@RequestParam int pib, @RequestParam String nazivFirme ){
		LocalDateTime currentTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String formattedTime = currentTime.format(formatter);
		logger.info("[{}]Pozvana metoda addNew.",formattedTime);
		DobavljaciEntity novDobavljac = new DobavljaciEntity();
		novDobavljac.setIme(ime);
		novDobavljac.setPrezime(prezime);
		novDobavljac.setPib(pib);
		novDobavljac.setNazivFirme(nazivFirme);
		dobavljaciRepository.save(novDobavljac);
		return new ResponseEntity<>(novDobavljac, HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<DobavljaciEntity> update(@PathVariable int id, @RequestParam String izmenjenoIme, @RequestParam String izmenjenoPrezime,  @RequestParam int pib,  @RequestParam String izmenjenNazivFirme){
		LocalDateTime currentTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String formattedTime = currentTime.format(formatter);
		logger.info("[{}]Pozvana metoda update.",formattedTime);
		DobavljaciEntity dobavljac = dobavljaciRepository.findById(id);
		if(dobavljac != null) {
			dobavljac.setIme(izmenjenoIme);
			dobavljac.setPrezime(izmenjenoPrezime);
			dobavljac.setPib(pib);
			dobavljac.setNazivFirme(izmenjenNazivFirme);
			dobavljaciRepository.save(dobavljac);
			return new ResponseEntity<>(dobavljac, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(dobavljac, HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<DobavljaciEntity> deleteById(@PathVariable int id){
		LocalDateTime currentTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String formattedTime = currentTime.format(formatter);
		logger.info("[{}]Pozvana metoda deleteById.",formattedTime);
		DobavljaciEntity dobavljac = dobavljaciRepository.findById(id);
		if(dobavljac != null) {
			dobavljaciRepository.deleteById(id);
			return new ResponseEntity<>(dobavljac, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(dobavljac, HttpStatus.NOT_FOUND);
		}
	}
	
	
	
}
