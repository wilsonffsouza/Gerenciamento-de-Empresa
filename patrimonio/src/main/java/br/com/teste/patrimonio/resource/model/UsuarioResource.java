package br.com.teste.patrimonio.resource.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioResource {
	
	@JsonProperty("nome_usuario")
	private String nome;
	
	@JsonProperty("email_usuario")
	private String email;
	
	@JsonProperty("senha_usuario")
	private String senha;
	
	@JsonProperty("token_usuario")
	private String token;
	
}
