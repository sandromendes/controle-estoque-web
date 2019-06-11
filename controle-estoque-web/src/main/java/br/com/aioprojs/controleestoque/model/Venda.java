package br.com.aioprojs.controleestoque.model;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Document(collection = "venda")
@NoArgsConstructor @AllArgsConstructor
@ToString
public class Venda {

	@Id
	private Long id;
	
	@Getter @Setter
	private String protocolo;
	
	@Getter @Setter
	private Date data;
	
	@DBRef
	@Getter @Setter
	private Cliente cliente;
	
	@DBRef
	@Getter @Setter
	private List<ItemVenda> listaItensVenda;
	
	@Getter @Setter
	private BigDecimal total;
}
