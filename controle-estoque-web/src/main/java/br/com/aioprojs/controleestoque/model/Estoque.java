package br.com.aioprojs.controleestoque.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "estoques")
public class Estoque {

	@Id private ObjectId id;
	@Indexed private String lote;
	private boolean bloqueado;
	private int quantidade;
	private int minimo;
	private int maximo;
	@DBRef
	private Produto produto;
	
	public Estoque() {
		super();
	}

	public Estoque(ObjectId id, String lote, boolean bloqueado, int quantidade, int minimo,
			int maximo, Produto produto) {
		super();
		this.id = id;
		this.lote = lote;
		this.bloqueado = bloqueado;
		this.quantidade = quantidade;
		this.minimo = minimo;
		this.maximo = maximo;
		this.produto = produto;
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}
	
	public String getLote() {
		return lote;
	}

	public void setLote(String codigoLote) {
		this.lote = codigoLote;
	}

	public boolean isBloqueado() {
		return bloqueado;
	}

	public void setBloqueado(boolean bloqueado) {
		this.bloqueado = bloqueado;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public int getMinimo() {
		return minimo;
	}

	public void setMinimo(int minimo) {
		this.minimo = minimo;
	}

	public int getMaximo() {
		return maximo;
	}

	public void setMaximo(int maximo) {
		this.maximo = maximo;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
}
