package com.alpires.springbootmongodb.resource;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.alpires.springbootmongodb.DTO.UserDTO;
import com.alpires.springbootmongodb.domain.User;
import com.alpires.springbootmongodb.sevices.UserService;

/** @RestController Diz que esta classe e um recurso REST
 * @autor Alexsandro Pires
 */
@RestController

/** @RequestMapping(value="")
 *  Diz qual o caminho do END-POINT -> http://localhost:8080/users
 * @author Alexsandro Pires
 *
 */
@RequestMapping(value="/users")
public class UserResource {   // controlador REST acessa o service UserService
	
	@Autowired
	UserService service;
	
	// END-POINT Rest nest no caminho /users adicionnar uma das notações abaixo
	// ResponseEntity<List<User>> e responsavel por encapsular toda uma estrutura necessaria
	// para retornar respostas HTTP  ja com possiveis erros e ou cabeçalhos
	
	//@GetMapping
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<UserDTO>> findAll(){
		List<User> users = service.findAll();
		List<UserDTO> usersDTO = users.stream().map(objUsu -> new UserDTO(objUsu))
				                                                 .collect(Collectors.toList());
		
		// instancia do ResponseEntity<>
		// estas informacoes iremos ver no POSTMAN
		return ResponseEntity.ok().body(usersDTO);
	}

	@RequestMapping(value="/(id)", method=RequestMethod.GET)
	//@PathVariable faz com que o id da url seja o mesmo do argumento
	public ResponseEntity<UserDTO> findById(@PathVariable String id) {    
		User obj = service.findById(id);
		
		return ResponseEntity.ok().body(new UserDTO(obj));
	}
	
	@RequestMapping(method=RequestMethod.POST)
	//@PathVariable faz com que o id da url seja o mesmo do argumento
	public ResponseEntity<Void> insert(@RequestBody UserDTO objDTO) {  
		//tranforma o objeto UserDTO em User
		User obj = service.fromDTO(objDTO);
		obj = service.insert(obj);
		//url do novo recurso
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/id").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
}
