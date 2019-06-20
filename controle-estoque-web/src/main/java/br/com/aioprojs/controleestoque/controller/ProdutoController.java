package br.com.aioprojs.controleestoque.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.aioprojs.controleestoque.exception.ResourceNotFoundException;
import br.com.aioprojs.controleestoque.model.CategoriaProduto;
import br.com.aioprojs.controleestoque.model.Estoque;
import br.com.aioprojs.controleestoque.model.Fornecedor;
import br.com.aioprojs.controleestoque.model.Produto;
import br.com.aioprojs.controleestoque.service.CategoriaProdutoService;
import br.com.aioprojs.controleestoque.service.EstoqueService;
import br.com.aioprojs.controleestoque.service.FornecedorService;
import br.com.aioprojs.controleestoque.service.ProdutoService;

@Controller
@RequestMapping("/")
public class ProdutoController {

	public static final Logger LOG = LoggerFactory.getLogger(ProdutoController.class);
	
	@Autowired private ProdutoService produtoService;
	@Autowired private CategoriaProdutoService categoriaProdutoSercice;
	@Autowired private FornecedorService fornecedorService;
	@Autowired private EstoqueService estoqueService;
	
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
	public ModelAndView editarProduto(Produto produto) {
		
		ModelAndView model = new ModelAndView("/produto/incluirProduto");
		model.addObject("produto", produto);
		
		return model;
	}
	
	@PostMapping("/produtos/salvarProduto")
	public ModelAndView salvarProduto(@ModelAttribute("produto") Produto produto) {
		LOG.debug("Persistência do produto na base.");

		Estoque estoque = new Estoque();
		estoque.setQuantidade(0);
		estoque = (Estoque) estoqueService.salvarEstoque(estoque);
		
		produto.setEstoque(estoque);
		
		produtoService.salvarProduto(produto);
		return new ModelAndView("redirect:/produtos/listar");
	}

	@GetMapping("/produtos/alterarProduto/{id}")
	public ModelAndView alterarProduto(@PathVariable("id") ObjectId id) throws ResourceNotFoundException {
		LOG.debug("Buscando produto para alteração.");

		Produto produto = produtoService.getProduto(id);
		return exibirInclusaoProduto(produto);
	}

	@GetMapping("/produtos/deletarProduto/{id}")
	public ModelAndView deletarProduto(@PathVariable("id") ObjectId produtoId) throws ResourceNotFoundException {
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
	public String exibirFormAlterarCategoria(@RequestParam ObjectId categoriaId, Model model) throws ResourceNotFoundException {
		CategoriaProduto categoriaProduto = categoriaProdutoSercice.getCategoria(categoriaId);
		model.addAttribute("categoria", categoriaProduto);
		
		return "formCategoria";
	}
	
	@GetMapping("/categorias/deletarCategoria")
	public String deletarCategoria(@RequestParam ObjectId categoriaId) throws ResourceNotFoundException {
		categoriaProdutoSercice.removerCategoria(categoriaId);
		return "redirect:/produto/categoria/listar";
	}
}
