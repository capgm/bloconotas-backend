package com.charles.bloconotas.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.charles.bloconotas.entity.Nota;
import com.charles.bloconotas.entity.Usuario;
import com.charles.bloconotas.repository.NotaRepository;
import com.charles.bloconotas.repository.UsuarioRepository;
import com.charles.bloconotas.web.dto.mapper.NotaMapper;
import com.charles.bloconotas.web.dto.nota.NotaCreateDto;

@Service
public class NotaService {

	@Autowired
	NotaRepository notaRepository;
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Transactional
	public Nota salvar(NotaCreateDto notaCreateDto) {
		
		Optional<Usuario> user = usuarioRepository.findByUsername(notaCreateDto.getUsername());

		Nota nota = NotaMapper.toNota(notaCreateDto);
		nota.setUsuario(user.get());
		
		return notaRepository.save(nota);
	}

	@Transactional(readOnly = true)
	public List<Nota> findAll() {
		
		return notaRepository.findAll();
	}

}
