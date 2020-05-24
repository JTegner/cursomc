package com.nomedaempresa.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nomedaempresa.cursomc.domain.Categoria;
import com.nomedaempresa.cursomc.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired /* instancia a classe CategoriaRepository aqui */
	private CategoriaRepository categoriaRepository;
	
	public Categoria buscar(Integer id) {
		Optional<Categoria> obj = categoriaRepository.findById(id);
		return obj.orElse(null);
	}

}
