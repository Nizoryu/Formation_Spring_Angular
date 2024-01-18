package com.inti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.inti.model.Produit;
import com.inti.service.ProduitService;

@Controller
@RequestMapping("/produit")
public class ProduitController {

	@Autowired
	ProduitService produitService;

	@GetMapping("/formulaire")
	public String getFormulaire() {
		return "formulaireProduit";
	}

	@PostMapping("/saveProduit")
	public String saveProduit(@ModelAttribute("produitformulaire") Produit produit) {
		produitService.save(produit);
		System.out.println(produit);
		return "formulaireProduit";
	}

}
