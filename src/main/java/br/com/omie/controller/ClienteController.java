package br.com.omie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.omie.DTO.ClienteDTO;
import br.com.omie.service.ClienteService;

@RestController
@RequestMapping("cliente")
public class ClienteController {

	@Autowired
	ClienteService clienteService;

	@GetMapping("/findAll")
	public List<ClienteDTO> buscarTodosClientes() {
		return clienteService.listarTodos();
	}

	@PostMapping("/create")
	public ClienteDTO criarCliente(@RequestBody ClienteDTO cliente) {
		return clienteService.inserirCliente(cliente);
	}

	@PutMapping("/update/{id}")
	public ClienteDTO atualizarCliente(@PathVariable long id, @RequestBody ClienteDTO cliente) {
		return clienteService.alterarCliente(id, cliente);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> removerFilme(@PathVariable Integer id) {
		return clienteService.deletarCliente(id);
	}
}
