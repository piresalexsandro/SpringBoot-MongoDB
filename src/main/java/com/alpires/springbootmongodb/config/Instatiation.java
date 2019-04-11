package com.alpires.springbootmongodb.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.alpires.springbootmongodb.domain.User;
import com.alpires.springbootmongodb.repository.UserRepository;

@Configuration                   //o spring passa a entender que esta e uma classe de configuração	
public class Instatiation implements CommandLineRunner{
	
	@Autowired                   // classe responsavel por manipular base de dados
	UserRepository repositorioUuser; 

	@Override
	public void run(String... args) throws Exception {
		
		repositorioUuser.deleteAll();
		
		User alexsandro = new User(null, "Alexsandro Pires", "allexsandro.pires@gmail.com");
		User maria = new User(null, "Maria Pires", "maria.pires@gmail.com");
		User ana = new User(null, "Ana Maria Brown", "anamaria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");	

		//salvar tudo no banco de dados
		repositorioUuser.saveAll(Arrays.asList(alexsandro, maria, ana, alex, bob));
	}
}
 