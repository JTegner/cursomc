package com.nomedaempresa.cursomc.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.nomedaempresa.cursomc.domain.Cliente;
import com.nomedaempresa.cursomc.services.validation.ClienteUpdate;

import lombok.Data;

@ClienteUpdate
@Data
public class ClienteDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	@NotEmpty(message="Preenchimento obrigatório")
	@Size(min=5, max=120, message="O tamanho deve ser entre 5 e 120 caracteres")
	private String nome;
	
	@NotEmpty(message="Preenchimento obrigatório")
	@Email(message="e-mail inválido")
	private String email;
	
	public ClienteDTO () {
	}

	public ClienteDTO(Cliente obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.email = obj.getEmail();
	}
	
	
	
	
}
