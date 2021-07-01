package com.rocketdev.instrumentoapi.resources;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.rocketdev.instrumentoapi.domain.Instrumento;
import com.rocketdev.instrumentoapi.services.InstrumentoService;
import com.rocketdev.instrumentoapi.utils.InstrumentoAPIException;
import io.swagger.annotations.ApiOperation;

/**
 * Clasee que representa o controller de 'Instrumento'
 * 
 * @author Rafael Marcelo
 * 
 */
@RestController
public class InstrumentoResource {
	/** Injeção de dependência. */
	@Autowired
	InstrumentoService instrumentoService;

	/**
	 * Método responsável por salvar um instrumento
	 * 
	 * @param instrumento
	 * @return um instrumento inserido no banco dados
	 * @throws InstrumentoAPIException caso exista um erro, retorna uma
	 *                                 InstrumentoAPIException
	 */
	@PostMapping(value = "/salvar-instrumento")
	@ApiOperation("Metodo que salva um instrumento")
	public Instrumento salvarInstrumento(@RequestBody Instrumento instrumento) throws InstrumentoAPIException {

		/** Envia um Intrumento para classe de négocio */
		instrumento = instrumentoService.incluir(instrumento);

		return instrumento;
	}

	/**
	 * Método responsável por alterar um instrumento
	 * 
	 * @param instrumento
	 * @return um instrumento alterado no banco de dados
	 * @throws InstrumentoAPIException caso exista um erro, retorna umax
	 *                                 InstrumentoAPIException
	 */
	@PutMapping(value = "/alterar-instrumento")
	@ApiOperation("Metodo que altera um instrumento")
	public Instrumento alterarInstrumento(@RequestBody Instrumento instrumento) throws InstrumentoAPIException {

		/** Envia um Intrumento para classe de négocio */
		instrumento = instrumentoService.alterar(instrumento);

		return instrumento;
	}

	/**
	 * Método responsável por consultar um instrumento
	 * 
	 * @param id
	 * @return uma consuta de um instrumento do banco de dados
	 * @throws InstrumentoAPIException caso exista um erro, retorna uma
	 *                                 InstrumentoAPIException
	 */
	@GetMapping(value = "/consultar-instrumento/{id}")
	@ApiOperation("Metodo que consulta um instrumento por id")
	public Instrumento consultarInstrumento(@PathVariable Integer id) throws InstrumentoAPIException {
		Instrumento instrumento = null;

		/** Solicita uma consulta de um Intrumento para classe de négocio */
		instrumento = instrumentoService.consultar(id);

		return instrumento;
	}

	/**
	 * Método responsável por excluir um instrumento
	 * 
	 * @param id
	 * @throws InstrumentoAPIException caso exista um erro, retorna uma
	 *                                 InstrumentoAPIException
	 */
	@DeleteMapping(value = "/excluir-instrumento/{id}")
	@ApiOperation("Metodo que exclui um instrumento pelo id")
	public void excluirInstrumento(@PathVariable Integer id) throws InstrumentoAPIException {

		/** Solicita uma exclusão de um Intrumento para classe de négocio */
		instrumentoService.excluir(id);
	}

	/**
	 * Método responsável por listar todos os instrumentos
	 * 
	 * @return uma lista de instrumento do banco de dados
	 */
	@GetMapping(value = "/listar-instrumento")
	@ApiOperation("Metodo que lista todos os instrumentos")
	public List<Instrumento> listarInstrumento() throws InstrumentoAPIException {
		List<Instrumento> listaInstrumentos = null;

		/** Solicita uma busca por todos os Intrumentos para classe de négocio */
		listaInstrumentos = instrumentoService.listar();

		return listaInstrumentos;
	}

	/**
	 * Método resposável por exibir uma mensagem de inicialização
	 * 
	 * @return mesagem de inicialização
	 */
	@ApiOperation("Metodo que exibe que aplcação está rodando")
	@GetMapping("/")
	public String iniciar() {
		/** Retona um string de inicialização */
		return "Aplicação iniciada.";
	}
}