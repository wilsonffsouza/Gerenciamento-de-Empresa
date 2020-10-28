package br.com.teste.patrimonio.resource.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PatrimonioResource {
	
	@JsonProperty("nome_Patrimonio")
	private String nome;
	
	@JsonProperty("marcaId_Patrimonio")
	private String marcaId;
	
	@JsonProperty("descricao_Patrimonio")
	private String descricao;
	
	@JsonProperty("numTombo_Patrimonio")
	private String numTombo;

	public PatrimonioResource(String nome, String marcaId, String descricao, String numTombo) {
		super();
		this.nome = nome;
		this.marcaId = marcaId;
		this.descricao = descricao;
		this.numTombo = numTombo;
	}

	public PatrimonioResource() {
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNumTombo() {
		return numTombo;
	}

	public void setNumTombo(String numTombo) {
		this.numTombo = numTombo;
	}

	@Override
	public String toString() {
		return "PatrimonioResource [nome=" + nome + ", marcaId=" + marcaId + ", descricao=" + descricao + ", numTombo="
				+ numTombo + "]";
	}

}
