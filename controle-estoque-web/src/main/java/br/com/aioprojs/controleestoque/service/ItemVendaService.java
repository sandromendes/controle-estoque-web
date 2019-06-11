package br.com.aioprojs.controleestoque.service;

import java.util.List;

import br.com.aioprojs.controleestoque.exception.ResourceNotFoundException;
import br.com.aioprojs.controleestoque.model.ItemVenda;

public interface ItemVendaService {

	public List<ItemVenda> getListaItensVenda();
	
	public void salvarItemVenda(ItemVenda item);
	
	public void salvarListaItemVenda(List<ItemVenda> lista);
	
	public ItemVenda getItemVenda(Long id) throws ResourceNotFoundException;
	
	public void removerItemVenda(Long id) throws ResourceNotFoundException;
}
