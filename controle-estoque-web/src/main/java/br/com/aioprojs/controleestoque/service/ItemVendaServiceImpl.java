package br.com.aioprojs.controleestoque.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.aioprojs.controleestoque.exception.ResourceNotFoundException;
import br.com.aioprojs.controleestoque.model.ItemVenda;
import br.com.aioprojs.controleestoque.model.ItemVendaRepository;

@Service
public class ItemVendaServiceImpl implements ItemVendaService {

	@Autowired
	private ItemVendaRepository itemVendaRepository;
	
	@Override
	@Transactional
	public List<ItemVenda> getListaItensVenda() {
		return itemVendaRepository.findAll();
	}

	@Override
	@Transactional
	public void salvarItemVenda(ItemVenda item) {
		itemVendaRepository.save(item);
	}

	@Override
	public void salvarListaItemVenda(List<ItemVenda> lista) {
		itemVendaRepository.saveAll(lista);
	}

	@Override
	@Transactional
	public ItemVenda getItemVenda(Long id) throws ResourceNotFoundException {
		return itemVendaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
	}

	@Override
	@Transactional
	public void removerItemVenda(Long id) throws ResourceNotFoundException {
		itemVendaRepository.deleteById(id);
	}

}
