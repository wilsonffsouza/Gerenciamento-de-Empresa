package br.com.teste.patrimonio.resource.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MarcaResource {
	
	@JsonProperty("nome_marca")
	private String nome;
	
	@JsonProperty("marcaId_marca")
	private String marcaId;

	public MarcaResource(String nome, String marcaId) {
		super();
		this.nome = nome;
		this.marcaId = marcaId;
	}

	public MarcaResource() {
		super();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMarcaId() {
		return marcaId;
	}

	public void setMarcaId(String marcaId) {
		this.marcaId = marcaId;
	}

	@Override
	public String toString() {
		return "MarcaResource [nome=" + nome + ", marcaId=" + marcaId + "]";
	}

}
