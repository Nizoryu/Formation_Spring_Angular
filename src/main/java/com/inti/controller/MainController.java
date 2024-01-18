package com.inti.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/main")
public class MainController {
	
	@GetMapping("/test")
	public String hello(@RequestParam(value = "nom", defaultValue = "default") String name, Model model) {
		System.out.println("Nom: "+ name);
		model.addAttribute("variableName", name);
		List<String> prenoms = List.of("Karim", "Ahmed", "Rabah");
		model.addAttribute("prenoms", prenoms);
		return "hello";
	}

}
