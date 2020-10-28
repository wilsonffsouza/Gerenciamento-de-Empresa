package br.com.teste.patrimonio.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_usuarios")
public class Usuario {

	@Column(nullable = false)
	private String nome;

	@Id
	@Column(unique = true, nullable = false)
	private String email;
	
	@Column(nullable = false)
	private String senha;

}
