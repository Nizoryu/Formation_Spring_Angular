package com.inti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.inti.model.Oeuvre;
import com.inti.service.OeuvreServiceImpl;

@Controller
@RequestMapping("/oeuvre")
public class OeuvreController {

	@Autowired
	OeuvreServiceImpl oeuvreServiceImpl;
	
	@GetMapping("/home")
	public String homeView(Model model) {
		model.addAttribute("oeuvres", oeuvreServiceImpl.getAll());
		return "oeuvreHome";
	}
	
	@PostMapping("/saveOeuvre")
	public String saveOeuvre(@ModelAttribute(name = "oeuvre") Oeuvre oeuvre) {
		oeuvreServiceImpl.saveOeuvre(oeuvre);
		return "redirect:/oeuvre/home";
	}
	
	@GetMapping("/deleteOeuvre/{id}")
	public String deleteOeuvre(@PathVariable("id") Long id, Model model) {
		oeuvreServiceImpl.deleteOeuvre(id);
		return "redirect:/oeuvre/home";
	}
	
	@GetMapping("/updateOeuvre/{id}")
	public String updateOeuvre(@PathVariable("id") Long id, Model model) {
		model.addAttribute("oeuvre", oeuvreServiceImpl.getById(id));
		return "updateOeuvre";
	}
}
