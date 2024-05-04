package com.charles.bloconotas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.charles.bloconotas.entity.Usuario;
import com.charles.bloconotas.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder; 
	
	@Transactional
	public Usuario salvar(Usuario usuario) {
		
		usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
		return usuarioRepository.save(usuario);
	}

	@Transactional(readOnly = true)
	public List<Usuario> findAll() {
		
		return usuarioRepository.findAll();
	}

	
	@Transactional(readOnly = true)
	public Usuario buscarPorUsername(String username) {
		return usuarioRepository.findByUsername(username).orElseThrow(() -> new RuntimeException(
				String.format("Usuário com username = %s não encontrado.", username)));
	}

}
