package br.com.teste.patrimonio.service;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import br.com.teste.patrimonio.exception.MarcaNotFoundException;
import br.com.teste.patrimonio.exception.MarcaResourceException;
import br.com.teste.patrimonio.model.Marca;
import br.com.teste.patrimonio.repository.MarcaRepository;
import br.com.teste.patrimonio.resource.model.MarcaResource;

@SpringBootTest
@RunWith(SpringRunner.class)
@WebAppConfiguration
@Sql(scripts = "/sql/insert_marca_para_teste.sql")
public class MarcaTeste {

	@Autowired
	private MarcaService helpers;	

	@Autowired
	private MarcaRepository marcaRepository;
	
	
	@Test
	public void inserirNovaMarca() throws MarcaResourceException {
		MarcaResource marcaResource = new MarcaResource("MarcaTeste", "1234");
		helpers.cadastrar(marcaResource);
	}

	@Test
	public void buscarPorMarcaIdTest() throws MarcaNotFoundException {
		Marca marca = helpers.buscarPorMarcaId(1234L);
		assertEquals("MarcaTeste", marca.getNome());
		assertEquals(1234L, marca.getMarcaId());
	}
	
	@Test
	public void deletarPorMarcaId() throws MarcaNotFoundException {
		helpers.deletarPorMarcaId(1234L);
		
		Optional<Marca> optionalMarca = marcaRepository.findById(1234L);
		
		assertFalse(optionalMarca.isPresent());
	}
}
