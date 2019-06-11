package br.com.aioprojs.controleestoque.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Document
@NoArgsConstructor @AllArgsConstructor
@ToString @EqualsAndHashCode
public class Cliente {

	@Id
	private Long id;
	
	@Getter @Setter 
	private String nome;
	
	@Getter @Setter 
	private String telefone;
	
	@DBRef
	@Getter @Setter 
	private List<Venda> listaVendas;
}
