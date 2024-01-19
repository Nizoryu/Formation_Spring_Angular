package com.inti.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

/**
 * Classe Solliste pour inscription dans la bdd
 */
@Entity
public class Soliste {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long num;
	private String nom;
	private String prenom;
	private LocalDate dateNaissance;
	private String nationalite;
	
	@ManyToMany
	@JoinTable(name = "Oeuvre_Soliste",
	joinColumns = @JoinColumn(name = "id_soliste"),
	inverseJoinColumns = @JoinColumn(name = "id_oeuvre"))
	List<Oeuvre> oeuvres;

	public Soliste() {
		super();
	}

	public Soliste(Long num, String nom, String prenom, LocalDate dateNaissance, String nationalite) {
		super();
		this.num = num;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.nationalite = nationalite;
	}

	public Soliste(Long id, Long num, String nom, String prenom, LocalDate dateNaissance, String nationalite) {
		super();
		this.id = id;
		this.num = num;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.nationalite = nationalite;
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

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getNationalite() {
		return nationalite;
	}

	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}

	public List<Oeuvre> getOeuvres() {
		return oeuvres;
	}

	public void setOeuvres(List<Oeuvre> oeuvres) {
		this.oeuvres = oeuvres;
	}
	
	public void setOeuvres(Oeuvre oeuvre) {
		List<Oeuvre> oeuvres = this.oeuvres;
		oeuvres.add(oeuvre);
		this.oeuvres = oeuvres;
	}

	@Override
	public String toString() {
		return "Soliste [id=" + id + ", num=" + num + ", nom=" + nom + ", prenom=" + prenom + ", dateNaissance="
				+ dateNaissance + ", nationalite=" + nationalite + ", oeuvres=" + oeuvres + "]";
	}

}
