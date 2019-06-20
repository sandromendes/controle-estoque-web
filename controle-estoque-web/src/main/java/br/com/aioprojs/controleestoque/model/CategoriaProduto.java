package br.com.aioprojs.controleestoque.model;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "categorias")
public class CategoriaProduto {

	@Id private ObjectId id;
	@Indexed private String nome;
	private String descricao;
	@DBRef	private List<Produto> listaProdutos;
	
	public CategoriaProduto() {
		super();
	}

	public CategoriaProduto(ObjectId id, String nome, String descricao, List<Produto> listaProdutos) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.listaProdutos = listaProdutos;
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Produto> getListaProdutos() {
		return listaProdutos;
	}

	public void setListaProdutos(List<Produto> listaProdutos) {
		this.listaProdutos = listaProdutos;
	}
}
