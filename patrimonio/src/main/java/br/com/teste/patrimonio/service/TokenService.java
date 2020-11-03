package br.com.teste.patrimonio.service;

import java.util.Date;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.teste.patrimonio.model.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {
	
	private static final long expirationTime = 1800000;
	private String key = "String Aleatoria Secreta";

	public String  generateToken(Optional<Usuario> usuario) {
		return Jwts.builder()
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setSubject("Teste Jwt API")
				.setExpiration(new Date(System.currentTimeMillis() + expirationTime))
				.signWith(SignatureAlgorithm.HS256, key)
				.compact();
	}

	public Claims decodeToken(String token) {
		return Jwts.parser()
				.setSigningKey(key)
				.parseClaimsJws(token)
				.getBody();
	}

}
