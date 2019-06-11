package br.com.aioprojs.controleestoque.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.aioprojs.controleestoque.exception.ResourceNotFoundException;
import br.com.aioprojs.controleestoque.model.Cliente;
import br.com.aioprojs.controleestoque.model.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository clienteRepository; 
	
	@Override
	@Transactional
	public List<Cliente> getListaClientes() {
		return clienteRepository.findAll();
	}

	@Override
	@Transactional
	public void salvarCliente(Cliente cliente) {
		clienteRepository.save(cliente);
	}

	@Override
	@Transactional
	public Cliente getCliente(Long id) throws ResourceNotFoundException{
		return clienteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id) );
	}

	@Override
	@Transactional
	public void removerCliente(Long id) {
		clienteRepository.deleteById(id);
	}

}
