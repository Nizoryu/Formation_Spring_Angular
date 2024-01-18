package com.inti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.inti.model.Soliste;
import com.inti.service.SolisteServiceImpl;

@Controller
@RequestMapping("/soliste")
public class SolisteController {

	@Autowired
	SolisteServiceImpl solisteServiceImpl;

	@GetMapping("/home")
	public String solisteView(Model model) {
		model.addAttribute("solistes", solisteServiceImpl.getAllSoliste());
		model.addAttribute("nbSoliste", solisteServiceImpl.getSolisteCount());
		return "solisteHome";
	}

	@PostMapping("/saveSoliste")
	public String saveSoliste(@ModelAttribute("soliste") Soliste soliste) {
		solisteServiceImpl.saveSoliste(soliste);
		System.out.println("post SaveSoliste");
		return "redirect:/soliste/home";
	}

	@GetMapping("/deleteSoliste/{id}")
	public String deleteSolisteById(@PathVariable("id") Long id) {
		solisteServiceImpl.deleteSoliste(id);
		return "redirect:/soliste/home";
	}

	@GetMapping("/updateSoliste/{id}")
	public String updateSoliste(@PathVariable("id") Long id, Model model) {
		final Soliste soliste = solisteServiceImpl.getSoliste(id);
		System.out.println(soliste);
		if (soliste != null) {
			model.addAttribute("soliste", soliste);
			return "updateSoliste";
		}
		return "redirect:/soliste/home";
	}
	
	@GetMapping("/findById")
	public String getSolisteById(@RequestParam(name = "id", required = false) Long id, Model model) {
		final Soliste soliste = solisteServiceImpl.getSoliste(id);
		if (soliste != null) {
			model.addAttribute("soliste", soliste);
			return "findSoliste";
		}
		return "redirect:/soliste/home";
	}

	@GetMapping("/findByName")
	public String findByName(@RequestParam(name = "nom") String nom, Model model) {
		model.addAttribute("solitesFiltres", solisteServiceImpl.findByName(nom));
		System.out.println(solisteServiceImpl.findByName(nom));
		return "findSolisteByName";
	}
}
