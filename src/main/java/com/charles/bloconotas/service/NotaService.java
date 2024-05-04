package com.charles.bloconotas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.charles.bloconotas.entity.Nota;
import com.charles.bloconotas.repository.NotaRepository;

@Service
public class NotaService {

	@Autowired
	NotaRepository notaRepository;
	
	
	public Nota salvar(Nota nota) {
		
		return notaRepository.save(nota);
	}

}
