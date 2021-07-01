package com.rocketdev.instrumentoapi.services;

import java.util.List;
import com.rocketdev.instrumentoapi.domain.Instrumento;
import com.rocketdev.instrumentoapi.utils.InstrumentoAPIException;

/**
 * Interface que define as operações da camada de negocio de Instrumento
 * 
 * @author Rafael Marcelo
 *
 */
public interface InstrumentoService {

	/**
	 * Método para incluir e validar os dados da camada de Entidade
	 * 
	 * @param instrumento
	 * @return retorna instrumento, caso nao retorna nenhum erro na validação
	 * @throws InstrumentoAPIException caso exista um erro, retorna uma
	 *                                 InstrumentoAPIException
	 */
	public Instrumento incluir(Instrumento instrumento) throws InstrumentoAPIException;

	/**
	 * Método para alterar e validar os dados da camada de Entidade
	 * 
	 * @param instrumento
	 * @return retorna instrumento, caso não retorna nenhum erro na validação
	 * @throws InstrumentoAPIException caso exista um erro, retorna uma
	 *                                 InstrumentoAPIException
	 */
	public Instrumento alterar(Instrumento instrumento) throws InstrumentoAPIException;

	/**
	 * Método para excluir e validar os dados da camada de Entidade
	 * 
	 * @param id
	 * @throws InstrumentoAPIException caso exista um erro, retorna uma
	 *                                 InstrumentoAPIException
	 */
	public void excluir(Integer id) throws InstrumentoAPIException;

	/**
	 * Método para consultar e validar os dados da camada de Entidade
	 * 
	 * @param id
	 * @return retorna instrumento, caso nao retorna nenhum erro na validação
	 * @throws InstrumentoAPIException caso exista um erro, retorna uma
	 *                                 InstrumentoAPIException
	 */
	public Instrumento consultar(Integer id) throws InstrumentoAPIException;

	/**
	 * Método para listar e validar se o objeto está vázio
	 * 
	 * @return retorna lista de instrumento
	 * @throws InstrumentoAPIException caso exista um erro, retorna uma
	 *                                 InstrumentoAPIException
	 */
	public List<Instrumento> listar() throws InstrumentoAPIException;
}
