package com.inti.model;

import java.time.LocalTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Oeuvre {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long num;
	private String nom;
	private LocalTime duree;
	
	@ManyToMany
	@JoinTable(name = "Soliste_Oeuvre",
	joinColumns = @JoinColumn(name = "id_oeuvre"),
	inverseJoinColumns = @JoinColumn(name = "id_solite"))
	List<Soliste> solistes;

	public Oeuvre() {
		super();
	}

	public Oeuvre(Long num, String nom, LocalTime duree) {
		super();
		this.num = num;
		this.nom = nom;
		this.duree = duree;
	}

	public Oeuvre(Long id, Long num, String nom, LocalTime duree) {
		super();
		this.id = id;
		this.num = num;
		this.nom = nom;
		this.duree = duree;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getNum() {
		return num;
	}

	public void setNum(Long num) {
		this.num = num;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public LocalTime getDuree() {
		return duree;
	}

	public void setDuree(LocalTime duree) {
		this.duree = duree;
	}

	@Override
	public String toString() {
		return "Oeuvre [id=" + id + ", num=" + num + ", nom=" + nom + ", duree=" + duree + ", solistes=" + solistes
				+ "]";
	}

}
