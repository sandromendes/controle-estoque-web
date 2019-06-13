package br.com.aioprojs.controleestoque.model;

import java.math.BigDecimal;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "produtos")
public class Produto {

	@Id private ObjectId databaseId;
	private Integer identificador;
	private String nome;
	private BigDecimal preco;
	@DBRef @Indexed
	private CategoriaProduto categoria;
	@DBRef @Indexed
	private Fornecedor fornecedor;
	@DBRef @Indexed
	private Estoque estoque;

	public Produto() {
		super();
	}

	public Produto(Integer id, String nome, BigDecimal preco, CategoriaProduto categoria, 
			Fornecedor fornecedor, Estoque estoque) {
		super();
		this.identificador = id;
		this.nome = nome;
		this.preco = preco;
		this.categoria = categoria;
		this.fornecedor = fornecedor;
		this.estoque = estoque;
	}

	public Integer getId() {
		return identificador;
	}

	public void setId(Integer id) {
		this.identificador = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public CategoriaProduto getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaProduto categoria) {
		this.categoria = categoria;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public Estoque getEstoque() {
		return estoque;
	}

	public void setEstoque(Estoque estoque) {
		this.estoque = estoque;
	}
}
