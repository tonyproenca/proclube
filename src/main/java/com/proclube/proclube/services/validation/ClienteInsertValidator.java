package com.proclube.proclube.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.proclube.proclube.DTO.ClienteNewDTO;
import com.proclube.proclube.domain.Cliente;
import com.proclube.proclube.repositories.ClienteRepository;
import com.proclube.proclube.resources.exceptions.FieldMessages;

public class ClienteInsertValidator implements ConstraintValidator<ClienteInsert, ClienteNewDTO>{

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Override
	public void initialize(ClienteInsert ann) {
	}
		
	@Override
	public boolean isValid(ClienteNewDTO clienteDTO, ConstraintValidatorContext context) {
		List<FieldMessages> list = new ArrayList<>();
			
		/*
		 * Valida se o email já existe na base de dados
		 */
		Cliente cliente = clienteRepository.findByMail(clienteDTO.getEmail());
		if (cliente != null) {
			list.add(new FieldMessages("email", "Email já existente"));
		}
		
		/*
		 * Valida se o dependente possui patrocinador ou responsável cadastrado
		 */
		if (clienteDTO.getTipo() == 0 && clienteDTO.getResponsavelId().equals(null)) {
			list.add(new FieldMessages("responsavelId", "Não foi cadastrado um responsável para este dependente"));
		}
		
		for (FieldMessages e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}

		return list.isEmpty();
	}
	
	
}
