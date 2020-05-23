package com.nomedaempresa.cursomc.domain;

import java.io.Serializable;

import lombok.Data;

@Data
public class Categoria implements Serializable {
	private static final long serialVersionUID = 1L;
	/*Serializable significa que os objetos da classe
	 * poderao ser convertidos em uma sequencia de 
	 * bites para gravar em arquivos ou trafegar em 
	 * rede. Eh uma exigencia da linguagem java
	 */
	
	private Integer id;
	private String nome;
	
	public Categoria() {
		
	}

	public Categoria(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}
	
	
	
}
