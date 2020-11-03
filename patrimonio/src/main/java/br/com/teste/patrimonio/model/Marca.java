package br.com.teste.patrimonio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "tb_marcas")
public class Marca {
	
	@Column(unique = true, nullable = false)
	private String nome;
	
	@Id
	@Column(nullable = false)
	private Long marcaId;

}
