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
import br.com.aioprojs.controleestoque.model.Cliente;
import br.com.aioprojs.controleestoque.service.ClienteService;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	ClienteService clienteService;

	@RequestMapping(name = "/clientes/listarClientes", method = RequestMethod.GET)
	public ModelAndView listarClientes() {
		List<Cliente> listaClientes = clienteService.getListaClientes();
		
		ModelAndView model = new ModelAndView("/exibirClientes");
		model.addObject("listaClientes", listaClientes);
		
		return model;
	}
	
	@RequestMapping(name = "/clientes/adicionarCliente")
	public ModelAndView exibirFormCliente(Cliente cliente) {
		
		ModelAndView model = new ModelAndView("/formCliente");
		model.addObject("cliente", cliente);
		
		return model;
	}
	
	@RequestMapping(name = "/clientes/salvarCliente", method = RequestMethod.POST)
	public ModelAndView salvarCliente(@ModelAttribute("cliente") Cliente cliente) {
		clienteService.salvarCliente(cliente);
		
		return new ModelAndView("redirect:/clientes/listarClientes");
	}
	
	@RequestMapping(name = "/clientes/alterarCliente/{databaseId}", method = RequestMethod.GET)
	public ModelAndView alterarCliente(@PathVariable("databaseId") ObjectId databaseId) 
			throws ResourceNotFoundException {
		
		Cliente cliente = clienteService.getCliente(databaseId);
		return exibirFormCliente(cliente);
	}
	
	@RequestMapping(name = "/clientes/deletarProduto", method = RequestMethod.GET)
	public ModelAndView deletarCliente() {
		
		return new ModelAndView("redirect:/clientes/listarClientes");
	}
}
