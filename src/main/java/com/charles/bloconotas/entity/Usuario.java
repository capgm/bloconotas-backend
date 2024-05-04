package com.charles.bloconotas.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name= "usuarios")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "nome", nullable = false, length = 200)
	private String nome;
	
	@Column(name = "username", nullable = false, unique = true, length = 100)
	private String username;
	
	
	@Column(name = "password", nullable = false, length = 200)
	private String password;
	
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Nota> notas;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Nota> getNotas() {
		return notas;
	}

	public void setNotas(List<Nota> notas) {
		this.notas = notas;
	}

	public Usuario(Long id, String nome, String username, String password, List<Nota> notas) {
		super();
		this.id = id;
		this.nome = nome;
		this.username = username;
		this.password = password;
		this.notas = notas;
	}

	public Usuario() {
		super();
	}	
}
