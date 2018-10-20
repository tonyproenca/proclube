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
	
	//TODO IMPLEMENTAR MAIS VALIDAÇÕES
	
	@Override
	public boolean isValid(ClienteNewDTO clienteDTO, ConstraintValidatorContext context) {
		List<FieldMessages> list = new ArrayList<>();
				
		Cliente cliente = clienteRepository.findByMail(clienteDTO.getEmail());
		if (cliente != null) {
			list.add(new FieldMessages("email", "Email já existente"));
		}
		
		for (FieldMessages e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}

		return list.isEmpty();
	}
	
	
}
