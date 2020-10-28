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

import br.com.teste.patrimonio.controller.helpers.PatrimonioHelpers;
import br.com.teste.patrimonio.exception.PatrimonioNotFoundException;
import br.com.teste.patrimonio.exception.PatrimonioResourceException;
import br.com.teste.patrimonio.model.entities.Patrimonio;
import br.com.teste.patrimonio.model.repositories.PatrimonioRepository;
import br.com.teste.patrimonio.resource.model.PatrimonioResource;

@SpringBootTest
@RunWith(SpringRunner.class)
@WebAppConfiguration
@Sql(scripts = "/sql/insert_patrimonio_para_teste.sql")
public class PatrimonioTeste {

	@Autowired
	private PatrimonioHelpers helpers;
	
	@Autowired
	private PatrimonioRepository patrimonioRepository;

	@Test
	public void inserirNovoPatrimonio() throws PatrimonioResourceException {
		PatrimonioResource patrimonioResource = new PatrimonioResource("PatrimonioTeste", "1234", "Teste para entidade Patrimonio", "1");
		helpers.cadastrar(patrimonioResource);
	}

	@Test
	public void buscarPorPatrimonioIdTest() throws PatrimonioNotFoundException {
		Patrimonio patrimonio = helpers.buscarPorPatrimonioId(1234L);
		assertEquals("PatrimonioTeste", patrimonio.getNome());
		assertEquals(1L, patrimonio.getNumTombo());
		assertEquals(1234L, patrimonio.getMarcaId());
	}
	
	@Test
	public void deletarPorPatrimonioId() throws PatrimonioNotFoundException {
		helpers.deletarPorPatrimonioId(1234L);
		
		Optional<Patrimonio> optionalPatrimonio = patrimonioRepository.findById(1234L);
		
		assertFalse(optionalPatrimonio.isPresent());
	}
}
