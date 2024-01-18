package com.inti.model;

import java.util.List;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

public class Magasin {

	private int id;
	private String nom;
	
	@ManyToMany
	@JoinTable(name = "Magasin_Produit", 
	joinColumns = @JoinColumn(name = "id_magasin"), 
	inverseJoinColumns = @JoinColumn(name = "id_produit"))
	List<Produit> produits;
}
