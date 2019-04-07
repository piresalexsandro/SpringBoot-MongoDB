package com.alpires.springbootmongodb.servicos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alpires.springbootmongodb.dominio.Usuario;
import com.alpires.springbootmongodb.repositorio.RepositorioUsuario;

@Service
public class ServicoUsuario {  //SERVICO acessa o REPOSITORIO
	
	@Autowired
	private RepositorioUsuario repo;
	
	public List<Usuario> findAll(){
		return repo.findAll();
	}

}
