package com.charles.bloconotas.web.dto.usuario;


public class UsuarioResponseLoginDto {

	private String username;
	
	private String token;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public UsuarioResponseLoginDto(String username, String token) {
		super();
		this.username = username;
		this.token = token;
	}

	public UsuarioResponseLoginDto() {
		super();
	}
}
