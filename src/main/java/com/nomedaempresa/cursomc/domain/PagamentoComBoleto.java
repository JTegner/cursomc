package com.nomedaempresa.cursomc.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.nomedaempresa.cursomc.domain.enums.EstadoPagamento;

import lombok.Data;

@Entity
@Data
public class PagamentoComBoleto extends Pagamento {
	private static final long serialVersionUID = 1L;
	
	private Date dataVencimento;
	private Date dataPagamento;
	
	public PagamentoComBoleto() {
	}

	public PagamentoComBoleto(Integer id, EstadoPagamento estado, Pedido pedido, Date dataVencimento, Date dataPagamento) {
		super(id, estado, pedido);
		this.dataPagamento = dataPagamento;
		this.dataVencimento = dataVencimento;
	}

	
}
