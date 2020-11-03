package br.com.teste.patrimonio.service;

import java.util.List;
import java.util.Optional;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.teste.patrimonio.exception.MarcaNotFoundException;
import br.com.teste.patrimonio.exception.MarcaResourceException;
import br.com.teste.patrimonio.model.Marca;
import br.com.teste.patrimonio.repository.MarcaRepository;
import br.com.teste.patrimonio.resource.model.MarcaResource;

@Service
public class MarcaService {
	
	private static final Logger LOG = Logger.getLogger(MarcaService.class);
	
	@Autowired
	private MarcaRepository marcaRepository;
	
	public void cadastrar(MarcaResource marcaResource) {
		
		try {
			Marca marca = conversor(marcaResource);
			marcaRepository.save(marca);
		} catch (MarcaResourceException e) {
			LOG.error("Erro oa salvar a Marca: " + e.getMessage(), e);
		}
	}
	
	public Marca conversor(MarcaResource marca) throws MarcaResourceException {

		try {
			Marca marca2 = new Marca();
			Long marca_Id = checkMarcaId(marca.getMarcaId());
			marca2.setNome(marca.getNome());
			marca2.setMarcaId(marca_Id);
			return marca2;
		} catch (Exception e) {
			throw new MarcaResourceException("Falha ao converter o resource para entidade, resource: " + marca);
		}
	}
	
	public Long checkMarcaId(String marcaId) {
		return Long.parseLong(marcaId);
	}
	
	public List<Marca> buscarTodasMarcas(){
		return (List<Marca>) marcaRepository.findAll();
	}
	
	public Marca buscarPorMarcaId(Long marcaId) throws MarcaNotFoundException {
		Optional<Marca> optionalMarca = marcaRepository.findById(marcaId);
		Marca marca = null;
		if(!optionalMarca.isPresent()) {
			throw new MarcaNotFoundException("Marca não encontrada através do MarcaId: " + marcaId);
		} else {
			marca = optionalMarca.get();
		}
		return marca;
	}
	
	/*
	private Optional<Marca> getOptional(Long marcaId) {
		Optional<Marca> optionalMarca= marcaRepository.findById(marcaId);
		return optionalMarca;
	}
	*/
	
	public void deletarPorMarcaId(Long marcaId) throws MarcaNotFoundException {
		Optional<Marca> optionalMarca = marcaRepository.findById(marcaId);
		if(!optionalMarca.isPresent()) {
			throw new MarcaNotFoundException("Marca não encontrada através do MarcaId: " + marcaId);
		} else {
			marcaRepository.deleteById(marcaId);			
		}
	}
}

