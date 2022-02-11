package br.com.omie.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import br.com.omie.DTO.ClienteDTO;

public abstract class ClienteService {

	public abstract ClienteDTO inserirCliente(ClienteDTO cliente);
	public abstract List<ClienteDTO> listarClientePorId(Integer id);
	public abstract List<ClienteDTO> listarTodos();
	public abstract ClienteDTO alterarCliente(long id, ClienteDTO cliente);
	public abstract ResponseEntity<Object> deletarCliente(Integer id);
	
}
