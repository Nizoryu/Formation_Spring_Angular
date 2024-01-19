package com.inti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.model.Oeuvre;
import com.inti.repository.OeuvreRepository;

@Service
public class OeuvreServiceImpl implements OeuvreService {

	@Autowired
	OeuvreRepository oeuvreRepository;

	@Override
	public Oeuvre saveOeuvre(Oeuvre oeuvre) {
		return oeuvreRepository.save(oeuvre);
	}

	@Override
	public void deleteOeuvre(Long id) {
		oeuvreRepository.deleteById(id);

	}

	@Override
	public Oeuvre updateOeuvre(Oeuvre oeuvre) {
		return oeuvreRepository.save(oeuvre);
	}

	@Override
	public List<Oeuvre> getAll() {
		return oeuvreRepository.findAll();
	}

	@Override
	public Oeuvre getById(Long id) {
		return oeuvreRepository.getReferenceById(id);
	}

}
