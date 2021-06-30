package com.rocketdev.instrumentoapi.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Classe que representa os dados na persistencia de 'Instrumento'
 * 
 * @author Rafael Marcelo
 * 
 */
@Entity
@Table(name = "instrumento")
public class Instrumento {

	/** Atributos */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "nome_instrumento")
	private String nome;
	@Column(name = "nome_cliente")
	private String nomeCliente;
	@Column(name = "email_cliente")
	private String email;
	@Column(name = "valor_unitario")
	private Float valor;
	@Column(name = "data_compra")
	private Date dataCompra;
	@Column(name = "quantidade_compra")
	private Integer quantidadeCompra;

	/** Construtores */
	public Instrumento() {
	}

	public Instrumento(Integer id, String nome, String nomeCliente, String email, Float valor, Date dataCompra,
			Integer quantidadeCompra) {
		super();
		this.id = id;
		this.nome = nome;
		this.nomeCliente = nomeCliente;
		this.email = email;
		this.valor = valor;
		this.dataCompra = dataCompra;
		this.quantidadeCompra = quantidadeCompra;
	}

	/** Get e Sets */
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}

	public Date getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(Date dataCompra) {
		this.dataCompra = dataCompra;
	}

	public Integer getQuantidadeCompra() {
		return quantidadeCompra;
	}

	public void setQuantidadeCompra(Integer quantidadeCompra) {
		this.quantidadeCompra = quantidadeCompra;
	}

	/** ToString */
	@Override
	public String toString() {
		return "Instrumento [id=" + id + ", nome=" + nome + ", nomeCliente=" + nomeCliente + ", email=" + email
				+ ", valor=" + valor + ", dataCompra=" + dataCompra + ", quantidadeCompra=" + quantidadeCompra + "]";
	}

	/** hashCode equals */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Instrumento other = (Instrumento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
