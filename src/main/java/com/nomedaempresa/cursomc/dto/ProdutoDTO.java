package com.nomedaempresa.cursomc.dto;

import java.io.Serializable;

import com.nomedaempresa.cursomc.domain.Produto;

import lombok.Data;

@Data
public class ProdutoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nome;
	private Double preco;
	
	public ProdutoDTO() {
	}
	
	public ProdutoDTO(Produto obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.preco = obj.getPreco();
	}
	
	
}
