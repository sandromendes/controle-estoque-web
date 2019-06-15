package br.com.aioprojs.controleestoque.model;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "categorias")
public class CategoriaProduto {

	@Id private ObjectId databaseId;
	private Integer identificador;	
	@Indexed
	private String nome;
	@DBRef
	private List<Produto> listaProdutos;
	
	public CategoriaProduto() {
		super();
	}

	public CategoriaProduto(Integer identificador, String nome, List<Produto> listaProdutos) {
		super();
		this.identificador = identificador;
		this.nome = nome;
		this.listaProdutos = listaProdutos;
	}
	
	public CategoriaProduto(ObjectId databaseId, Integer identificador, String nome, List<Produto> listaProdutos) {
		super();
		this.databaseId = databaseId;
		this.identificador = identificador;
		this.nome = nome;
		this.listaProdutos = listaProdutos;
	}
	
	public ObjectId getDatabaseId() {
		return databaseId;
	}

	public void setDatabaseId(ObjectId databaseId) {
		this.databaseId = databaseId;
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

	public List<Produto> getListaProdutos() {
		return listaProdutos;
	}

	public void setListaProdutos(List<Produto> listaProdutos) {
		this.listaProdutos = listaProdutos;
	}
}
