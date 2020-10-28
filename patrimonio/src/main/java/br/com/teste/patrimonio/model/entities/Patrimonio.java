package br.com.teste.patrimonio.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_patrimonios")
public class Patrimonio {

	@Column(nullable = false)
	private String nome;
	
	@Id
	@Column(unique = true, nullable = false)
	private Long marcaId;
	
	private String descricao;
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long numTombo;
	
}
