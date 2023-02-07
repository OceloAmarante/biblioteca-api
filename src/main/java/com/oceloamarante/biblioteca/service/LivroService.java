package com.oceloamarante.biblioteca.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oceloamarante.biblioteca.domain.Livro;
import com.oceloamarante.biblioteca.repositories.LivroRepository;
import com.oceloamarante.biblioteca.service.exceptions.ObjectNotFoundException;

@Service
public class LivroService {
	
	@Autowired
	private LivroRepository repository;
	
	public Livro findById(Integer id) {
		Optional<Livro> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Livro.class.getName()));
	}
	
	
}
