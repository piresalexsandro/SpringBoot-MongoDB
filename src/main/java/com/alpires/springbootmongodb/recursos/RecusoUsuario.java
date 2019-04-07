package com.alpires.springbootmongodb.recursos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alpires.springbootmongodb.dominio.Usuario;
import com.alpires.springbootmongodb.servicos.ServicoUsuario;

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
public class RecusoUsuario {   // controlador REST acessa o servico ServicoUsuario
	
	@Autowired
	ServicoUsuario servico;
	
	// END-POINT Rest nest no caminho /usuarios adicionnar uma das notações abaixo
	// ResponseEntity<List<Usuario>> e responsavel por encapsular toda uma estrutura necessaria
	// para retornar respostas HTTP  ja com possiveis erros e ou cabeçalhos
	//@RequestMapping(method=RequestMethod.GET)
	
	@GetMapping
	public ResponseEntity<List<Usuario>> findAll(){
		List<Usuario> usuarios = servico.findAll();
		
		// instancia do ResponseEntity<>
		// estas informacoes iremos ver no POSTMAN
		return ResponseEntity.ok().body(usuarios);
	}

}
