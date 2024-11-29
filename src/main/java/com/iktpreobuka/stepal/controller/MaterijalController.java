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

import com.iktpreobuka.stepal.entity.MaterijalEntity;
import com.iktpreobuka.stepal.repository.MaterijalRepository;

@RestController
@RequestMapping("/materijal")
public class MaterijalController {

	
    private final MaterijalRepository materijalRepository;
    
    @Autowired
    public MaterijalController(MaterijalRepository materijalRepository) {
        this.materijalRepository = materijalRepository;
    }
	private static final Logger logger = LoggerFactory.getLogger(MaterijalController.class);

	
	@GetMapping("/all")
	public ResponseEntity<Iterable<MaterijalEntity>> getAll(){
		LocalDateTime currentTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String formattedTime = currentTime.format(formatter);
		logger.info("[{}]Pozvana metoda getAll.", formattedTime);
		Iterable<MaterijalEntity> materijal = materijalRepository.findAll();
		return new ResponseEntity<>(materijal, HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<MaterijalEntity> getById(@PathVariable int id){
		LocalDateTime currentTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String formattedTime = currentTime.format(formatter);
		logger.info("[{}]Pozvana metoda getById.",formattedTime);
		MaterijalEntity materijal = materijalRepository.findById(id);
		if(materijal != null) {
			return new ResponseEntity<>(materijal, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(materijal, HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/create")
	public ResponseEntity<MaterijalEntity> addNew(@RequestParam String naziv, @RequestParam int kolicina){
		LocalDateTime currentTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String formattedTime = currentTime.format(formatter);
		logger.info("[{}]Pozvana metoda addNew.",formattedTime);
		MaterijalEntity novMaterijal = new MaterijalEntity();
		novMaterijal.setNaziv(naziv);
		novMaterijal.setKolicina(kolicina);
		materijalRepository.save(novMaterijal);
		return new ResponseEntity<>(novMaterijal, HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<MaterijalEntity> update(@PathVariable int id, @RequestParam String izmenjenNaziv, @RequestParam int izmenjenaKolicina){
		LocalDateTime currentTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String formattedTime = currentTime.format(formatter);
		logger.info("[{}]Pozvana metoda update.",formattedTime);
		MaterijalEntity materijal = materijalRepository.findById(id);
		if(materijal != null) {
			materijal.setNaziv(izmenjenNaziv);
			materijal.setKolicina(izmenjenaKolicina);
			materijalRepository.save(materijal);
			return new ResponseEntity<>(materijal, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(materijal, HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<MaterijalEntity> deleteById(@PathVariable int id){
		LocalDateTime currentTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String formattedTime = currentTime.format(formatter);
		logger.info("[{}]Pozvana metoda deleteById.",formattedTime);
		MaterijalEntity materijal = materijalRepository.findById(id);
		if(materijal != null) {
			materijalRepository.deleteById(id);
			return new ResponseEntity<>(materijal, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(materijal, HttpStatus.NOT_FOUND);
		}
	}
	
}
