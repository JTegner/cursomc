package com.nomedaempresa.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nomedaempresa.cursomc.domain.Categoria;
import com.nomedaempresa.cursomc.domain.Cidade;
import com.nomedaempresa.cursomc.domain.Estado;
import com.nomedaempresa.cursomc.domain.Produto;
import com.nomedaempresa.cursomc.repositories.CategoriaRepository;
import com.nomedaempresa.cursomc.repositories.CidadeRepository;
import com.nomedaempresa.cursomc.repositories.EstadoRepository;
import com.nomedaempresa.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		/*
		Categoria cat1 = new Categoria(1,"Informática");
		Categoria cat2 = new Categoria(2,"Escritório");
		
		Produto p1 = new Produto(1,"Computador", 2000.00);
		Produto p2 = new Produto(2,"Impressora", 800.00);
		Produto p3 = new Produto(3,"Mouse", 80.00);
		
		categoriaRepository.deleteAll();
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		
		produtoRepository.deleteAll();
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));

		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
		*/
		
		/*
		Estado est1 = new Estado(1,"Minas Gerais");
		Estado est2 = new Estado(2,"São Paulo");
		
		estadoRepository.deleteAll();
		estadoRepository.saveAll(Arrays.asList(est1, est2));

		cidadeRepository.deleteAll();

		Cidade c1 = new Cidade(1,"Uberlândia", est1);
		Cidade c2 = new Cidade(2,"São Paulo", est2);
		Cidade c3 = new Cidade(3,"Campinas", est2);
		
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));

		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));

		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
		*/
		

	}

}
