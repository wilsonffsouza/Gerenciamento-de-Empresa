package br.com.teste.patrimonio.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.teste.patrimonio.exception.UsuarioNotFoundException;
import br.com.teste.patrimonio.model.Usuario;
import br.com.teste.patrimonio.resource.model.UsuarioResource;
import br.com.teste.patrimonio.service.UsuarioService;

@RestController
@RequestMapping(value = "/api")
public class UsuarioController {

	@Autowired
	private UsuarioService service;

	@PostMapping(path = "/login")
	public Optional<Usuario> login(
			@RequestBody UsuarioResource usuarioResource,
			@RequestHeader String Authorization) throws UsuarioNotFoundException {

		Optional<Usuario> usuario = service.autenticado(usuarioResource, Authorization);

		return usuario;
	}

	@PostMapping(path = "/usuario/save")
	public void novoUsario(@RequestBody UsuarioResource usuario) {
		service.cadastrar(usuario);
	}

	@GetMapping(path = "/usuarios")
	public List<Usuario> buscarTodosUsuarios() {
		return service.buscarTodosUsuarios();
	}

	@GetMapping(path = "/usuario/id/{email}")
	public Usuario buscarUsuariosPorEmail(@PathVariable(name = "email", required = true) String email)
			throws UsuarioNotFoundException {
		return service.buscarPorEmail(email);
	}

	@DeleteMapping(path = "/usuario/delete/{email}")
	public void deleteUsuario(@PathVariable(name = "email", required = true) String email)
			throws UsuarioNotFoundException {
		service.deletarPorEmail(email);
	}
}
