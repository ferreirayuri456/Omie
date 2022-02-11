package br.com.omie.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import br.com.omie.config.Status;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Integer id;
	
	@NotNull
	private String inscricao;
	
	@NotNull
	private String nome;
	
	@NotNull
	private String apelidoString;
	
	@NotNull
	private Status status;
	
	
	
}
