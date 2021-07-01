package com.rocketdev.instrumentoapi.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.rocketdev.instrumentoapi.domain.Instrumento;
import com.rocketdev.instrumentoapi.repositories.InstrumentoRepository;
import com.rocketdev.instrumentoapi.utils.InstrumentoAPIException;

/**
 * Classe que define as operações da camada de negocio de Instrumento
 * 
 * @author Rafael Marcelo
 *
 */
@Service
@Transactional
public class InstrumentoServiceImpl implements InstrumentoService {

	/** Injeção de dependência. */
	@Autowired
	private InstrumentoRepository instrumentoRepository;

	/** Get e Sets do objeto de acesso ao repositorio */
	public InstrumentoRepository getInstrumentoRepository() {
		return instrumentoRepository;
	}

	public void setInstrumentoRepository(InstrumentoRepository instrumentoRepository) {
		this.instrumentoRepository = instrumentoRepository;
	}

	/**
	 * Método responsável por chamar o método de inserir um instrumento no banco de
	 * dados
	 */
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Instrumento incluir(Instrumento instrumento) throws InstrumentoAPIException {

		/** Valida o ID de instrumento */
		validarIDInsercao(instrumento.getId());

		/** Valida os dados da entidade */
		validarDadosEntidade(instrumento);

		/** Insere o instrumento no banco de dados */
		return this.getInstrumentoRepository().save(instrumento);
	}

	/**
	 * Método responsável por chamar o método de alterar um instrumento no banco de
	 * dados
	 */
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Instrumento alterar(Instrumento instrumento) throws InstrumentoAPIException {

		/** Valida o ID de instrumento */
		validarIDAlteracao(instrumento.getId());

		if (this.getInstrumentoRepository().existsById(instrumento.getId())) {

			/** Valida os dados da entidade */
			validarDadosEntidade(instrumento);

			/** Altera o instrumento no banco de dados */
			return this.getInstrumentoRepository().save(instrumento);
		} else {
			throw new InstrumentoAPIException("ID não consta na base de dados.");
		}
	}

	/**
	 * Método responsável por chamar o método de excluir um instrumento no banco de
	 * dados
	 */
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void excluir(Integer id) throws InstrumentoAPIException {

		if (this.getInstrumentoRepository().existsById(id)) {
			/** Exclui um instrumento no banco de dados */
			this.getInstrumentoRepository().deleteById(id);
		} else {
			throw new InstrumentoAPIException("ID: " + id + " não encontrado na base de dados.");
		}
	}

	/**
	 * Método responsável por chamar o método de consultar um instrumento no banco
	 * de dados
	 */
	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS, rollbackFor = Exception.class)
	public Instrumento consultar(Integer id) throws InstrumentoAPIException {

		if (this.getInstrumentoRepository().existsById(id)) {

			/** Consulta um instrumento no banco de dados */
			Instrumento instrumento = this.getInstrumentoRepository().findById(id).get();
			return instrumento;
		} else {
			throw new InstrumentoAPIException("ID: " + id + " não encontrado na base de dados.");
		}
	}

	/**
	 * Método responsável por chamar o método de listar todos os instrumentos do
	 * banco de dados
	 */
	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS, rollbackFor = Exception.class)
	public List<Instrumento> listar() throws InstrumentoAPIException {

		/** Lista todos os instrumentos do banco de dados */
		List<Instrumento> listaInstrumentos = (List<Instrumento>) this.getInstrumentoRepository().findAll();

		return listaInstrumentos;
	}

	/**
	 * Método que valida todos os campos da camanda da 'Entidade'
	 * 
	 * @param instrumento
	 * @throws InstrumentoAPIException caso exista um erro, retorna uma
	 *                                 InstrumentoAPIException
	 */
	private void validarDadosEntidade(Instrumento instrumento) throws InstrumentoAPIException {
		String regex_email = "^[a-zA-Z0-9._-]+@[a-zA-Z0-9]+\\.[a-z]+(\\.[a-z]+)?$";
		String regex_nome = "[a-zA-Z\\s]+";

		/** Validação do nome 'Instrumento' */
		if (instrumento.getNome().length() > 50 || !(instrumento.getNome().matches(regex_nome))) {
			throw new InstrumentoAPIException("Nome do instrumento inválido.");
		}

		if (instrumento.getNome() == null) {
			throw new InstrumentoAPIException("Nome do instrumento não pode está vazio.");
		}
		/** Fim valida nome */

		/** Validação do nome cliente de 'Instrumento' */
		if (instrumento.getNomeCliente().length() > 50 || !(instrumento.getNomeCliente().matches(regex_nome))) {
			throw new InstrumentoAPIException("Nome do clietne inválido.");
		}

		if (instrumento.getNomeCliente().length() < 3) {
			throw new InstrumentoAPIException("Nome do clietne menor que 3 caracteres.");
		}
		/** Fim valida nome cliente */

		/** Validação de email 'Instrumento' */
		if (!(instrumento.getEmail().matches(regex_email)) || instrumento.getEmail().length() > 50) {
			throw new InstrumentoAPIException("E-mail inválido.");
		}
		/** Fim valida e-mail */

		/** Validação de Data de compra de 'Instrumento' */
		if (instrumento.getDataCompra() == null) {
			throw new InstrumentoAPIException("Data de compra de instrumento inválida.");
		}

		/** Fim validação de Data de compra de 'Instrumento' */

		/** Validação de valor 'Instrumento' */
		if (instrumento.getValor() <= 0.0) {
			throw new InstrumentoAPIException("Valor do instrumento inválido.");
		}
		/** Fim valida valor */

		/** Validação de quantidade 'Instrumento' */
		if (instrumento.getQuantidadeCompra() <= 0) {
			throw new InstrumentoAPIException("Quantidade de compra de instrumento inválido.");
		}
		/** Fim valida quantidade */
	}

	/**
	 * Método responsável validar o ID de inserção no banco de dados
	 * 
	 * @param id
	 * @throws InstrumentoAPIException caso exista um erro, retorna uma
	 *                                 InstrumentoAPIException
	 */
	private void validarIDInsercao(Integer id) throws InstrumentoAPIException {
		if (id != null) {
			throw new InstrumentoAPIException("Método de inserção, ID tem que está NULO.");
		}
	}

	/**
	 * Método responsável validar o ID de alteração no banco de dados
	 * 
	 * @param id
	 * @throws InstrumentoAPIException caso exista um erro, retorna uma
	 *                                 InstrumentoAPIException
	 * 
	 */
	private void validarIDAlteracao(Integer id) throws InstrumentoAPIException {
		if (id == null) {
			throw new InstrumentoAPIException("Método de alteração, ID não pode está NULO.");
		}
	}
}
