package com.charles.bloconotas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.charles.bloconotas.entity.Nota;

public interface NotaRepository extends JpaRepository<Nota, Long> {


}
