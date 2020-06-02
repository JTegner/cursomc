package com.nomedaempresa.cursomc.dto;

import java.io.Serializable;

import com.nomedaempresa.cursomc.domain.Categoria;

import lombok.Data;

@Data
public class CategoriaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nome;
	
	public CategoriaDTO() {
	}
	
	public CategoriaDTO(Categoria obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
	}
	
}
