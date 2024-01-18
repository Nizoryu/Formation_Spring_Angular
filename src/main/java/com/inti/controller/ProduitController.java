package com.inti.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/produit")
public class ProduitController {

	@GetMapping("/affichage")
	public String affichageNomProduit(
			@RequestParam(value = "nomProduit", defaultValue = "defaultNomProduit") String nomProduit,
			Model model) {
		model.addAttribute("nomProduit", nomProduit);
		return "home";
	}

	@GetMapping("/prix")
	public String affichagePrixProduit(
			@RequestParam(value = "prix", defaultValue = "0") double prix,
			Model model) {
		model.addAttribute("prix", prix);
		return "home";
	}
	
	@GetMapping("/calcul")
	public String calculProduit(@RequestParam(value = "produit", defaultValue = "defaultProduit") String produit,
			@RequestParam(value = "prix", defaultValue = "0") double prix, Model model) {
		
		model.addAttribute("prixHT", prix);
		model.addAttribute("prixTTC", prix*1.2);
		model.addAttribute("produit", produit);
		return "home";
	}
}
