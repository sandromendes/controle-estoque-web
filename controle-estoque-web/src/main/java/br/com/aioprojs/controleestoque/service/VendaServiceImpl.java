package br.com.aioprojs.controleestoque.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.aioprojs.controleestoque.exception.ResourceNotFoundException;
import br.com.aioprojs.controleestoque.model.Venda;
import br.com.aioprojs.controleestoque.model.VendaRepository;

@Service
public class VendaServiceImpl implements VendaService {

	@Autowired
	private VendaRepository vendaRepository;
	
	@Override
	@Transactional
	public List<Venda> getListaVendas() {
		return vendaRepository.findAll();
	}

	@Override
	@Transactional
	public void salvarVenda(Venda venda) {
		vendaRepository.save(venda);
	}

	@Override
	@Transactional
	public Venda getVenda(Long id) throws ResourceNotFoundException {
		return vendaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id)	);
	}

	@Override
	@Transactional
	public void removerVenda(Long id) throws ResourceNotFoundException {
		vendaRepository.deleteById(id);
	}

}
