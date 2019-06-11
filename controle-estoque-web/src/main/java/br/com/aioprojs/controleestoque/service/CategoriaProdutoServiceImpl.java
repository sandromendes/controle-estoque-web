package br.com.aioprojs.controleestoque.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.aioprojs.controleestoque.exception.ResourceNotFoundException;
import br.com.aioprojs.controleestoque.model.CategoriaProduto;
import br.com.aioprojs.controleestoque.model.CategoriaProdutoRepository;

@Service
public class CategoriaProdutoServiceImpl implements CategoriaProdutoService {

	@Autowired
	private CategoriaProdutoRepository categoriaProdutoRepository;
	
	@Override
	@Transactional
	public List<CategoriaProduto> getListaCategorias() {
		return categoriaProdutoRepository.findAll();
	}

	@Override
	@Transactional
	public void salvarCategoria(CategoriaProduto categoria) {
		categoriaProdutoRepository.save(categoria);
	}

	@Override
	@Transactional
	public CategoriaProduto getCategoria(Long id) throws ResourceNotFoundException {
		return categoriaProdutoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
	}

	@Override
	@Transactional
	public void removerCategoria(Long id) throws ResourceNotFoundException {
		categoriaProdutoRepository.deleteById(id);
	}

}
