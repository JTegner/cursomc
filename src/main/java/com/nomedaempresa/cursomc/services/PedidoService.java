package com.nomedaempresa.cursomc.services;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nomedaempresa.cursomc.domain.ItemPedido;
import com.nomedaempresa.cursomc.domain.PagamentoComBoleto;
import com.nomedaempresa.cursomc.domain.Pedido;
import com.nomedaempresa.cursomc.domain.Produto;
import com.nomedaempresa.cursomc.domain.enums.EstadoPagamento;
import com.nomedaempresa.cursomc.repositories.ItemPedidoRepository;
import com.nomedaempresa.cursomc.repositories.PagamentoRepository;
import com.nomedaempresa.cursomc.repositories.PedidoRepository;
import com.nomedaempresa.cursomc.repositories.ProdutoRepository;
import com.nomedaempresa.cursomc.services.exception.ObjectNotFoundException;

@Service
public class PedidoService {
	
	@Autowired /* instancia a classe CategoriaRepository aqui */
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;

	@Autowired
	private BoletoService boletoService;
	
	public Pedido find(Integer id) {
		Optional<Pedido> obj = pedidoRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto nao encontrado Id: " + id + " Tipo: " + Pedido.class.getName()));
		}
	
	public Pedido insert(Pedido obj) {
		obj.setId(null);
		obj.setInstante(new Date());
		obj.getPagamento().setEstado(EstadoPagamento.PENDENTE);
		obj.getPagamento().setPedido(obj);
		if (obj.getPagamento() instanceof PagamentoComBoleto) {
			PagamentoComBoleto pagto = (PagamentoComBoleto) obj.getPagamento();
			boletoService.preencherPagamentoComBoleto(pagto, obj.getInstante());
		}
		obj = pedidoRepository.save(obj);
		pagamentoRepository.save(obj.getPagamento());
		for (ItemPedido ip : obj.getItens()) {
			ip.setDesconto(0.0);
			ip.setPreco(produtoRepository.findById(ip.getProduto().getId()).get().getPreco());
			ip.setPedido(obj);
		}
		itemPedidoRepository.saveAll(obj.getItens());
		return obj;
	}
}
