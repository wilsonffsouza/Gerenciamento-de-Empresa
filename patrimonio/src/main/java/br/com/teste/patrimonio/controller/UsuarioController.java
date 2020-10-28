package br.com.teste.patrimonio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.teste.patrimonio.controller.helpers.UsuarioHelpers;
import br.com.teste.patrimonio.exception.UsuarioNotFoundException;
import br.com.teste.patrimonio.model.entities.Usuario;
import br.com.teste.patrimonio.resource.model.UsuarioResource;

@RestController
@RequestMapping(value = "/api")
public class UsuarioController {
	
	@Autowired
	private UsuarioHelpers helpers;

	@PostMapping(path = "/usuario/save")
	public void novoUsario(@RequestBody UsuarioResource usuario) {
		helpers.cadastrar(usuario);
	}
	
	@GetMapping(path = "/usuarios")
	public List<Usuario> buscarTodosUsuarios(){
		return helpers.buscarTodosUsuarios();
	}
	
	@GetMapping(path = "/usuario/id/{email}")
	public Usuario buscarUsuariosPorEmail(
			@PathVariable(name = "email", required = true) String email) throws UsuarioNotFoundException{
		return helpers.buscarPorEmail(email);
	}
	
	@DeleteMapping(path = "/usuario/delete/{email}")
	public void deleteUsuario (
			@PathVariable(name = "email", required = true) String email) throws UsuarioNotFoundException {
		helpers.deletarPorEmail(email);
	}
}
