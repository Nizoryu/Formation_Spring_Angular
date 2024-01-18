package com.inti.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

/**
 * 
 * Classe produit pour lister tous les produits de notre bdd
 */

@Entity
@Table(name = "product")
public class Produit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(length = 50)
	private String marque;
	private double prix;
	
	@ManyToMany
	@JoinTable(name = "Magasin_Produit", 
	joinColumns = @JoinColumn(name = "id_produit"), 
	inverseJoinColumns = @JoinColumn(name = "id_magasin"))
	List<Magasin> magasins;

	public Produit() {
		super();
	}

	public Produit(String marque, double prix) {
		super();
		this.marque = marque;
		this.prix = prix;
	}

	public Produit(int id, String marque, double prix) {
		super();
		this.id = id;
		this.marque = marque;
		this.prix = prix;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	@Override
	public String toString() {
		return "Produit [id=" + id + ", marque=" + marque + ", prix=" + prix + "]";
	}

	
}
