package br.com.teste.patrimonio.model.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.teste.patrimonio.model.entities.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, String>{

}
