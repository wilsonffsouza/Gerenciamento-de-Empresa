package br.com.teste.patrimonio.controller.helpers;

import java.util.List;
import java.util.Optional;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.teste.patrimonio.exception.PatrimonioNotFoundException;
import br.com.teste.patrimonio.exception.PatrimonioResourceException;
import br.com.teste.patrimonio.model.entities.Patrimonio;
import br.com.teste.patrimonio.model.repositories.PatrimonioRepository;
import br.com.teste.patrimonio.resource.model.PatrimonioResource;

public class PatrimonioHelpers {
	
	
	
	private static final Logger LOG = Logger.getLogger(PatrimonioHelpers.class);
	
	@Autowired
	private PatrimonioRepository patrimonioRepository;
	
	public Patrimonio conversor(PatrimonioResource patrimonio) throws PatrimonioResourceException {

		try {
			Patrimonio patrimonio2 = new Patrimonio();
			Long marca_Id = checkMarcaId(patrimonio.getMarcaId());
			Long num_Tombo = checkMarcaId(patrimonio.getNumTombo());
			patrimonio2.setNome(patrimonio.getNome());
			patrimonio2.setMarcaId(marca_Id);
			patrimonio2.setDescricao(patrimonio.getDescricao());
			patrimonio2.setNumTombo(num_Tombo);
			return patrimonio2;
		} catch (Exception e) {
			throw new PatrimonioResourceException("Falha ao converter o resource para entidade, resource: " + patrimonio);
		}
	}
	
	public Long checkMarcaId(String marcaId) {
		return Long.parseLong(marcaId);
	}
	
	public void cadastrar(PatrimonioResource patrimonioResource) {
		
		try {
			Patrimonio patrimonio = conversor(patrimonioResource);
			patrimonioRepository.save(patrimonio);
		} catch (PatrimonioResourceException e) {
			LOG.error("Erro oa salvar a Patrimonio: " + e.getMessage(), e);
		}
	}
	
	public List<Patrimonio> buscarTodosPatrimonios(){
		return (List<Patrimonio>) patrimonioRepository.findAll();
	}
	
	public Patrimonio buscarPorPatrimonioId(Long marcaId) throws PatrimonioNotFoundException {
		Optional<Patrimonio> optionalPatrimonio= patrimonioRepository.findById(marcaId);
		Patrimonio patrimonio = null;
		if(!optionalPatrimonio.isPresent()) {
			throw new PatrimonioNotFoundException("Patrimonio não encontrado através do MarcaId: " + marcaId);
		} else {
			patrimonio = optionalPatrimonio.get();
		}
		return patrimonio;
	}
	
	/*
	private Optional<Patrimonio> getOptional(Long marcaId) {
		Optional<Patrimonio> optionalPatrimonio= patrimonioRepository.findById(marcaId);
		return optionalPatrimonio;
	}
	*/
	
	public void deletarPorPatrimonioId(Long marcaId) throws PatrimonioNotFoundException {
		Optional<Patrimonio> optionalPatrimonio= patrimonioRepository.findById(marcaId);
		if(!optionalPatrimonio.isPresent()) {
			throw new PatrimonioNotFoundException("Patrimonio não encontrado através do MarcaId: " + marcaId);
		} else {
			patrimonioRepository.deleteById(marcaId);			
		}
	}
}

