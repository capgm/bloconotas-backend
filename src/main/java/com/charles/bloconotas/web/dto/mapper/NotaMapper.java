package com.charles.bloconotas.web.dto.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import com.charles.bloconotas.entity.Nota;
import com.charles.bloconotas.web.dto.nota.NotaCreateDto;
import com.charles.bloconotas.web.dto.nota.NotaResponseDto;
import com.charles.bloconotas.web.dto.nota.NotaUpdateDto;
import com.charles.bloconotas.web.dto.usuario.UsuarioCreateDto;

public class NotaMapper {

	public static Nota toNota(NotaCreateDto notaCreateDto) {
		return new ModelMapper().map(notaCreateDto, Nota.class);
	}

	public static Nota toNota(NotaUpdateDto notaUpdateDto) {
		return new ModelMapper().map(notaUpdateDto, Nota.class);
	}
	
	public static NotaResponseDto toDto(Nota nota) {

		ModelMapper mapper = new ModelMapper();
		return mapper.map(nota, NotaResponseDto.class);
	}

	
	public static List<NotaResponseDto> toListDto(List<Nota> notas) {

		return notas.stream().map(nota -> toDto(nota)).collect(Collectors.toList());
	}

}
