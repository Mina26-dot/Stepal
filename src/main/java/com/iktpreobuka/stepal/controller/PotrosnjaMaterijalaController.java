package com.iktpreobuka.stepal.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/izracunavanje")
public class PotrosnjaMaterijalaController {


	
	private static final int DUZINA_PROFILA = 6;

	
	@PostMapping("/potrosnja")
	@ResponseBody
	public String izracunajPotrosnju(@RequestParam double sirina, @RequestParam double visina) {

		double ukupnaPotrosnja = 2 * (sirina + visina); 

	    double potrebniProfil = ukupnaPotrosnja / DUZINA_PROFILA;
	    int brojProfila = (int) Math.ceil(potrebniProfil); 
	    
	    double potrosenoMaterijala = ukupnaPotrosnja;
	    double ukupnoMaterijala = brojProfila * DUZINA_PROFILA;
	    double neiskorisceno = ukupnoMaterijala - potrosenoMaterijala;

	  
	    double potrosnjaPoProfilu = ukupnaPotrosnja / brojProfila;
	    double ostaloPoProfilu = DUZINA_PROFILA - potrosnjaPoProfilu;

	    return String.format("Potrebno profila: %d, Potroseno materijala: %.2f m, Neiskorisceno: %.2f m, Potrosnja po profilu: %.2f m, Ostalo po profilu: %.2f m",
	            brojProfila, potrosenoMaterijala, neiskorisceno, potrosnjaPoProfilu, ostaloPoProfilu);
	}
	
}
	


