package com.nomedaempresa.cursomc.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(of = "id", callSuper = false)
public class Sorteios implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "srt_sorteio")
	private Integer srtSorteio;

	@Column(name = "srt_nro1")
	private Integer srtNro1;

	@Column(name = "srt_nro2")
	private Integer srtNro2;

	@Column(name = "srt_nro3")
    private Integer srtNro3;
	
	@Column(name = "srt_nro4")
	private Integer srtNro4;
	
	@Column(name = "srt_nro5")
	private Integer srtNro5;

	@Column(name = "srt_nro6")
    private Integer srtNro6;

	public Sorteios() {
	}

	public Sorteios(Integer srtsorteio, Integer srtNro1, Integer srtNro2, Integer srtNro3, Integer srtNro4, Integer srtNro5, Integer srtNro6) {
		super();
		this.srtSorteio = srtsorteio;
		this.srtNro1 = srtNro1;
		this.srtNro2 = srtNro2;
		this.srtNro3 = srtNro3;
		this.srtNro4 = srtNro4;
		this.srtNro5 = srtNro5;
		this.srtNro6 = srtNro6;
	}
	
}
