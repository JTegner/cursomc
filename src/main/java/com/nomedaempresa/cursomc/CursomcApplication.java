package com.nomedaempresa.cursomc;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nomedaempresa.cursomc.domain.Categoria;
import com.nomedaempresa.cursomc.domain.Cidade;
import com.nomedaempresa.cursomc.domain.Cliente;
import com.nomedaempresa.cursomc.domain.Endereco;
import com.nomedaempresa.cursomc.domain.Estado;
import com.nomedaempresa.cursomc.domain.ItemPedido;
import com.nomedaempresa.cursomc.domain.Pagamento;
import com.nomedaempresa.cursomc.domain.PagamentoComBoleto;
import com.nomedaempresa.cursomc.domain.PagamentoComCartao;
import com.nomedaempresa.cursomc.domain.Pedido;
import com.nomedaempresa.cursomc.domain.Produto;
import com.nomedaempresa.cursomc.domain.enums.EstadoPagamento;
import com.nomedaempresa.cursomc.domain.enums.TipoCliente;
import com.nomedaempresa.cursomc.repositories.CategoriaRepository;
import com.nomedaempresa.cursomc.repositories.CidadeRepository;
import com.nomedaempresa.cursomc.repositories.ClienteRepository;
import com.nomedaempresa.cursomc.repositories.EnderecoRepository;
import com.nomedaempresa.cursomc.repositories.EstadoRepository;
import com.nomedaempresa.cursomc.repositories.ItemPedidoRepository;
import com.nomedaempresa.cursomc.repositories.PagamentoRepository;
import com.nomedaempresa.cursomc.repositories.PedidoRepository;
import com.nomedaempresa.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {		
	}

}
