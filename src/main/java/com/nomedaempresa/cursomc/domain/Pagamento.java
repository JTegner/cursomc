package com.nomedaempresa.cursomc.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.nomedaempresa.cursomc.domain.enums.EstadoPagamento;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@EqualsAndHashCode(of = "id", callSuper = false)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "@type")
public abstract class Pagamento implements Serializable {
	private static final long serialVersionUID = 1L;

	/*
	 * na requisiscao quando vier @type o jackson vai instanciar a classe que o @type informar
	 * a anotacao @JsonTypeInfo indica que a classe pagamento tera um campo adicional o @type
	 * eh do pacote jackson que eh o pacote que estamos usando para serializar e desserializar o json
	 * import com.fasterxml.jackson.annotation.JsonTypeInfo;
	 * ...
	 * "pagamento" : {
	 *	"numeroDeParcelas" : 10,
	 *	"@type": "pagamentoComCartao"
	 *	},
	 *	...
	 * a classe pagamneto eh abstrata nao pode ser instanciada o jackson vai instanciar a classe informada
	 */
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer estado;
	
	@JsonIgnore
	@OneToOne
	@JoinColumn(name="pedido_id")
	@MapsId /*para dizer que o id do pedido eh igual ao id do pedido*/
	private Pedido pedido;
	
	public Pagamento () {
	}

	public Pagamento(Integer id, EstadoPagamento estado, Pedido pedido) {
		super();
		this.id = id;
		this.estado = (estado==null) ? null : estado.getCod();
		this.pedido = pedido;
	}
	
	public EstadoPagamento getEstado() {
		return EstadoPagamento.toEnum(estado);
	}
	
	public void setEstado(EstadoPagamento estado) {
		this.estado = estado.getCod();
	}
	
}
