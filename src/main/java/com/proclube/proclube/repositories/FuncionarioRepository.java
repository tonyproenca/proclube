package com.proclube.proclube.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.proclube.proclube.domain.Cliente;
import com.proclube.proclube.domain.Funcionario;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{
	
	@Transactional(readOnly=true)
	Cliente findByMail (String email);

}
