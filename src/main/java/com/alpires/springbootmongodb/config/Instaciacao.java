package com.alpires.springbootmongodb.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.alpires.springbootmongodb.dominio.Usuario;
import com.alpires.springbootmongodb.repositorio.RepositorioUsuario;

@Configuration                   //o spring passa a entender que esta e uma classe de configuração	
public class Instaciacao implements CommandLineRunner{
	
	@Autowired                   // classe responsavel por manipular base de dados
	RepositorioUsuario repositorioUsuario; 

	@Override
	public void run(String... args) throws Exception {
		
		repositorioUsuario.deleteAll();
		
		Usuario alexsandro = new Usuario(null, "Alexsandro Pires", "allexsandro.pires@gmail.com");
		Usuario maria = new Usuario(null, "Maria Pires", "maria.pires@gmail.com");
		Usuario ana = new Usuario(null, "Ana Maria Brown", "anamaria@gmail.com");
		Usuario alex = new Usuario(null, "Alex Green", "alex@gmail.com");
		Usuario bob = new Usuario(null, "Bob Grey", "bob@gmail.com");	

		//salvar tudo no banco de dados
		repositorioUsuario.saveAll(Arrays.asList(alexsandro, maria, ana, alex, bob));
	}
}
 