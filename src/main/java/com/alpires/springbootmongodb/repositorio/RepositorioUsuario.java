package com.alpires.springbootmongodb.repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.alpires.springbootmongodb.dominio.Usuario;

@Repository
public interface RepositorioUsuario extends MongoRepository<Usuario, String>{

}
