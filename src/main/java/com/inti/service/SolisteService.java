package com.inti.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.inti.model.Soliste;

@Service
public interface SolisteService {

	public List<Soliste> getAllSoliste();

	public Soliste saveSoliste(Soliste soliste);

	public Soliste getSoliste(Long id);

	public Soliste updateSoliste(Soliste soliste);

	public boolean deleteSoliste(Long id);
	
	public List<Soliste> findByName(String nom);
	
	public long getSolisteCount();

}
