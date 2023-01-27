package br.com.fiap.enjoyit.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@IdClass(ItemPedidoId.class)
@Table(name = "T_SIC_ITEM_PEDIDO")
public class ItemPedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinColumn(name = "cod_comanda")
	private Pedido pedido;
	
	@Id
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinColumn(name = "cod_cerveja")
	private Cerveja cerveja;
	
	@Column(name = "val_unitario", nullable = false, columnDefinition = "NUMBER(7,2)")
	private double valorUnitario;
	
	@Column(name = "num_dose_consumida", nullable = false)
	private int doseConsumida;
	
	public ItemPedido() {}

	public ItemPedido(Pedido pedido, Cerveja cerveja, double valorUnitario, int doseConsumida) {
		super();
		this.pedido = pedido;
		this.cerveja = cerveja;
		this.valorUnitario = valorUnitario;
		this.doseConsumida = doseConsumida;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Cerveja getCerveja() {
		return cerveja;
	}

	public void setCerveja(Cerveja cerveja) {
		this.cerveja = cerveja;
	}

	public double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public int getDoseConsumida() {
		return doseConsumida;
	}

	public void setDoseConsumida(int doseConsumida) {
		this.doseConsumida = doseConsumida;
	}

}