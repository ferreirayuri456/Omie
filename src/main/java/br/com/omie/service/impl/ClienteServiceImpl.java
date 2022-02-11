package br.com.omie.service.impl;

import static org.springframework.http.ResponseEntity.notFound;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.omie.DTO.ClienteDTO;
import br.com.omie.model.Cliente;
import br.com.omie.repository.ClienteRepository;
import br.com.omie.service.ClienteService;

@Service
public class ClienteServiceImpl extends ClienteService {

	@Autowired
	ClienteRepository clienteRepo;

	@Autowired
	ModelMapper modelMapper;

	@Override
	public ClienteDTO inserirCliente(ClienteDTO cliente) {
		Cliente mapped = modelMapper.map(cliente, Cliente.class);
		return modelMapper.map(clienteRepo.save(mapped), ClienteDTO.class);
	}

	@Override
	public List<ClienteDTO> listarClientePorId(Integer id) {
		Optional<Cliente> findById = clienteRepo.findById(id);
		return findById.stream().map(ClienteDTO::new).collect(Collectors.toList());
	}

	@Override
	public List<ClienteDTO> listarTodos() {
		List<Cliente> listagem = clienteRepo.findAll();
		return listagem.stream().map(ClienteDTO::new).collect(Collectors.toList());
	}

	@Override
	public ClienteDTO alterarCliente(long id, ClienteDTO cliente) {
		Cliente clientAt = clienteRepo.getById((int) id);
		clientAt.setApelidoString(cliente.getApelido());
		clientAt.setInscricao(cliente.getInscricao());
		clientAt.setNome(cliente.getNome());
		clientAt.setStatus(cliente.getStatus());
		return modelMapper.map(clienteRepo.save(clientAt), ClienteDTO.class);
	}

	@Override
	public ResponseEntity<Object> deletarCliente(Integer id) {
		return clienteRepo.findById(id).map(c -> {
			clienteRepo.deleteById(id);
			return ResponseEntity.ok().build();
		}).orElse(notFound().build());
	}

}
