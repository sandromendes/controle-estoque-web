package br.com.aioprojs.controleestoque.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "fornecedores")
public class Fornecedor extends AbstractModel{

	@Id private ObjectId id;
	@Indexed private String nome;
	@Indexed private String cidade;
	private String telefone;
	
	public Fornecedor() {
		super();
	}

	public Fornecedor(ObjectId id, String nome, String cidade, String telefone) {
		super();
		this.id = id;
		this.nome = nome;
		this.cidade = cidade;
		this.telefone = telefone;
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

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
}
