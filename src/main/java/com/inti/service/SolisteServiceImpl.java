package com.inti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.inti.model.Soliste;
import com.inti.repository.SolisteRepository;

@Service
public class SolisteServiceImpl implements SolisteService{

	@Autowired
	SolisteRepository solisteRepository;
	
	@Override
	public List<Soliste> getAllSoliste() {
		return solisteRepository.findAll();
	}

	@Override
	public Soliste saveSoliste(Soliste soliste) {
		if (soliste != null) {
			return solisteRepository.save(soliste);
		}
		return null;
	}

	@Override
	public Soliste getSoliste(Long id) {
		try {
			return solisteRepository.getReferenceById(id);
			
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Soliste updateSoliste(Soliste soliste) {
		return solisteRepository.save(soliste);
	}

	@Override
	public boolean deleteSoliste(Long id) {
		if (id != null) {
			solisteRepository.deleteById(id);
			return getSoliste(id) == null;
		}
		return false;
	}

	public List<Soliste> findByName(String nom) {
		final Soliste soliste = new Soliste();
		soliste.setNom(nom);
		Example<Soliste> example = Example.of(soliste);
		return solisteRepository.findAll(example);
	}

	@Override
	public long getSolisteCount() {
		return solisteRepository.count();	}

}
