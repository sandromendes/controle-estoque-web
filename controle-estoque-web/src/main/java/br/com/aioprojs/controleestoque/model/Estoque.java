package br.com.aioprojs.controleestoque.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Document
@NoArgsConstructor @AllArgsConstructor
@ToString
public class Estoque {

	@Id
	private Long id;
	@Getter @Setter private Integer quantidade;
	@Getter @Setter private Integer minimo;
	@Getter @Setter private Integer maximo;
	@DBRef
	@Getter @Setter private Produto produto;
}
