package br.com.aioprojs.controleestoque.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller("/home")
public class HomeController {

	@GetMapping({"/", "/home"})
	public ModelAndView home() {
		ModelAndView model = new  ModelAndView("/homepage");
		model.addObject("mensagem", "Bem-vindo à aplicação de controle de estoque! Esta é a página inicial.");
		
		return model;
	}
	
}
