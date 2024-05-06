package com.charles.bloconotas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.charles.bloconotas.entity.Nota;
import com.charles.bloconotas.service.NotaService;
import com.charles.bloconotas.web.dto.mapper.NotaMapper;
import com.charles.bloconotas.web.dto.nota.NotaCreateDto;
import com.charles.bloconotas.web.dto.nota.NotaResponseDto;

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
	
	@PutMapping("/{id}")
	public ResponseEntity<Nota> update(@Valid @RequestBody NotaCreateDto notaCreateDto, @PathVariable("id") Long id) {
		return notaService.update(id, notaCreateDto);
	}
		
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {		

		return notaService.delete(id);
	}
}
