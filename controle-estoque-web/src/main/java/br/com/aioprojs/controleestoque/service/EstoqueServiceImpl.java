package br.com.aioprojs.controleestoque.service;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.aioprojs.controleestoque.exception.ResourceNotFoundException;
import br.com.aioprojs.controleestoque.model.Estoque;
import br.com.aioprojs.controleestoque.model.EstoqueRepository;

@Service
public class EstoqueServiceImpl implements EstoqueService {

	@Autowired EstoqueRepository estoqueRepository;
	
	@Override
	@Transactional
	public List<Estoque> getListaEstoques() {
		return estoqueRepository.findAll();
	}

	@Override
	@Transactional
	public Estoque salvarEstoque(Estoque estoque) {
		return estoqueRepository.save(estoque);
	}

	@Override
	@Transactional
	public Estoque getEstoque(ObjectId id) throws ResourceNotFoundException {
		return estoqueRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id) );
	}

	@Override
	@Transactional
	public void removerEstoque(ObjectId id) throws ResourceNotFoundException {
		estoqueRepository.deleteById(id);
	}
}
