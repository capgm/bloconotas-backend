package com.charles.bloconotas.web.dto.nota;

import jakarta.validation.constraints.NotBlank;

public class NotaUpdateDto {

	@NotBlank
	private Long id;
	
	@NotBlank
	private String titulo;
	
	@NotBlank
	private String anotacao;

	@NotBlank
	private String username;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAnotacao() {
		return anotacao;
	}

	public void setAnotacao(String anotacao) {
		this.anotacao = anotacao;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public NotaUpdateDto(@NotBlank Long id, @NotBlank String titulo, @NotBlank String anotacao,
			@NotBlank String username) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.anotacao = anotacao;
		this.username = username;
	}

	public NotaUpdateDto() {
		super();
	}
}
