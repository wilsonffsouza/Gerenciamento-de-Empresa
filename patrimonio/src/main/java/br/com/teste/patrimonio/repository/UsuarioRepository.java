package br.com.teste.patrimonio.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.teste.patrimonio.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, String>{

}
