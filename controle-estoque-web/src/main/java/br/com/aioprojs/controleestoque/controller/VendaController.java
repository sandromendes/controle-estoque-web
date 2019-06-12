package br.com.aioprojs.controleestoque.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.aioprojs.controleestoque.exception.ResourceNotFoundException;
import br.com.aioprojs.controleestoque.model.Venda;
import br.com.aioprojs.controleestoque.service.ItemVendaService;
import br.com.aioprojs.controleestoque.service.VendaService;

@Controller
@RequestMapping("/venda")
public class VendaController {

	@Autowired
	private VendaService vendaService;
	
	@Autowired
	private ItemVendaService itemVendaService;
	
	@GetMapping("/listarVendas")
	public String listarVendas(Model model) {
		List<Venda> listaVendas = vendaService.getListaVendas();
		model.addAttribute("listaVendas", listaVendas);
		
		return "lista-vendas";
	}
	
	@GetMapping("/exibirFormularioInclusao")
	public String exibirFormularioInclusao(Model model) {
		Venda venda = new Venda();
		model.addAttribute("venda", venda);
		
		return "vendas-form";
	}
	
	@PostMapping("/salvarVenda")
	public String salvarVenda(@ModelAttribute("venda") Venda venda) {
		vendaService.salvarVenda(venda);
		return "redirect:/venda/listarVenda";
	}
	
	@GetMapping("/exibirFormularioAlteracao")
	public String exibirFormularioAlteracao(@RequestParam Long idVenda, Model model) throws ResourceNotFoundException {
		Venda venda = vendaService.getVenda(idVenda);
		model.addAttribute("venda", venda);
		
		return "vendas-form";
	}
	
	@GetMapping("/deletarVenda")
	public String deletarVenda(@RequestParam Long idVenda) throws ResourceNotFoundException {
		vendaService.removerVenda(idVenda);
		
		return "redirect:/venda/listarVenda";
	}
}
