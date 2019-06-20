package br.com.aioprojs.controleestoque.controller;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.aioprojs.controleestoque.exception.ResourceNotFoundException;
import br.com.aioprojs.controleestoque.model.Estoque;
import br.com.aioprojs.controleestoque.service.EstoqueService;

@Controller
public class InventarioController {

	@Autowired
	private EstoqueService estoqueService;

	@RequestMapping(value = "/estoques/listar", method = RequestMethod.GET)
	public ModelAndView listarestoques() {
		List<Estoque> listaestoques = estoqueService.getListaEstoques();
		
		ModelAndView model = new ModelAndView("/estoque/exibirestoques");
		model.addObject("listaestoques", listaestoques);
		
		return model;
	}
	
	@RequestMapping(value = "/estoques/adicionarEstoque")
	public ModelAndView exibirInclusaoEstoque(Estoque estoque) {
		
		ModelAndView model = new ModelAndView("/estoque/incluirEstoque");
		model.addObject("estoque", estoque);
		
		return model;
	}
	
	@RequestMapping(value = "/estoques/alterarEstoque")
	public ModelAndView exibirAlteracaoEstoque(Estoque estoque) {
		
		ModelAndView model = new ModelAndView("/estoque/editarEstoque");
		model.addObject("estoque", estoque);
		
		return model;
	}
	
	@RequestMapping(value = "/estoques/salvarEstoque", method = RequestMethod.POST)
	public ModelAndView salvarEstoque(@ModelAttribute("estoque") Estoque estoque) {
		
		estoqueService.salvarEstoque(estoque);
		return new ModelAndView("redirect:/estoques/listar");
	}
	
	@RequestMapping(value = "/estoques/editarEstoque/{id}", method = RequestMethod.GET)
	public ModelAndView editarEstoque(@PathVariable("id") ObjectId id) throws ResourceNotFoundException {
		
		Estoque estoque = estoqueService.getEstoque(id);
		return exibirAlteracaoEstoque(estoque);
	}
	
	@RequestMapping(value = "/estoques/removerEstoque/{id}", method = RequestMethod.GET)
	public ModelAndView removerEstoque(@PathVariable("id") ObjectId id) throws ResourceNotFoundException {

		estoqueService.removerEstoque(id);
		return new ModelAndView("redirect:/estoques/listar");
	}
	
}
