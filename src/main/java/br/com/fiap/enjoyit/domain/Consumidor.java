package br.com.fiap.enjoyit.domain;

import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "T_SIC_CONSUMIDOR")
public class Consumidor {

	@Id 
	@Column(name = "cod_consumidor", length = 14, columnDefinition = "CHAR(14)")
	private String telefone;
	
	@ManyToOne(optional = false, cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinColumn(name = "cod_estabelecimento")
	private Estabelecimento estabelecimento;
	
	@Column(name = "num_cpf", length = 11, columnDefinition = "CHAR(11)")
	private String cpf;
	
	@Column(name = "nom_consumidor", nullable = false, length = 50)
	private String nome;

	@Column(name = "des_genero", columnDefinition = "CHAR")
	private String genero;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "dat_nascimento")
	private Calendar dataNascimento;
	
	@Column(name = "des_email", length = 50)
	private String email;
	
	@Column(name = "num_cep", length = 8, columnDefinition = "CHAR(8)")
	private String cep;
	
	@Column(name = "des_endereco", length = 100)
	private String endereco;
	
	@Column(name = "des_cidade", length = 50)
	private String cidade;
	
	@Column(name = "des_estado", length = 2, columnDefinition = "CHAR(2)")
	private String estado;
	
	@OneToMany(mappedBy = "consumidor", cascade = CascadeType.PERSIST)
	private List<Pedido> pedido;
	
	public Consumidor() {}

	public Consumidor(String telefone, Estabelecimento estabelecimento, String cpf, String nome, String genero,
			Calendar dataNascimento, String email, String cep, String endereco, String cidade, String estado,
			List<Pedido> pedido) {
		super();
		this.telefone = telefone;
		this.estabelecimento = estabelecimento;
		this.cpf = cpf;
		this.nome = nome;
		this.genero = genero;
		this.dataNascimento = dataNascimento;
		this.email = email;
		this.cep = cep;
		this.endereco = endereco;
		this.cidade = cidade;
		this.estado = estado;
		this.pedido = pedido;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public List<Pedido> getPedido() {
		return pedido;
	}

	public void setPedido(List<Pedido> pedido) {
		this.pedido = pedido;
	}
	
}
