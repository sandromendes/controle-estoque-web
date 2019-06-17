package br.com.aioprojs.controleestoque.service;

import java.util.List;

import org.bson.types.ObjectId;

import br.com.aioprojs.controleestoque.exception.ResourceNotFoundException;
import br.com.aioprojs.controleestoque.model.CategoriaProduto;

public interface CategoriaProdutoService {

	public List<CategoriaProduto> getListaCategorias();
	
	public void salvarCategoria(CategoriaProduto categoria);
	
	public void salvarListaCategoria(List<CategoriaProduto> lista);
	
	public CategoriaProduto getCategoria(ObjectId id) throws ResourceNotFoundException;
	
	public void removerCategoria(ObjectId id) throws ResourceNotFoundException;
	
	public CategoriaProduto buscarPorNome(String nome);
	
}
