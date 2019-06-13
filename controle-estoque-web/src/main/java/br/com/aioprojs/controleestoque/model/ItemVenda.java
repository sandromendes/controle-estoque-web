package br.com.aioprojs.controleestoque.model;

import java.math.BigDecimal;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "itensvenda")
public class ItemVenda {

	@Id private ObjectId databaseId;
	private Integer id;
	@DBRef
	private List<Produto> listaProdutos;
	private int quantidade;
	private BigDecimal total;
	private BigDecimal desconto;
	@DBRef @Indexed
	private Venda venda;

	public ItemVenda(Integer id, List<Produto> listaProdutos, int quantidade, BigDecimal total, BigDecimal desconto,
			Venda venda) {
		super();
		this.id = id;
		this.listaProdutos = listaProdutos;
		this.quantidade = quantidade;
		this.total = total;
		this.desconto = desconto;
		this.venda = venda;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Produto> getListaProdutos() {
		return listaProdutos;
	}

	public void setListaProdutos(List<Produto> listaProdutos) {
		this.listaProdutos = listaProdutos;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public BigDecimal getDesconto() {
		return desconto;
	}

	public void setDesconto(BigDecimal desconto) {
		this.desconto = desconto;
	}

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}
}
