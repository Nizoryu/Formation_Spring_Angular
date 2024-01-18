package com.inti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inti.model.Produit;

@Repository
public interface ProduitRepository extends JpaRepository<Produit, Integer> {

}
