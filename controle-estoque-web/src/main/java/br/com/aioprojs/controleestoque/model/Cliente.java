package br.com.aioprojs.controleestoque.model;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "clientes")
public class Cliente {

	@Id private ObjectId databaseId;
	private Integer id;
	private String nome;
	private String telefone;
	@DBRef
	private List<Venda> listaVendas;

	public Cliente(Integer id, String nome, String telefone, List<Venda> listaVendas) {
		super();
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.listaVendas = listaVendas;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public List<Venda> getListaVendas() {
		return listaVendas;
	}

	public void setListaVendas(List<Venda> listaVendas) {
		this.listaVendas = listaVendas;
	}
}
