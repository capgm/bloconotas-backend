package com.charles.bloconotas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.charles.bloconotas.entity.Usuario;
import com.charles.bloconotas.service.UsuarioService;
import com.charles.bloconotas.web.dto.mapper.UsuarioMapper;
import com.charles.bloconotas.web.dto.usuario.UsuarioCreateDto;
import com.charles.bloconotas.web.dto.usuario.UsuarioResponseDto;

import jakarta.validation.Valid;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("api/v1/usuarios")
@RestController
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;
	
	@PostMapping
	public ResponseEntity<UsuarioResponseDto> create(@Valid @RequestBody UsuarioCreateDto usuarioCreateDto) {

		Usuario user = usuarioService.salvar(UsuarioMapper.toUsuario(usuarioCreateDto));

		return ResponseEntity.status(HttpStatus.CREATED).body(UsuarioMapper.toDto(user));
	}
	
	@GetMapping
	public ResponseEntity<List<UsuarioResponseDto>>findAll() {

		List<Usuario> users = usuarioService.findAll();

		return ResponseEntity.ok(UsuarioMapper.toListDto(users));
	}
}
