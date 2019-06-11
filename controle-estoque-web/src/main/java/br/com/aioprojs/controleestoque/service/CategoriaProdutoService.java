package br.com.aioprojs.controleestoque.service;

import java.util.List;

import br.com.aioprojs.controleestoque.exception.ResourceNotFoundException;
import br.com.aioprojs.controleestoque.model.CategoriaProduto;

public interface CategoriaProdutoService {

	public List<CategoriaProduto> getListaCategorias();
	
	public void salvarCategoria(CategoriaProduto categoria);
	
	public CategoriaProduto getCategoria(Long id) throws ResourceNotFoundException;
	
	public void removerCategoria(Long id) throws ResourceNotFoundException;
	
}
