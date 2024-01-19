package com.inti.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.inti.model.Oeuvre;

@Service
public interface OeuvreService {

	public Oeuvre saveOeuvre(Oeuvre oeuvre);

	public void deleteOeuvre(Long id);

	public Oeuvre updateOeuvre(Oeuvre oeuvre);

	public List<Oeuvre> getAll();

	public Oeuvre getById(Long id);

}
