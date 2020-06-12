package com.nomedaempresa.cursomc.resources;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.nomedaempresa.cursomc.domain.Categoria;
import com.nomedaempresa.cursomc.domain.Pedido;
import com.nomedaempresa.cursomc.dto.CategoriaDTO;
import com.nomedaempresa.cursomc.services.PedidoService;

@RestController
@RequestMapping(value="/pedidos")
public class PedidoResource {
	
	@Autowired
	private PedidoService pedidoService;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Pedido> find(@PathVariable Integer id) {
		/* ResponseEntity spring encapsula varias informacoes de uma resposta http*/
		/* <?> qualquer tipo */
		
		Pedido obj = pedidoService.find(id);
		//return ResponseEntity.ok().body(obj);
		return obj != null ? ResponseEntity.ok(obj) : ResponseEntity.noContent().build();
	}

	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody Pedido obj) {
		obj = pedidoService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	
}
