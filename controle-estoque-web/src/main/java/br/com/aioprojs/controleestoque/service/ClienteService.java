package br.com.aioprojs.controleestoque.service;

import java.util.List;

import br.com.aioprojs.controleestoque.exception.ResourceNotFoundException;
import br.com.aioprojs.controleestoque.model.Cliente;

public interface ClienteService {

	public List<Cliente> getListaClientes();
	
	public void salvarCliente(Cliente cliente);

	public Cliente getCliente(Long id) throws ResourceNotFoundException;
	
	public void removerCliente(Long id) throws ResourceNotFoundException;
}
