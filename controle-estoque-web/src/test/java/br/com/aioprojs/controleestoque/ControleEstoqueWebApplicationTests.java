package br.com.aioprojs.controleestoque;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.aioprojs.controleestoque.model.CategoriaProduto;
import br.com.aioprojs.controleestoque.service.CategoriaProdutoService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ControleEstoqueWebApplicationTests {
	
	@Autowired
	private TestEntityManager testEntityManager; 
	
	@Autowired
	private CategoriaProdutoService categoriaProdutoService;

	@Test
	public void contextLoads() {
	}
	
	@Test
	public void whenFindById_thenReturnProduto() {
		
		CategoriaProduto cereais = new CategoriaProduto();
		cereais.setNome("Cereais");
		cereais.setDescricao("Grupo de alimentos perecíveis composto por grãos e sementes");
		
		testEntityManager.persist(cereais);
		testEntityManager.flush();
		
		// when
		CategoriaProduto categoriaEncontrada = categoriaProdutoService.buscarPorNome(cereais.getNome());
		
		// then 
		assertThat(categoriaEncontrada.getNome()).isEqualTo(cereais.getNome());
	}

}
