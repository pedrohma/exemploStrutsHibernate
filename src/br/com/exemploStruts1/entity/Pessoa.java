package br.com.exemploStruts1.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "pessoa")
public class Pessoa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="idpessoa")
	private Integer idPessoa;
	@Column(name="nome", length=50, nullable=false)
	private String nome;
	@Column(name="email", length=50, nullable=false)
	private String email;
	@Column(name="cpf", length=14, nullable=false)
	private String cpf;
	@Column(name="infosComp", length=100, nullable=false)
	private String infosComp;
	@Temporal(TemporalType.DATE)
	@Column(name="dataEntrada", nullable=false)
	private Date dataEntrada = new Date(System.currentTimeMillis());
	
	public Pessoa() {
		// TODO Auto-generated constructor stub
	}

	public Integer getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(Integer idPessoa) {
		this.idPessoa = idPessoa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getInfosComp() {
		return infosComp;
	}

	public void setInfosComp(String infosComp) {
		this.infosComp = infosComp;
	}

	public Date getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(Date dataEntrada) {
		this.dataEntrada = new Date(System.currentTimeMillis());
	}

}
