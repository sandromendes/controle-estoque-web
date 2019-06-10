package br.com.aioprojs.controleestoque.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Document
public class Estoque {

	@Id
	private Long id;
	private Integer quantidade;
	private Integer minimo;
	private Integer maximo;
	@DBRef
	private Produto produto;
	
	public Estoque() {
		super();
	}

	public Estoque(Long id, Integer quantidade, Integer minimo, Integer maximo, Produto produto) {
		super();
		this.id = id;
		this.quantidade = quantidade;
		this.minimo = minimo;
		this.maximo = maximo;
		this.produto = produto;
	}
}
