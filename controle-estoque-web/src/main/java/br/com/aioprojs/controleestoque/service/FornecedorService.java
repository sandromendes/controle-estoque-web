package br.com.aioprojs.controleestoque.service;

import java.util.List;

import br.com.aioprojs.controleestoque.exception.ResourceNotFoundException;
import br.com.aioprojs.controleestoque.model.Fornecedor;

public interface FornecedorService {

	public List<Fornecedor> getListaFornecedores();
	
	public void salvarFornecedor(Fornecedor fornecedor);
	
	public Fornecedor getFornecedor(Long id) throws ResourceNotFoundException;
	
	public void removerFornecedor(Long id) throws ResourceNotFoundException;
}
