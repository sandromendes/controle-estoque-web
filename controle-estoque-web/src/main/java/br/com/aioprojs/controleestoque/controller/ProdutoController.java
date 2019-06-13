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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.aioprojs.controleestoque.exception.ResourceNotFoundException;
import br.com.aioprojs.controleestoque.model.CategoriaProduto;
import br.com.aioprojs.controleestoque.model.Produto;
import br.com.aioprojs.controleestoque.service.CategoriaProdutoService;
import br.com.aioprojs.controleestoque.service.ProdutoService;

@Controller
public class ProdutoController {

	public static final Logger LOG = LoggerFactory.getLogger(ProdutoController.class);
	
	@Autowired
	private ProdutoService produtoService;
	
	@Autowired
	private CategoriaProdutoService categoriaProdutoSercice;
		
	// Controle de produtos
	
	@GetMapping("/produtos/listar")
	public ModelAndView listarProdutos() {
		LOG.debug("Exibição da listagem de produtos.");

		ModelAndView model = new ModelAndView("/produtos/listaProdutos");
		
		List<Produto> listaProdutos = produtoService.getListaProdutos();
		model.addObject("listaProdutos", listaProdutos);
		
		return model;
	}
	
	@GetMapping("/produtos/adicionarProduto")
	public ModelAndView exibirFormProduto(Produto produto) {
		LOG.debug("Formulário de cadastro de Produtos.");
		
		ModelAndView model = new ModelAndView("/produtos/formProduto");
		model.addObject("produto", produto);
		
		return model;
	}
	
	@PostMapping("/produtos/salvarProduto")
	public ModelAndView salvarProduto(@ModelAttribute("produto") Produto produto) {
		LOG.debug("Persistência do produto na base.");

		produtoService.salvarProduto(produto);
		
		return new ModelAndView("redirect:/produtos/listar");
	}

	@GetMapping("/produtos/alterarProduto/{produtoId}")
	public ModelAndView alterarProduto(@RequestParam Long produtoId) throws ResourceNotFoundException {
		LOG.debug("Buscando produto para alteração.");

		Produto produto = produtoService.getProduto(produtoId);
		
		return exibirFormProduto(produto);
	}

	@GetMapping("/produtos/deletarProduto/{produtoId}")
	public ModelAndView deletarProduto(@RequestParam Long produtoId) throws ResourceNotFoundException {
		LOG.debug("Remoção de produto.");

		produtoService.removerProduto(produtoId);
		
		return new ModelAndView("redirect:/produtos/listar");
	}

	// Controle de categorias de produtos
	
	@GetMapping("/categorias/listaCategorias")
	public String listarCategorias(Model model) {
		List<CategoriaProduto> listaCategorias = categoriaProdutoSercice.getListaCategorias();
		model.addAttribute("listaCategorias", listaCategorias);
		
		return "listaCategorias";
	}
	
	@GetMapping("/categorias/exibirFormAdicionar")
	public String exibirFormAdicionarCategoria(Model model) {
		LOG.debug("Método para criação do formulário de cadastro de Categorias de Produtos.");
		CategoriaProduto categoriaProduto = new CategoriaProduto();
		model.addAttribute("categoriaProduto", categoriaProduto);
		
		return "formCategoria";
	}
	
	@PostMapping("/categorias/salvarCategoria")
	public String salvarCategoria(@ModelAttribute("categoria") CategoriaProduto categoriaProduto) {
		categoriaProdutoSercice.salvarCategoria(categoriaProduto);
		return "redirect:/produto/categoria/listar";
	}
	
	@GetMapping("/categoria/exibirFormAlterar")
	public String exibirFormAlterarCategoria(@RequestParam Long categoriaId, Model model) throws ResourceNotFoundException {
		CategoriaProduto categoriaProduto = categoriaProdutoSercice.getCategoria(categoriaId);
		model.addAttribute("categoria", categoriaProduto);
		
		return "formCategoria";
	}
	
	@GetMapping("/categorias/deletarCategoria")
	public String deletarCategoria(@RequestParam Long categoriaId) throws ResourceNotFoundException {
		categoriaProdutoSercice.removerCategoria(categoriaId);
		return "redirect:/produto/categoria/listar";
	}
}
