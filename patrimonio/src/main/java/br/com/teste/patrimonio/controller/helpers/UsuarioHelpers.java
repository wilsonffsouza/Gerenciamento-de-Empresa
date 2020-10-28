package br.com.teste.patrimonio.controller.helpers;

import java.util.List;
import java.util.Optional;

import javax.mail.internet.InternetAddress;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.teste.patrimonio.exception.UsuarioNotFoundException;
import br.com.teste.patrimonio.exception.UsuarioResourceException;
import br.com.teste.patrimonio.model.entities.Usuario;
import br.com.teste.patrimonio.model.repositories.UsuarioRepository;
import br.com.teste.patrimonio.resource.model.UsuarioResource;

@Component
public class UsuarioHelpers {

	private static final Logger LOG = Logger.getLogger(UsuarioHelpers.class);

	@Autowired
	private UsuarioRepository usuarioRepository;

	public void cadastrar(UsuarioResource usuarioResource) {

		try {
			Usuario usuario = conversor(usuarioResource);
			usuarioRepository.save(usuario);
		} catch (UsuarioResourceException e) {
			LOG.error("Erro oa salvar Usuário: " + e.getMessage(), e);
		}

	}

	public Usuario conversor(UsuarioResource usuario) throws UsuarioResourceException {

		try {
			Usuario usuario2 = new Usuario();
			InternetAddress email = isValidEmailAddress(usuario.getEmail());
			usuario2.setNome(usuario.getNome());
			usuario2.setEmail(email.toString());
			usuario2.setSenha(usuario.getSenha());
			return usuario2;
		} catch (Exception e) {
			throw new UsuarioResourceException("Falha ao converter o resource para entidade, resource: " + usuario);
		}

	}

	public InternetAddress isValidEmailAddress(String email) {
		InternetAddress emailAddr = null;
		try {
			emailAddr = new InternetAddress(email);
			emailAddr.validate();
		} catch (javax.mail.internet.AddressException e) {
			System.out.println("Digite um email Valido");
			;
		}
		return emailAddr;
	}
	
	
	public List<Usuario> buscarTodosUsuarios(){
		return (List<Usuario>) usuarioRepository.findAll();
	}
	
	public Usuario buscarPorEmail(String email) throws UsuarioNotFoundException {
		Optional<Usuario> optionalUsuario = usuarioRepository.findById(email);
		Usuario usuario = null;
		if(!optionalUsuario.isPresent()) {
			throw new UsuarioNotFoundException("Usuario não encontrado através do email: "+email);
		} else {
			usuario = optionalUsuario.get();
		}
		return usuario;
	}
	
	/*
	private Optional<Usuario> getOptional(String email) {
		Optional<Usuario> optionalUsuario = usuarioRepository.findById(email);
		return optionalUsuario;
	}
	*/
	
	public void deletarPorEmail(String email) throws UsuarioNotFoundException {
		Optional<Usuario> optionalUsuario = usuarioRepository.findById(email);
		if(!optionalUsuario.isPresent()) {
			throw new UsuarioNotFoundException("Usuario não encontrado através do email: "+email);
		} else {
			usuarioRepository.deleteById(email);			
		}
	}

}
