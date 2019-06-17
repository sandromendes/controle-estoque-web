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

@Controller("/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;

	@RequestMapping(value = "/clientes/listar", method = RequestMethod.GET)
	public ModelAndView listarClientes() {
		List<Cliente> listaClientes = clienteService.getListaClientes();
		
		ModelAndView model = new ModelAndView("/exibirClientes");
		model.addObject("listaClientes", listaClientes);
		
		return model;
	}
	
	@RequestMapping(value = "/clientes/adicionarCliente")
	public ModelAndView exibirFormCliente(Cliente cliente) {
		
		ModelAndView model = new ModelAndView("/formCliente");
		model.addObject("cliente", cliente);
		
		return model;
	}
	
	@RequestMapping(value = "/clientes/salvarCliente", method = RequestMethod.POST)
	public ModelAndView salvarCliente(@ModelAttribute("cliente") Cliente cliente) {
		
		clienteService.salvarCliente(cliente);
		return new ModelAndView("redirect:/clientes/listar");
	}
	
	@RequestMapping(value = "/clientes/editarCliente/{id}", method = RequestMethod.GET)
	public ModelAndView editarCliente(@PathVariable("id") ObjectId id) throws ResourceNotFoundException {
		
		Cliente cliente = clienteService.getCliente(id);
		return exibirFormCliente(cliente);
	}
	
	@RequestMapping(value = "/clientes/removerCliente", method = RequestMethod.GET)
	public ModelAndView removerCliente(@PathVariable("id") ObjectId id) throws ResourceNotFoundException {

		clienteService.removerCliente(id);
		return new ModelAndView("redirect:/clientes/listar");
	}
}
