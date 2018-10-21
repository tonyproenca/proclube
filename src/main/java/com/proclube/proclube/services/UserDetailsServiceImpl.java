package com.proclube.proclube.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.proclube.proclube.domain.Funcionario;
import com.proclube.proclube.repositories.FuncionarioRepository;
import com.proclube.proclube.security.UserSS;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		Funcionario funcionario = funcionarioRepository.findByLogin(login);
		if (funcionario == null) {
			throw new UsernameNotFoundException(login);
		}
		return new UserSS(funcionario.getId(), funcionario.getLogin(), funcionario.getSenha());
	}

}
