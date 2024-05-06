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

import com.charles.bloconotas.entity.Nota;
import com.charles.bloconotas.service.NotaService;
import com.charles.bloconotas.web.dto.mapper.NotaMapper;
import com.charles.bloconotas.web.dto.mapper.UsuarioMapper;
import com.charles.bloconotas.web.dto.nota.NotaCreateDto;
import com.charles.bloconotas.web.dto.nota.NotaResponseDto;
import com.charles.bloconotas.web.dto.usuario.UsuarioCreateDto;

import jakarta.validation.Valid;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("api/v1/notas")
@RestController
public class NotaController {
	
	@Autowired
	NotaService notaService;
	
	@PostMapping
	public ResponseEntity<NotaResponseDto> create(@Valid @RequestBody NotaCreateDto notaCreateDto) {

		Nota nota = notaService.salvar(notaCreateDto);

		return ResponseEntity.status(HttpStatus.CREATED).body(NotaMapper.toDto(nota));
	}
	
	@GetMapping
	public ResponseEntity<List<NotaResponseDto>> findAll() {

		List<Nota> notas = notaService.findAll();

		return ResponseEntity.ok(NotaMapper.toListDto(notas));
	}
}
