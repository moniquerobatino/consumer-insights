package br.com.fiap.enjoyit.domain;

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

@Entity
@Table(name = "T_SIC_CERVEJA")
public class Cerveja {

	@Id
	@SequenceGenerator(name = "produto", sequenceName = "seq_produto", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produto")
	@Column(name = "cod_cerveja")
	private int id;
	
	@Column(name = "nom_cerveja", nullable = false, length = 50)
	private String nome;
	
	@Column(name = "des_estilo", nullable = false, length = 50)
	private String estilo;
	
	@Column(name = "ind_amargor", nullable = false)
	private int amargor;
	
	@Column(name = "vol_teor_alcoolico", nullable = false, columnDefinition = "NUMBER(3,1)")
	private double teorAlcoolico;
	
	@OneToMany(mappedBy = "cerveja", cascade = CascadeType.PERSIST)
	private List<ItemPedido> itemPedido;
	
	public Cerveja() {}

	public Cerveja(int id, String nome, String estilo, int amargor, double teorAlcoolico, List<ItemPedido> itemPedido) {
		super();
		this.id = id;
		this.nome = nome;
		this.estilo = estilo;
		this.amargor = amargor;
		this.teorAlcoolico = teorAlcoolico;
		this.itemPedido = itemPedido;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEstilo() {
		return estilo;
	}

	public void setEstilo(String estilo) {
		this.estilo = estilo;
	}

	public int getAmargor() {
		return amargor;
	}

	public void setAmargor(int amargor) {
		this.amargor = amargor;
	}

	public double getTeorAlcoolico() {
		return teorAlcoolico;
	}

	public void setTeorAlcoolico(double teorAlcoolico) {
		this.teorAlcoolico = teorAlcoolico;
	}

	public List<ItemPedido> getItemPedido() {
		return itemPedido;
	}

	public void setItemPedido(List<ItemPedido> itemPedido) {
		this.itemPedido = itemPedido;
	}

}
