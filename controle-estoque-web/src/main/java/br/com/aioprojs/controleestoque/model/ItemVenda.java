package br.com.aioprojs.controleestoque.model;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor @AllArgsConstructor
@ToString
public class ItemVenda {

	@Id
	private Long id;
	
	@DBRef
	@Getter @Setter 
	private List<Produto> listaProdutos;
	
	@Getter @Setter 
	private int quantidade;
	
	@Getter @Setter 
	private BigDecimal total;
	
	@Getter @Setter 
	private BigDecimal desconto;
	
	@DBRef
	@Getter @Setter 
	private Venda venda;
}
