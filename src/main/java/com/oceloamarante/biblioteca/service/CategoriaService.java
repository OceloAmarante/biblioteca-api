package com.oceloamarante.biblioteca.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oceloamarante.biblioteca.domain.Categoria;
import com.oceloamarante.biblioteca.dtos.CategoriaDTO;
import com.oceloamarante.biblioteca.repositories.CategoriaRepository;
import com.oceloamarante.biblioteca.service.exceptions.DataIntegrityViolationException;
import com.oceloamarante.biblioteca.service.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repository;
	
	public Categoria findById(Integer id) {
		Optional<Categoria> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));			
	}
	
	public List<Categoria> findAll(){
		return repository.findAll();
	}
	
	public Categoria create(Categoria obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	public Categoria update(Integer id, CategoriaDTO objDto) {
		Categoria obj = findById(id);
		obj.setNome(objDto.getNome());
		obj.setDescriçao(objDto.getDescricao());
		return repository.save(obj);
		
	}

	public void delete(Integer id) {
		findById(id);
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new org.springframework.dao.DataIntegrityViolationException("Categoria não pode ser deletada! Possui livros associados");
		}
	}
}
