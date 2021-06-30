package com.rocketdev.instrumentoapi.repositories;

import org.springframework.data.repository.CrudRepository;
import com.rocketdev.instrumentoapi.domain.Instrumento;

/**
 * Interface que define as operações da camada de persistencia de instrumento
 * 
 * @author Rafael Marcelo
 *
 */
public interface InstrumentoRepository extends CrudRepository<Instrumento, Integer> {
}
