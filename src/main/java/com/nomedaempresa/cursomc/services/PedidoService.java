package com.nomedaempresa.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nomedaempresa.cursomc.domain.Pedido;
import com.nomedaempresa.cursomc.repositories.PedidoRepository;
import com.nomedaempresa.cursomc.services.exception.ObjectNotFoundException;

@Service
public class PedidoService {
	
	@Autowired /* instancia a classe CategoriaRepository aqui */
	private PedidoRepository pedidoRepository;
	
	public Pedido buscar(Integer id) {
		Optional<Pedido> obj = pedidoRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto nao encontrado Id: " + id + " Tipo: " + Pedido.class.getName()));
		}
	
}
