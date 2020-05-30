package com.nomedaempresa.cursomc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Entity
@Data
public class Pedido implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	private Date instante;
	
	/* necessário para evitar um erro de entidade transiente quando vai sarvar um pedido e o pagamento dele*/
	@OneToOne(cascade = CascadeType.ALL, mappedBy="pedido") 
	private Pagamento pagamento;

	@ManyToOne
	@JoinColumn(name="cliente_id")
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name="endedeco_de_entrega_id")
	private Endereco enderecoDeEntrega;
	
	/*Set para java garantir que nao vai ter item repetido no pedido*/
	@OneToMany(mappedBy="id.pedido")
	private Set<ItemPedido> itens = new HashSet<>();
	
	public Pedido() {
	}

	public Pedido(Integer id, Date instante, Cliente cliente, Endereco enderecoDeEntrega) {
		super();
		this.id = id;
		this.instante = instante;
		this.cliente = cliente;
		this.enderecoDeEntrega = enderecoDeEntrega;
	}
	
	
}