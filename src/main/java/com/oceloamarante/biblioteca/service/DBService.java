package com.oceloamarante.biblioteca.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oceloamarante.biblioteca.domain.Categoria;
import com.oceloamarante.biblioteca.domain.Livro;
import com.oceloamarante.biblioteca.repositories.CategoriaRepository;
import com.oceloamarante.biblioteca.repositories.LivroRepository;

@Service
public class DBService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private LivroRepository livroRepository;

	public void instanciaBaseDeDados() {

		Categoria cat1 = new Categoria(null, "Informática", "Livros de tecnologia"); // criado instancia de categoria
		Categoria cat2 = new Categoria(null, "Ficção Científica", "Ficção Científica");
		Categoria cat3 = new Categoria(null, "Biografias", "Livros de Biografias");

		Livro l1 = new Livro(null, "Clean code", "Robert M.", "Loren ipsum", cat1);
		Livro l2 = new Livro(null, "Engenharia de Software", "Louis V.", "Loren ipsum", cat1);
		Livro l3 = new Livro(null, "The Time Machine", "H.G.", "Loren ipsum", cat1);
		Livro l4 = new Livro(null, "The War of the Worlds", "Lorem", "Loren ipsum", cat1);
		Livro l5 = new Livro(null, "I, Robot", "Robert M.", "Loren ipsum", cat1);

		cat1.getLivros().addAll(Arrays.asList(l1, l2));
		cat2.getLivros().addAll(Arrays.asList(l3, l4, l5));

		this.categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		this.livroRepository.saveAll(Arrays.asList(l1, l2, l3, l4, l5));

	}

}
