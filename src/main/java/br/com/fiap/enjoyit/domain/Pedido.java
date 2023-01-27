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
@Table(name = "T_SIC_PEDIDO")
public class Pedido {

	@Id 
	@Column(name = "cod_comanda")
	private int id;
	
	@ManyToOne(optional = false, cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinColumn(name = "cod_consumidor")
	private Consumidor consumidor;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "dat_emissao",  nullable = false)
	private Calendar dataEmissao;
	
	@Column(name = "des_forma_pgto", nullable = false, length = 50)
	private String formaPagamento;
	
	@Column(name = "val_desconto", columnDefinition = "NUMBER(7,2)")
	private double valorDesconto;
	
	@Column(name = "val_total", nullable = false, columnDefinition = "NUMBER(7,2)")
	private double valorTotal;
	
	@OneToMany(mappedBy = "pedido", cascade = CascadeType.PERSIST)
	private List<ItemPedido> itemPedido;
	
	public Pedido() {}

	public Pedido(int id, Consumidor consumidor, Calendar dataEmissao, String formaPagamento, double valorDesconto,
			double valorTotal, List<ItemPedido> itemPedido) {
		super();
		this.id = id;
		this.consumidor = consumidor;
		this.dataEmissao = dataEmissao;
		this.formaPagamento = formaPagamento;
		this.valorDesconto = valorDesconto;
		this.valorTotal = valorTotal;
		this.itemPedido = itemPedido;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Consumidor getConsumidor() {
		return consumidor;
	}

	public void setConsumidor(Consumidor consumidor) {
		this.consumidor = consumidor;
	}

	public Calendar getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(Calendar dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public String getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public double getValorDesconto() {
		return valorDesconto;
	}

	public void setValorDesconto(double valorDesconto) {
		this.valorDesconto = valorDesconto;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public List<ItemPedido> getItemPedido() {
		return itemPedido;
	}

	public void setItemPedido(List<ItemPedido> itemPedido) {
		this.itemPedido = itemPedido;
	}

}