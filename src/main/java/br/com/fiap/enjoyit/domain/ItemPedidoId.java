package br.com.fiap.enjoyit.domain;

import java.io.Serializable;

public class ItemPedidoId implements Serializable {
	private static final long serialVersionUID = 1L;

	private int pedido;
	
	private int cerveja;
	
	public ItemPedidoId() {}

	public ItemPedidoId(int pedido, int cerveja) {
		super();
		this.pedido = pedido;
		this.cerveja = cerveja;
	}

	public int getPedido() {
		return pedido;
	}

	public void setPedido(int pedido) {
		this.pedido = pedido;
	}

	public int getCerveja() {
		return cerveja;
	}

	public void setCerveja(int cerveja) {
		this.cerveja = cerveja;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cerveja;
		result = prime * result + pedido;
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
		ItemPedidoId other = (ItemPedidoId) obj;
		if (cerveja != other.cerveja)
			return false;
		if (pedido != other.pedido)
			return false;
		return true;
	}
	
}
