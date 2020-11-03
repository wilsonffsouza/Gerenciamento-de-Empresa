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

import br.com.teste.patrimonio.exception.UsuarioNotFoundException;
import br.com.teste.patrimonio.model.Usuario;
import br.com.teste.patrimonio.repository.UsuarioRepository;
import br.com.teste.patrimonio.resource.model.UsuarioResource;

@SpringBootTest
@RunWith(SpringRunner.class)
@WebAppConfiguration
@Sql(scripts = "/sql/insert_usuario_para_teste.sql")
public class UsuarioTeste {
	
	@Autowired
	private UsuarioService service;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Test
	public void cadastrarUsuario() {
		UsuarioResource resource = new UsuarioResource("Teste", "teste@teste.com.br", "1234", "eyJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2MDQ0MzI4OTksInN1YiI6IlRlc3RlIEp3dCBBUEkiLCJleHAiOjE2MDQ0MzQ2OTl9.haMXJ96NnWnsPYz8q970fdytjkBYiQHcjovq835Yn6I");
			service.cadastrar(resource);
	}

	@Test
	public void buscarPorEmailTest() throws UsuarioNotFoundException {
		Usuario usuario = service.buscarPorEmail("teste@teste.com.br");
		assertEquals("teste@teste.com.br", usuario.getEmail());
		assertEquals("teste", usuario.getNome());
		assertEquals("1234", usuario.getSenha());
	}
	
	@Test
	public void deleterPorEmail() throws UsuarioNotFoundException {
		service.deletarPorEmail("teste@teste.com.br");
		
		Optional<Usuario> optionalUsuario = usuarioRepository.findById("teste@teste.com.br");
		
		assertFalse(optionalUsuario.isPresent());
	}
}
