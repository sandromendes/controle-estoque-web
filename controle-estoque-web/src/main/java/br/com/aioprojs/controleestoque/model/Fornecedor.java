package br.com.aioprojs.controleestoque.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "fornecedores")
public class Fornecedor {

	@Id private ObjectId databaseId;
	@Indexed
	private Integer identificador;
	private String nome;
	
	public Fornecedor() {
		super();
	}

	public Fornecedor(Integer id, String nome) {
		super();
		this.identificador = id;
		this.nome = nome;
	}

	public Fornecedor(ObjectId databaseId, Integer identificador, String nome) {
		super();
		this.databaseId = databaseId;
		this.identificador = identificador;
		this.nome = nome;
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
}
