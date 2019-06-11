package br.com.aioprojs.controleestoque.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.aioprojs.controleestoque.exception.ResourceNotFoundException;
import br.com.aioprojs.controleestoque.model.Produto;
import br.com.aioprojs.controleestoque.model.ProdutoRepository;

@Service
public class ProdutoServiceImpl implements ProdutoService{

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Override
	@Transactional
	public List<Produto> getListaProdutos(){
		return produtoRepository.findAll();
	}

	@Override
	@Transactional
	public void salvarProduto(Produto produto) {
		produtoRepository.save(produto);
	}

	@Override
	@Transactional
	public Produto getProduto(Long id) throws ResourceNotFoundException {
		return produtoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
	}

	@Override
	@Transactional
	public void removerProduto(Long id) throws ResourceNotFoundException {
		produtoRepository.deleteById(id);
	}
}
