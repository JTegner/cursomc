package com.nomedaempresa.cursomc.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.nomedaempresa.cursomc.domain.Categoria;
import com.nomedaempresa.cursomc.domain.Sorteios;

import lombok.Data;

@Data
public class SorteiosDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer srtSorteio;
	private Integer srtNro1;
	private Integer srtNro2;
	private Integer srtNro3;
	private Integer srtNro4;
	private Integer srtNro5;
	private Integer srtNro6;
	
	public SorteiosDTO() {
	}
	
	public SorteiosDTO(Sorteios obj) {
		this.srtSorteio = obj.getSrtSorteio();
		this.srtNro1 = obj.getSrtNro1();
		this.srtNro2 = obj.getSrtNro2();
		this.srtNro3 = obj.getSrtNro3();
		this.srtNro4 = obj.getSrtNro4();
		this.srtNro5 = obj.getSrtNro5();
		this.srtNro6 = obj.getSrtNro6();
	}
	
}
