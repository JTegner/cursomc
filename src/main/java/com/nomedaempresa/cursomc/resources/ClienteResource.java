package com.nomedaempresa.cursomc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nomedaempresa.cursomc.domain.Cliente;
import com.nomedaempresa.cursomc.services.ClienteService;

@RestController
@RequestMapping(value="/clientes")
public class ClienteResource {
	
	@Autowired
	private ClienteService clienteService;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		/* ResponseEntity spring encapsula varias informacoes de uma resposta http*/
		/* <?> qualquer tipo */
		
		Cliente obj = clienteService.buscar(id);
		//return ResponseEntity.ok().body(obj);
		return obj != null ? ResponseEntity.ok(obj) : ResponseEntity.noContent().build();
	}

}
