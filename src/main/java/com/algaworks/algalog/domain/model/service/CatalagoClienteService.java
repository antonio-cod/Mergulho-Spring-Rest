package com.algaworks.algalog.domain.model.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.algaworks.algalog.domain.model.Cliente;
import com.algaworks.algalog.domain.repository.ClienteRepository;
import com.algaworks.algalog.domin.exception.NegocioException;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CatalagoClienteService {
	
	private ClienteRepository clienteRepository;
		
	@Transactional
	public Cliente salvar(Cliente cliente) {
		boolean emailEmUso = clienteRepository.findByEmail(cliente.getEmail())
				.stream()
				.anyMatch(clienteExistente -> clienteExistente.equals(cliente));
		if (emailEmUso) {
			throw new NegocioException("Ja existe um e-mail cadastrado");
		}
		
		return clienteRepository.save(cliente);
		
	}
	
	public void excluir (Long clienteId) {
		clienteRepository.deleteById(clienteId);
	}

}
