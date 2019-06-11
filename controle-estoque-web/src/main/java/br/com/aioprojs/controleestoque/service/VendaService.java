package br.com.aioprojs.controleestoque.service;

import java.util.List;

import br.com.aioprojs.controleestoque.exception.ResourceNotFoundException;
import br.com.aioprojs.controleestoque.model.Venda;

public interface VendaService {

	public List<Venda> getListaVendas();
	
	public void salvarVenda(Venda venda);
	
	public Venda getVenda(Long id) throws ResourceNotFoundException;
	
	public void removerVenda(Long id) throws ResourceNotFoundException;
}
