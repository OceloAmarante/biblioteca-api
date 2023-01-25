package com.oceloamarante.biblioteca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oceloamarante.biblioteca.domain.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer>{

	
}
