package com.oceloamarante.biblioteca;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.oceloamarante.biblioteca.domain.Categoria;
import com.oceloamarante.biblioteca.domain.Livro;
import com.oceloamarante.biblioteca.repositories.CategoriaRepository;
import com.oceloamarante.biblioteca.repositories.LivroRepository;

@SpringBootApplication
public class BibliotecaApplication implements CommandLineRunner{

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private LivroRepository livroRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(BibliotecaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Informática", "Livros de tecnologia"); //criado instancia de categoria
		
		Livro l1 = new Livro(null, "Clean code", "Robert M.", "Loren ipsum", cat1);
		
		cat1.getLivros().addAll(Arrays.asList(l1));
		
		this.categoriaRepository.saveAll(Arrays.asList(cat1));
		this.livroRepository.saveAll(Arrays.asList(l1));
		
	}

}
