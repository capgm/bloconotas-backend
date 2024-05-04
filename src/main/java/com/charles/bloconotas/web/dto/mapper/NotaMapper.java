package com.charles.bloconotas.web.dto.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import com.charles.bloconotas.entity.Nota;
import com.charles.bloconotas.web.dto.nota.NotaResponseDto;
import com.charles.bloconotas.web.dto.usuario.UsuarioCreateDto;

public class NotaMapper {

	public static Nota toNota(UsuarioCreateDto usuarioCreateDto) {
		return new ModelMapper().map(usuarioCreateDto, Nota.class);
	}

	public static NotaResponseDto toDto(Nota usuario) {

		ModelMapper mapper = new ModelMapper();
		return mapper.map(usuario, NotaResponseDto.class);
	}

	public static List<NotaResponseDto> toListDto(List<Nota> notas) {

		return notas.stream().map(nota -> toDto(nota)).collect(Collectors.toList());
	}

}
