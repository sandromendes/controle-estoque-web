package br.com.aioprojs.controleestoque.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.aioprojs.controleestoque.exception.ResourceNotFoundException;
import br.com.aioprojs.controleestoque.model.Produto;
import br.com.aioprojs.controleestoque.service.CategoriaProdutoService;
import br.com.aioprojs.controleestoque.service.ProdutoService;

@Controller
@RequestMapping("/produto")
public class ProdutoController {

	public static final Logger LOG = LoggerFactory.getLogger(ProdutoController.class);
	
	@Autowired
	private ProdutoService produtoService;
	
	@Autowired
	private CategoriaProdutoService categoriaProdutoSercice;
		
	@GetMapping("/listar")
	public String listarProdutos(Model model) {
		List<Produto> listaProdutos = produtoService.getListaProdutos();
		model.addAttribute("listaProdutos", listaProdutos);
		
		return "lista-produtos";
	}
	
	@GetMapping("/exibirFormAdicionar")
	public String exibirFormAdicionar(Model model) {
		LOG.debug("Método para criação do formulário de cadastro de Produtos.");
		Produto produto = new Produto();
		model.addAttribute("produto", produto);
		
		return "produtos-form";
	}
	
	@PostMapping("/salvarProduto")
	public String salvarProduto(@ModelAttribute("produto") Produto produto) {
		produtoService.salvarProduto(produto);
		return "redirect:/produto/listar";
	}
	
	@GetMapping("/exibirFormAlterar")
	public String exibirFormAlterar(@RequestParam Long id, Model model) throws ResourceNotFoundException {
		Produto produto = produtoService.getProduto(id);
		model.addAttribute("produto", produto);
		return "produtos-form";
	}
	
	@GetMapping("/deletarProduto")
	public String deletarProduto(@RequestParam Long id) throws ResourceNotFoundException {
		produtoService.removerProduto(id);
		return "redirect:/produto/listar";
	}
}
