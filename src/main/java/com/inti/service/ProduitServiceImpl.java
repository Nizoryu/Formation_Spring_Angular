package com.inti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.model.Produit;
import com.inti.repository.ProduitRepository;

@Service
public class ProduitServiceImpl implements ProduitService {
	
	@Autowired
	ProduitRepository produitRepository;

	@Override
	public Produit save(Produit produit) {
		return produitRepository.save(produit);
	}

	@Override
	public List<Produit> getAllProduit() {
		return produitRepository.findAll();
	}

	@Override
	public void delete(int id) {
		produitRepository.deleteById(id);
		
	}

	@Override
	public boolean update(Produit produit) {
		if (produitRepository.save(produit) != null) {
			return true;
		}
		return false;
	}

}
