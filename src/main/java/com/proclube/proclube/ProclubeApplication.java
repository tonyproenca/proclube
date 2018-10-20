package com.proclube.proclube;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.proclube.proclube.domain.Cidade;
import com.proclube.proclube.domain.Cliente;
import com.proclube.proclube.domain.Endereco;
import com.proclube.proclube.domain.Estado;
import com.proclube.proclube.domain.enums.TipoAssociadoEnum;
import com.proclube.proclube.repositories.CidadeRepository;
import com.proclube.proclube.repositories.ClienteRepository;
import com.proclube.proclube.repositories.EnderecoRepository;
import com.proclube.proclube.repositories.EstadoRepository;

@SpringBootApplication
public class ProclubeApplication implements CommandLineRunner{

	@Autowired
	ClienteRepository clienteRepository;
	@Autowired
	EstadoRepository estadoRepository;
	@Autowired
	CidadeRepository cidadeRepository;
	@Autowired
	EnderecoRepository enderecoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ProclubeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Estado est1 = new Estado(null, "Pernambuco");
		Estado est2 = new Estado(null, "São Paulo");
		Cidade cid1 = new Cidade(null, "Jaboatão dos Guararapes", est1);
		Cidade cid2 = new Cidade(null, "São Paulo", est2);

		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(cid1, cid2));
		
		Cliente cli1 = new Cliente(null, "John", "Snow", "111.542.210-32", "45.194.306", "johnsnow@gmail.com", 
				TipoAssociadoEnum.RESPONSAVEL, "Brau", "0000", "00000-00");
		Endereco end1 = new Endereco(null, "Rua Rio Pardo", "230", "---", "Barra de Jangada", "00000-000", cli1, cid1);
		cli1.setEndereco(end1);
		cli1.getTelefones().addAll(Arrays.asList("818888888", "1188888880"));
		
		Cliente cli2 = new Cliente(null, "Antonio", "Proença", "770.719.320-26", "45.194.307", "antproenca@gmail.com", 
				TipoAssociadoEnum.RESPONSAVEL, "Brau", "0000", "00000-00");
		Endereco end2 = new Endereco(null, "Rua Rio Pardo", "000", "---", "Barra de Jangada", "00000-000", cli2, cid2);
		cli2.setEndereco(end2);
		cli2.getTelefones().addAll(Arrays.asList("818888888", "1188888880"));
		
		clienteRepository.saveAll(Arrays.asList(cli1, cli2));	
		enderecoRepository.saveAll(Arrays.asList(end1, end2));
	
	}
	
	
}
