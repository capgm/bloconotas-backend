package com.charles.bloconotas.web.dto.nota;

public class NotaResponseDto {
	
	private Long id;	
	
	private String titulo;
	
	private String anotacao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAnotacao() {
		return anotacao;
	}

	public void setAnotacao(String anotacao) {
		this.anotacao = anotacao;
	}	
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public NotaResponseDto(Long id, String anotacao) {
		super();
		this.id = id;
		this.anotacao = anotacao;
	}

	public NotaResponseDto() {
		super();
	}
}
