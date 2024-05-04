package com.charles.bloconotas.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.charles.bloconotas.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	Optional<Usuario> findByUsername(String username);

}
