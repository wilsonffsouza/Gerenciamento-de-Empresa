package br.com.teste.patrimonio.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.mail.internet.InternetAddress;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.teste.patrimonio.exception.ExpiredTokenExpition;
import br.com.teste.patrimonio.exception.InvalideTokenException;
import br.com.teste.patrimonio.exception.UsuarioNotFoundException;
import br.com.teste.patrimonio.exception.UsuarioResourceException;
import br.com.teste.patrimonio.model.Usuario;
import br.com.teste.patrimonio.repository.UsuarioRepository;
import br.com.teste.patrimonio.resource.model.UsuarioResource;
import io.jsonwebtoken.Claims;

@Service
public class UsuarioService {

	private static final Logger LOG = Logger.getLogger(UsuarioService.class);

	private UsuarioRepository usuarioRepository;

	private TokenService tokenService;
		
	@Autowired
	public UsuarioService(UsuarioRepository usuarioRepository, TokenService tokenService) {
		this.usuarioRepository = usuarioRepository;
		this.tokenService = tokenService;
	}

	public Optional<Usuario> autenticado(UsuarioResource dados, String token) throws UsuarioNotFoundException{
		Optional<Usuario> usuario = usuarioRepository.findById(dados.getEmail());
		if (dados.getSenha().equals(usuario.get().getSenha()) && !token.isEmpty() && validate(token)) {
			token = tokenService.generateToken(usuario);
			System.out.println(token);
			usuario.get().setToken(token);
			return usuario;
		} else {
			throw new UsuarioNotFoundException();
		}
	}

	private boolean validate(String token) {
		try {
			Claims claims = tokenService.decodeToken(token);
			if(claims.getExpiration().before(new Date(System.currentTimeMillis()))) throw new ExpiredTokenExpition();
			return true;
		} catch (ExpiredTokenExpition e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw new InvalideTokenException();
		}
		
	}

	public void cadastrar(UsuarioResource usuarioResource) {

		try {
			Usuario usuario = conversor(usuarioResource);
			usuario.setToken(tokenService.generateToken(Optional.of(usuario)));
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

	public List<Usuario> buscarTodosUsuarios() {
		return (List<Usuario>) usuarioRepository.findAll();
	}

	public Usuario buscarPorEmail(String email) throws UsuarioNotFoundException {
		Optional<Usuario> optionalUsuario = usuarioRepository.findById(email);
		Usuario usuario = null;
		if (!optionalUsuario.isPresent()) {
			throw new UsuarioNotFoundException("Usuario não encontrado através do email: " + email);
		} else {
			usuario = optionalUsuario.get();
		}
		return usuario;
	}

	private Optional<Usuario> getOptional(String email) {
		Optional<Usuario> optionalUsuario = getOptional(email);
		return optionalUsuario;
	}

	public void deletarPorEmail(String email) throws UsuarioNotFoundException {
		Optional<Usuario> optionalUsuario = getOptional(email);
		if (!optionalUsuario.isPresent()) {
			throw new UsuarioNotFoundException("Usuario não encontrado através do email: " + email);
		} else {
			usuarioRepository.deleteById(email);
		}
	}

}
