package br.com.aioprojs.controleestoque.service;

import java.util.List;

import org.bson.types.ObjectId;

import br.com.aioprojs.controleestoque.exception.ResourceNotFoundException;
import br.com.aioprojs.controleestoque.model.Produto;

public interface ProdutoService {

	public List<Produto> getListaProdutos();
	
	public void salvarProduto(Produto produto);
	
	public Produto getProduto(ObjectId id) throws ResourceNotFoundException;
	
	public void removerProduto(ObjectId id) throws ResourceNotFoundException;
}
