package br.com.aioprojs.controleestoque.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.aioprojs.controleestoque.exception.ResourceNotFoundException;
import br.com.aioprojs.controleestoque.model.Fornecedor;
import br.com.aioprojs.controleestoque.model.FornecedorRepository;

@Service
public class FornecedorServiceImpl implements FornecedorService {

	@Autowired
	private FornecedorRepository fornecedorRepository;
	
	@Override
	@Transactional
	public List<Fornecedor> getListaFornecedores() {
		return fornecedorRepository.findAll();
	}

	@Override
	@Transactional
	public void salvarFornecedor(Fornecedor fornecedor) {
		fornecedorRepository.save(fornecedor);
	}

	@Override
	@Transactional
	public Fornecedor getFornecedor(Long id) throws ResourceNotFoundException {
		return fornecedorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
	}

	@Override
	@Transactional
	public void removerFornecedor(Long id) throws ResourceNotFoundException {
		fornecedorRepository.deleteById(id);
	}

}
