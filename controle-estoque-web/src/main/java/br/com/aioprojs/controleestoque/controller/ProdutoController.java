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
import br.com.aioprojs.controleestoque.model.CategoriaProduto;
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
	
	@GetMapping("/categoria/listar")
	public String listarCategorias(Model model) {
		List<CategoriaProduto> listaCategorias = categoriaProdutoSercice.getListaCategorias();
		model.addAttribute("listaCategorias", listaCategorias);
		
		return "lista-categorias";
	}
	
	@GetMapping("/exibirFormAdicionar")
	public String exibirFormAdicionar(Model model) {
		LOG.debug("Método para criação do formulário de cadastro de Produtos.");
		Produto produto = new Produto();
		model.addAttribute("produto", produto);
		
		return "produtos-form";
	}
	
	@GetMapping("/categoria/exibirFormAdicionar")
	public String exibirFormAdicionarCategoria(Model model) {
		LOG.debug("Método para criação do formulário de cadastro de Categorias de Produtos.");
		CategoriaProduto categoriaProduto = new CategoriaProduto();
		model.addAttribute("categoriaProduto", categoriaProduto);
		
		return "categorias-form";
	}
	
	@PostMapping("/salvarProduto")
	public String salvarProduto(@ModelAttribute("produto") Produto produto) {
		produtoService.salvarProduto(produto);
		return "redirect:/produto/listar";
	}
	
	@PostMapping("/categoria/salvarCategoria")
	public String salvarCategoria(@ModelAttribute("categoria") CategoriaProduto categoriaProduto) {
		categoriaProdutoSercice.salvarCategoria(categoriaProduto);
		return "redirect:/produto/categoria/listar";
	}
	
	@GetMapping("/exibirFormAlterar")
	public String exibirFormAlterar(@RequestParam Long produtoId, Model model) throws ResourceNotFoundException {
		Produto produto = produtoService.getProduto(produtoId);
		model.addAttribute("produto", produto);
		return "produtos-form";
	}
	
	@GetMapping("/categoria/exibirFormAlterar")
	public String exibirFormAlterarCategoria(@RequestParam Long categoriaId, Model model) throws ResourceNotFoundException {
		CategoriaProduto categoriaProduto = categoriaProdutoSercice.getCategoria(categoriaId);
		model.addAttribute("categoria", categoriaProduto);
		
		return "categorias-form";
	}
	
	@GetMapping("/deletarProduto")
	public String deletarProduto(@RequestParam Long produtoId) throws ResourceNotFoundException {
		produtoService.removerProduto(produtoId);
		return "redirect:/produto/listar";
	}
	
	public String deletarCategoria(@RequestParam Long categoriaId) throws ResourceNotFoundException {
		categoriaProdutoSercice.removerCategoria(categoriaId);
		return "redirect:/produto/categoria/listar";
	}
}
