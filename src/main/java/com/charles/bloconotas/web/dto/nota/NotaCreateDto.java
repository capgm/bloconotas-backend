package com.charles.bloconotas.web.dto.nota;
import jakarta.validation.constraints.NotBlank;

public class NotaCreateDto {

	@NotBlank
	private String anotacao;

	@NotBlank
	private Long usuario_id;
}
