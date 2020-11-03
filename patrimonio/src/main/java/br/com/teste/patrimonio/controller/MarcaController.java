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

import br.com.teste.patrimonio.exception.MarcaNotFoundException;
import br.com.teste.patrimonio.model.Marca;
import br.com.teste.patrimonio.resource.model.MarcaResource;
import br.com.teste.patrimonio.service.MarcaService;

@RestController
@RequestMapping(value = "/api")
public class MarcaController {

	@Autowired
	private MarcaService helpers;

	@PostMapping(path = "/marca/save")
	public void novaMarca(@RequestBody MarcaResource marca) {
		helpers.cadastrar(marca);
	}
	
	@GetMapping(path = "/marcas")
	public List<Marca> buscarTodasMarcas(){
		return helpers.buscarTodasMarcas();
	}
	
	@GetMapping(path = "/marca/id/{email}")
	public Marca buscarMarcasPorMarcaId(
			@PathVariable(name = "marcaId", required = true) Long marcaId) throws MarcaNotFoundException{
		return helpers.buscarPorMarcaId(marcaId);
	}
	
	@DeleteMapping(path = "/marca/delete/{marcaId}")
	public void deleteMarca (
			@PathVariable(name = "marcaId", required = true) Long marcaId) throws MarcaNotFoundException {
		helpers.deletarPorMarcaId(marcaId);
	}
}
