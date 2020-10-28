package br.com.teste.patrimonio.service;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import br.com.teste.patrimonio.controller.helpers.UsuarioHelpers;
import br.com.teste.patrimonio.exception.UsuarioNotFoundException;
import br.com.teste.patrimonio.model.entities.Usuario;
import br.com.teste.patrimonio.model.repositories.UsuarioRepository;
import br.com.teste.patrimonio.resource.model.UsuarioResource;

@SpringBootTest
@RunWith(SpringRunner.class)
@WebAppConfiguration
@Sql(scripts = "/sql/insert_usuario_para_teste.sql")
public class UsuarioTeste {
	
	@Autowired
	private UsuarioHelpers helpers;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Test
	public void cadastrarUsuario() {
		UsuarioResource resource = new UsuarioResource("Teste", "teste@teste.com.br", "1234");
			helpers.cadastrar(resource);
	}

	@Test
	public void buscarPorEmailTest() throws UsuarioNotFoundException {
		Usuario usuario = helpers.buscarPorEmail("teste@teste.com.br");
		assertEquals("teste@teste.com.br", usuario.getEmail());
		assertEquals("teste", usuario.getNome());
		assertEquals("1234", usuario.getSenha());
	}
	
	@Test
	public void deleterPorEmail() throws UsuarioNotFoundException {
		helpers.deletarPorEmail("teste@teste.com.br");
		
		Optional<Usuario> optionalUsuario = usuarioRepository.findById("teste@teste.com.br");
		
		assertFalse(optionalUsuario.isPresent());
	}
}
