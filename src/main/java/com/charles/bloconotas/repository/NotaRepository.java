package com.charles.bloconotas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.charles.bloconotas.entity.Nota;

public interface NotaRepository extends JpaRepository<Nota, Long> {

	@Query(value = "select notas.* from notas inner join usuarios on notas.usuario_id = usuarios.id WHERE username = :username", nativeQuery = true)
	List<Nota> findNotasByUsuario(String username);
}
