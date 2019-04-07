package com.alpires.springbootmongodb.recursos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alpires.springbootmongodb.dominio.Usuario;

/** @RestController Diz que esta classe e um recurso REST
 * @autor Alexsandro Pires
 */
@RestController

/** @RequestMapping(value="")
 *  Diz qual o caminho do END-POINT -> http://localhost:8080/usuarios
 * @author Alexsandro Pires
 *
 */
@RequestMapping(value="/usuarios")
public class RecusoUsuario {
	
	// END-POINT Rest nest no caminho /usuarios adicionnar uma das notações abaixo
	// ResponseEntity<List<Usuario>> e responsavel por encapsular toda uma estrutura necessaria
	// para retornar respostas HTTP  ja com possiveis erros e ou cabeçalhos
	//@RequestMapping(method=RequestMethod.GET)
	@GetMapping
	public ResponseEntity<List<Usuario>> findAll(){
		Usuario alex = new Usuario("1809", "Alexsandro Pires", "allexsandro.pires@gmail.com");
		Usuario maria = new Usuario("1708", "Maria Pires", "maria.pires@gmail.com");
		List<Usuario> usuarios = new ArrayList<>();
		
		//adicionar os objetos na lista
		usuarios.addAll(Arrays.asList(alex, maria));
		
		// instancia do ResponseEntity<>
		// estas informacoes iremos ver no POSTMAN
		return ResponseEntity.ok().body(usuarios);
	}

}
