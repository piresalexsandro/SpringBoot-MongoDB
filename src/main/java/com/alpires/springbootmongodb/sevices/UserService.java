package com.alpires.springbootmongodb.sevices;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alpires.springbootmongodb.DTO.UserDTO;
import com.alpires.springbootmongodb.domain.User;
import com.alpires.springbootmongodb.repository.UserRepository;
import com.alpires.springbootmongodb.service.exeption.ObjectNotFoundException;

@Service
public class UserService {  //SERVICO acessa o REPOSITORIO
	
	@Autowired
	private UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();
	}

	public User findById(String id) {
		Optional<User> users = repo.findById(id);
		return users.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}
	
	public User fromDTO(UserDTO objDTO) {
		return new User(objDTO.getId(), objDTO.getNome(), objDTO.getEmail());
	}
}
