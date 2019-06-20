package br.com.aioprojs.controleestoque.service;

import java.util.List;

import org.bson.types.ObjectId;

import br.com.aioprojs.controleestoque.exception.ResourceNotFoundException;
import br.com.aioprojs.controleestoque.model.Estoque;

public interface EstoqueService {

	public List<Estoque> getListaEstoques();
	
	public Estoque salvarEstoque(Estoque estoque);

	public Estoque getEstoque(ObjectId id) throws ResourceNotFoundException;
	
	public void removerEstoque(ObjectId id) throws ResourceNotFoundException;
}
