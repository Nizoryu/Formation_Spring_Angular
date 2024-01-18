package com.inti.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.inti.model.Produit;

@Service
public interface ProduitService {

	public Produit save(Produit produit);
	public List<Produit> getAllProduit();
	public void delete(int id);
	public boolean update (Produit produit);
}
