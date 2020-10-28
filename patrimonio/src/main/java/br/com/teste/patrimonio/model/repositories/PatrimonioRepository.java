package br.com.teste.patrimonio.model.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.teste.patrimonio.model.entities.Patrimonio;

public interface PatrimonioRepository extends CrudRepository<Patrimonio, Long>{

}
