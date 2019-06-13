package br.com.aioprojs.controleestoque.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "categorias")
public class CategoriaProduto {

	@Id private ObjectId databaseId;
	private Integer identificador;	
	@Indexed
	private String nome;
	
	public CategoriaProduto() {
		super();
	}

	public CategoriaProduto(Integer id, String nome) {
		super();
		this.identificador = id;
		this.nome = nome;
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
}
