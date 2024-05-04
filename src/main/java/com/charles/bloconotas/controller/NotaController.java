package com.charles.bloconotas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.charles.bloconotas.entity.Nota;
import com.charles.bloconotas.service.NotaService;
import com.charles.bloconotas.web.dto.mapper.NotaMapper;
import com.charles.bloconotas.web.dto.nota.NotaResponseDto;
import com.charles.bloconotas.web.dto.usuario.UsuarioCreateDto;

import jakarta.validation.Valid;

@RequestMapping("api/v1/notas")
@RestController
public class NotaController {
	
	@Autowired
	NotaService notaService;
	
	@PostMapping
	public ResponseEntity<NotaResponseDto> create(@Valid @RequestBody UsuarioCreateDto notaCreateDto) {

		Nota nota = notaService.salvar(NotaMapper.toNota(notaCreateDto));

		return ResponseEntity.status(HttpStatus.CREATED).body(NotaMapper.toDto(nota));
	}
}
