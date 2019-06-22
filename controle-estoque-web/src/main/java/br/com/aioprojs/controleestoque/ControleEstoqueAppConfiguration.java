package br.com.aioprojs.controleestoque;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import br.com.aioprojs.controleestoque.controller.HomeController;
import br.com.aioprojs.controleestoque.controller.ProdutoController;

@Configuration
@EnableWebMvc
@ComponentScan(basePackageClasses={ProdutoController.class, HomeController.class})
public class ControleEstoqueAppConfiguration implements WebMvcConfigurer {
	
    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/**").addResourceLocations("classpath:/static/css/");
        registry.addResourceHandler("/js/**").addResourceLocations("classpath:/static/js/");
    }	
}
