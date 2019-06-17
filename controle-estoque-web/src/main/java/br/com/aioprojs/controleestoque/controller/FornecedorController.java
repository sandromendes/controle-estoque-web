package br.com.aioprojs.controleestoque.controller;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.aioprojs.controleestoque.exception.ResourceNotFoundException;
import br.com.aioprojs.controleestoque.model.Fornecedor;
import br.com.aioprojs.controleestoque.service.FornecedorService;

@Controller("/fornecedor")
public class FornecedorController {
	
	@Autowired
	FornecedorService fornecedorService;

	@GetMapping("/fornecedores/listar")
	public String listarFornecedores(Model model) {
		
		List<Fornecedor> fornecedores = fornecedorService.getListaFornecedores();
		model.addAttribute("fornecedores", fornecedores);
		
		return "listaFornecedores";
	}
	
	@GetMapping("/fornecedores/adicionarFornecedor")
	public String adicionarFornecedor(Model model) {
		
		Fornecedor fornecedor = new Fornecedor();
		model.addAttribute("fornecedor", fornecedor);
		
		return "formFornecedor";
	}
	
	@PostMapping("/fornecedores/salvarFornecedor")
	public String salvarFornecedor(@ModelAttribute("fornecedor") Fornecedor fornecedor) {
		
		fornecedorService.salvarFornecedor(fornecedor);
		return "redirect:/fornecedores/listar";
	}
	
	@GetMapping("/fornecedores/editarFornecedor/{id}")
	public String editarFornecedor(@ModelAttribute("id") ObjectId id, Model model) throws ResourceNotFoundException {
		
		Fornecedor fornecedor = fornecedorService.getFornecedor(id);
		model.addAttribute("fornecedor", fornecedor);
		
		return "formFornecedor";
	}
	
	//Get Remover
	public String removerFornecedor(@ModelAttribute("id") ObjectId id) throws ResourceNotFoundException {
		
		fornecedorService.removerFornecedor(id);
		return "redirect:/fornecedores/listar";
	}
	
}
