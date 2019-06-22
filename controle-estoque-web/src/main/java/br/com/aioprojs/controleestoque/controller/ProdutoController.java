package br.com.aioprojs.controleestoque.controller;

import java.util.List;
import java.util.UUID;

import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.aioprojs.controleestoque.exception.ResourceNotFoundException;
import br.com.aioprojs.controleestoque.model.CategoriaProduto;
import br.com.aioprojs.controleestoque.model.Estoque;
import br.com.aioprojs.controleestoque.model.Fornecedor;
import br.com.aioprojs.controleestoque.model.Produto;
import br.com.aioprojs.controleestoque.service.CategoriaProdutoService;
import br.com.aioprojs.controleestoque.service.FornecedorService;
import br.com.aioprojs.controleestoque.service.ProdutoService;

@Controller
@RequestMapping("/")
public class ProdutoController {

	public static final Logger LOG = LoggerFactory.getLogger(ProdutoController.class);
	
	@Autowired private ProdutoService produtoService;
	@Autowired private CategoriaProdutoService categoriaProdutoSercice;
	@Autowired private FornecedorService fornecedorService;
	
	// Controle de produtos

	@GetMapping("/produtos/listar")
	public ModelAndView listarProdutos() {
		LOG.debug("Exibição da listagem de produtos.");

		ModelAndView model = new ModelAndView("/produto/exibirProdutos");
		List<Produto> listaProdutos = produtoService.getListaProdutos();
		model.addObject("listaProdutos", listaProdutos);

		return model;
	}
	
	@GetMapping("/produtos/adicionarProduto")
	public ModelAndView exibirInclusaoProduto(Produto produto) {
		LOG.debug("Formulário de cadastro de Produtos.");
		
		ModelAndView model = new ModelAndView("/produto/incluirProduto");
		model.addObject("produto", produto);
		
		List<CategoriaProduto> listaCategorias = categoriaProdutoSercice.getListaCategorias();
		model.addObject("listaCategorias", listaCategorias);
		
		List<Fornecedor> listaFornecedores = fornecedorService.getListaFornecedores();
		model.addObject("listaFornecedores", listaFornecedores);
		
		return model;
	}

	@GetMapping("/produtos/editarProduto")
	public ModelAndView exibirAlteracaoProduto(Produto produto) {
		
		ModelAndView model = new ModelAndView("/produto/alterarProduto");
		model.addObject("produto", produto);
		
		List<CategoriaProduto> listaCategorias = categoriaProdutoSercice.getListaCategorias();
		model.addObject("listaCategorias", listaCategorias);
		
		List<Fornecedor> listaFornecedores = fornecedorService.getListaFornecedores();
		model.addObject("listaFornecedores", listaFornecedores);

		return model;
	}
	
	@PostMapping("/produtos/salvarProduto")
	public ModelAndView salvarProduto(@ModelAttribute("produto") Produto produto) {
		LOG.debug("Persistência do produto na base.");

		if(produto.getEstoque() == null) {
			Estoque estoque = new Estoque();
			estoque.setLote(UUID.randomUUID().toString());
			estoque.setQuantidade(0);

			produto.setEstoque(estoque);
		}
		
		produtoService.salvarProduto(produto);
		return new ModelAndView("redirect:/produtos/listar");
	}

	@GetMapping("/produtos/alterarProduto/{id}")
	public ModelAndView alterarProduto(@PathVariable("id") ObjectId id) throws ResourceNotFoundException {
		LOG.debug("Buscando produto para alteração.");

		Produto produto = produtoService.getProduto(id);
		return exibirAlteracaoProduto(produto);
	}

	@GetMapping("/produtos/deletarProduto/{id}")
	public ModelAndView deletarProduto(@PathVariable("id") ObjectId id) throws ResourceNotFoundException {
		LOG.debug("Remoção de produto.");

		produtoService.removerProduto(id);
		return new ModelAndView("redirect:/produtos/listar");
	}

	// Controle de categorias de produtos
	
	@GetMapping("/categorias/listar")
	public String listarCategorias(Model model) {
		List<CategoriaProduto> listaCategorias = categoriaProdutoSercice.getListaCategorias();
		model.addAttribute("listaCategorias", listaCategorias);
		
		return "/categoria/exibirCategorias";
	}
	
	@GetMapping("/categorias/adicionarCategoria")
	public String exibirFormAdicionarCategoria(Model model) {
		LOG.debug("Método para criação do formulário de cadastro de Categorias de Produtos.");
		CategoriaProduto categoriaProduto = new CategoriaProduto();
		model.addAttribute("categoria", categoriaProduto);
		
		return "/categoria/incluirCategoria";
	}
	
	@PostMapping("/categorias/salvarCategoria")
	public String salvarCategoria(@ModelAttribute("categoria") CategoriaProduto categoriaProduto) {
		categoriaProdutoSercice.salvarCategoria(categoriaProduto);
		return "redirect:/categorias/listar";
	}
	
	@GetMapping("/categorias/alterarCategoria/{id}")
	public String exibirFormAlterarCategoria(@ModelAttribute("id") ObjectId id, Model model) throws ResourceNotFoundException {
		CategoriaProduto categoriaProduto = categoriaProdutoSercice.getCategoria(id);
		model.addAttribute("categoria", categoriaProduto);
		
		return "/categoria/editarCategoria";
	}
	
	@GetMapping("/categorias/removerCategoria/{id}")
	public String deletarCategoria(@ModelAttribute("id") ObjectId id) throws ResourceNotFoundException {
		categoriaProdutoSercice.removerCategoria(id);
		return "redirect:/categorias/listar";
	}
}
