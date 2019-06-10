package br.com.aioprojs.controleestoque.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.aioprojs.controleestoque.service.ProdutoService;

@Controller
@RequestMapping("/produto")
public class ProdutoController {

	@Autowired
	ProdutoService produtoService;
		
	@GetMapping("/listar")
	public String listarProdutos(Model model) {
		
		return "lista-produtos";
	}
}
