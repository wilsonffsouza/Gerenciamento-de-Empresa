package br.com.teste.patrimonio.resource.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UsuarioResource {
	
	@JsonProperty("nome_usuario")
	private String nome;
	
	@JsonProperty("email_usuario")
	private String email;
	
	@JsonProperty("senha_usuario")
	private String senha;

	public UsuarioResource(String nome, String email, String senha) {
		super();
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}

	public UsuarioResource() {
		super();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "UsuarioResource [nome=" + nome + ", email=" + email + ", senha=" + senha + "]";
	}
	
}
