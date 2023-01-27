package br.com.fiap.enjoyit.domain;

import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "T_SIC_ESTABELECIMENTO")
public class Estabelecimento {

	@Id
	@SequenceGenerator(name = "estabelecimento", sequenceName = "seq_estabelecimento", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "estabelecimento")
	@Column(name = "cod_estabelecimento")
	private int id;
		
	@Column(name = "num_cnpj", nullable = false, length = 14, columnDefinition = "CHAR(14)")
	private String cnpj;
	
	@Column(name = "nom_estabelecimento", nullable = false, length = 50)
	private String nome;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dat_criacao")
	private Calendar dataCriacao;
	
	@OneToMany(mappedBy = "estabelecimento", cascade = CascadeType.PERSIST)
	private List<Consumidor> consumidor;
	
	public Estabelecimento() {}

	public Estabelecimento(int id, String cnpj, String nome, Calendar dataCriacao, List<Consumidor> consumidor) {
		super();
		this.id = id;
		this.cnpj = cnpj;
		this.nome = nome;
		this.dataCriacao = dataCriacao;
		this.consumidor = consumidor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Calendar getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Calendar dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public List<Consumidor> getConsumidor() {
		return consumidor;
	}

	public void setConsumidor(List<Consumidor> consumidor) {
		this.consumidor = consumidor;
	}
	
}
