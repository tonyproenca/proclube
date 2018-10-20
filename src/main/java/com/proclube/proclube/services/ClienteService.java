package com.proclube.proclube.services;

import java.beans.Transient;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.proclube.proclube.DTO.ClienteDTO;
import com.proclube.proclube.DTO.ClienteNewDTO;
import com.proclube.proclube.domain.Cidade;
import com.proclube.proclube.domain.Cliente;
import com.proclube.proclube.domain.Endereco;
import com.proclube.proclube.domain.enums.TipoAssociadoEnum;
import com.proclube.proclube.repositories.ClienteRepository;
import com.proclube.proclube.repositories.EnderecoRepository;
import com.proclube.proclube.services.exceptions.ObjectNotFoundException;


@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public Cliente find(Long id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		return cliente.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
	}

	public List<Cliente> findAll() {
		return clienteRepository.findAll();
	}
	
	@Transient
	public Cliente insert(Cliente cliente) {
		cliente.setId(null);
		clienteRepository.save(cliente);
		System.out.println("Endereço salvo..");
		enderecoRepository.save(cliente.getEndereco());
		return cliente;
	}


	public Cliente update(Cliente cliente) {
		Cliente newCliente = find(cliente.getId());
		updateData(newCliente, cliente);
		return clienteRepository.save(newCliente);
	}
	
	public void delete(Long id) {
		find(id);
		try {
			clienteRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Não foi possivel excluir pois existem entidades relacionadas");
		}
	}


	public Cliente fromDto(ClienteNewDTO clienteDTO) {
		Cliente cliente = new Cliente(null, clienteDTO.getFirstName(), clienteDTO.getLastName(), clienteDTO.getCpf(), clienteDTO.getRg(), clienteDTO.getEmail(), TipoAssociadoEnum.toEnum(clienteDTO.getTipo()), clienteDTO.getBanco(), clienteDTO.getAgencia(), clienteDTO.getConta());
		Cidade cidade = new Cidade(clienteDTO.getCidadeId(), null, null);
		Endereco endereco = new Endereco(null, clienteDTO.getLogradouro(), clienteDTO.getNumero(), clienteDTO.getComplemento(), clienteDTO.getBairro(), clienteDTO.getCep(), cliente, cidade);
		cliente.setEndereco(endereco);
		cliente.getTelefones().add(clienteDTO.getTelefone1());
		if (clienteDTO.getTelefone2() != null) {
			cliente.getTelefones().add(clienteDTO.getTelefone2());
		}
		
		if (clienteDTO.getTelefone3() != null) {
			cliente.getTelefones().add(clienteDTO.getTelefone3());
		} 
		
		if (clienteDTO.getResponsavelId() == null && cliente.getTipoAssociadoEnum().equals(TipoAssociadoEnum.DEPENDENTE)) {
			cliente.setResponsavel(clienteDTO.getResponsavelId());
		}
		
		return cliente;
	}
	
	public Cliente fromDto(@Valid ClienteDTO clienteDTO) {
		return new Cliente(clienteDTO.getId(), clienteDTO.getFirstName(), clienteDTO.getLastName(), null, null, clienteDTO.getMail(), TipoAssociadoEnum.toEnum(clienteDTO.getTipo()), null, null, null);
	}

	private void updateData(Cliente newCliente, Cliente cliente) {
		newCliente.setFirstName(cliente.getFirstName());
		newCliente.setLastName(cliente.getLastName());
		newCliente.setMail(cliente.getMail());
		newCliente.setAgencia(cliente.getAgencia());
		newCliente.setBanco(cliente.getBanco());
		newCliente.setConta(cliente.getConta());
		newCliente.setTelefones(cliente.getTelefones());
		newCliente.setTipoAssociadoEnum(cliente.getTipoAssociadoEnum());
		newCliente.setEndereco(cliente.getEndereco());
	}


}
