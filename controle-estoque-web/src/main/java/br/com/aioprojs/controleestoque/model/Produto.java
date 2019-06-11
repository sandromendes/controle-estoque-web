package br.com.aioprojs.controleestoque.model;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Document(collection = "produto")
@NoArgsConstructor @AllArgsConstructor 
@ToString
public class Produto {

	@Id
	private Long id;
	@Getter @Setter private String nome;
	@Getter @Setter private BigDecimal preco;
	@DBRef
	@Getter @Setter private CategoriaProduto categoria;
	@DBRef
	@Getter @Setter private Fornecedor fornecedor;
	@DBRef
	@Getter @Setter private Estoque estoque;
}
