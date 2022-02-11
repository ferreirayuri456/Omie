package br.com.omie.DTO;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.omie.config.Status;
import br.com.omie.model.Cliente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {

	@NotNull
	private Integer id;
	
	@NotNull
	@Length(min = 2, max = 60, message = "O tamanho da inscrição deve ser entre {min} e {max} caracteres ")
	private String inscricao;
	@NotNull
	@Length(min = 2, max = 40, message = "O tamanho do nome deve ser entre {min} e {max} caracteres ")
	private String nome;
	@NotNull
	@Length(min = 2, max = 20, message = "O tamanho do apelido deve ser entre {min} e {max} caracteres ")
	private String apelido;
	@NotNull
	@Enumerated(value = EnumType.STRING)
	private Status status;
	
	public ClienteDTO(Cliente cliente) {
		this.id = cliente.getId();
		this.inscricao = cliente.getInscricao();
		this.nome = cliente.getNome();
		this.apelido = cliente.getApelidoString();
		this.status = cliente.getStatus();
	}
	
}
