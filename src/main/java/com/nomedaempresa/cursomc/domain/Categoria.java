package com.nomedaempresa.cursomc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;

@Entity
@Data
public class Categoria implements Serializable {
	private static final long serialVersionUID = 1L;
	/*Serializable significa que os objetos da classe
	 * poderao ser convertidos em uma sequencia de 
	 * bites para gravar em arquivos ou trafegar em 
	 * rede. Eh uma exigencia da linguagem java
	 */
	
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	
	@ManyToMany(mappedBy="categorias")
	private List<Produto> produtos = new ArrayList<>();
	
	public Categoria() {
		
	}

	public Categoria(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}
	
	
	
}
