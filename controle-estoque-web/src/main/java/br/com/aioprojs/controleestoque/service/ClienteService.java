package br.com.aioprojs.controleestoque.service;

import java.util.List;

import org.bson.types.ObjectId;

import br.com.aioprojs.controleestoque.exception.ResourceNotFoundException;
import br.com.aioprojs.controleestoque.model.Cliente;

public interface ClienteService {

	public List<Cliente> getListaClientes();
	
	public void salvarCliente(Cliente cliente);

	public Cliente getCliente(ObjectId id) throws ResourceNotFoundException;
	
	public void removerCliente(ObjectId id) throws ResourceNotFoundException;
}
