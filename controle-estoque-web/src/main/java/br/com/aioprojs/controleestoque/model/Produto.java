package br.com.aioprojs.controleestoque.model;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Document(collection = "produto")
public class Produto {

	@Id
	private Long id;
	private String nome;
	private BigDecimal preco;
	@DBRef
	private CategoriaProduto categoria;
	@DBRef
	private Fornecedor fornecedor;
	@DBRef
	private Estoque estoque;

	public Produto() {
		super();
	}

	public Produto(Long id, String nome, BigDecimal preco, CategoriaProduto categoria, Fornecedor fornecedor,
			Estoque estoque) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.categoria = categoria;
		this.fornecedor = fornecedor;
		this.estoque = estoque;
	}
}
