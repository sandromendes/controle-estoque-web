package br.com.aioprojs.controleestoque.service;

import java.util.List;

import org.bson.types.ObjectId;

import br.com.aioprojs.controleestoque.exception.ResourceNotFoundException;
import br.com.aioprojs.controleestoque.model.Fornecedor;

public interface FornecedorService {

	public List<Fornecedor> getListaFornecedores();
	
	public void salvarFornecedor(Fornecedor fornecedor);
	
	public Fornecedor getFornecedor(ObjectId id) throws ResourceNotFoundException;
	
	public void removerFornecedor(ObjectId id) throws ResourceNotFoundException;
}
