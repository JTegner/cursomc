package com.nomedaempresa.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nomedaempresa.cursomc.domain.Categoria;
import com.nomedaempresa.cursomc.domain.Cliente;
import com.nomedaempresa.cursomc.repositories.ClienteRepository;
import com.nomedaempresa.cursomc.services.exception.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired /* instancia a classe CategoriaRepository aqui */
	private ClienteRepository clienteRepository;
	
	public Cliente find(Integer id) {
		Optional<Cliente> obj = clienteRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto nao encontrado Id: " + id + " Tipo: " + Cliente.class.getName()));
		}
	
}
