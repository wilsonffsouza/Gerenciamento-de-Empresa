package br.com.teste.patrimonio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.teste.patrimonio.controller.helpers.PatrimonioHelpers;
import br.com.teste.patrimonio.exception.PatrimonioNotFoundException;
import br.com.teste.patrimonio.model.entities.Patrimonio;
import br.com.teste.patrimonio.resource.model.PatrimonioResource;

@RestController
@RequestMapping(value = "/api")
public class PatrimonioController {
	
	
	@Autowired
	private PatrimonioHelpers helpers;

	@PostMapping(path = "/patrimonio/save")
	public void novoPatrimonio(@RequestBody PatrimonioResource patrimonio) {
		helpers.cadastrar(patrimonio);
	}
	
	@GetMapping(path = "/patrimonios")
	public List<Patrimonio> buscarTodosPatrimonios(){
		return helpers.buscarTodosPatrimonios();
	}
	
	@GetMapping(path = "/patrimonios/id/{marcaId}")
	public Patrimonio buscarPatrimoniosPorMarcaId(
			@PathVariable(name = "marcaId", required = true) Long marcaId) throws PatrimonioNotFoundException{
		return helpers.buscarPorPatrimonioId(marcaId);
	}
	
	@DeleteMapping(path = "/patrimonios/delete/{marcaId}")
	public void deletePatrimonio (
			@PathVariable(name = "marcaId", required = true) Long marcaId) throws PatrimonioNotFoundException {
		helpers.deletarPorPatrimonioId(marcaId);
	}

}
