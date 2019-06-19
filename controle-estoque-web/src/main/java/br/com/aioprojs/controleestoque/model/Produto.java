package br.com.aioprojs.controleestoque.model;

import java.math.BigDecimal;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "produtos")
public class Produto extends AbstractModel{

	@Id private ObjectId id;
	@Indexed private Integer identificador;
	@Indexed private String nome;
	private BigDecimal preco;
	@DBRef private CategoriaProduto categoria;
	@DBRef private Fornecedor fornecedor;
	@DBRef private Estoque estoque;

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

	public Produto(ObjectId id, Integer identificador, String nome, BigDecimal preco,
			CategoriaProduto categoria, Fornecedor fornecedor, Estoque estoque) {
		super();
		this.id = id;
		this.identificador = identificador;
		this.nome = nome;
		this.preco = preco;
		this.categoria = categoria;
		this.fornecedor = fornecedor;
		this.estoque = estoque;
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public Integer getIdentificador() {
		return identificador;
	}

	public void setIdentificador(Integer id) {
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
