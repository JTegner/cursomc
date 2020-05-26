package com.nomedaempresa.cursomc.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nomedaempresa.cursomc.domain.Categoria;
import com.nomedaempresa.cursomc.services.CategoriaService;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {
	
	@Autowired
	private CategoriaService categoriaService;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		/* ResponseEntity spring encapsula varias informacoes de uma resposta http*/
		/* <?> qualquer tipo */
		
		Categoria obj = categoriaService.buscar(id);
		//return ResponseEntity.ok().body(obj);
		return obj != null ? ResponseEntity.ok(obj) : ResponseEntity.noContent().build();
	}

}
