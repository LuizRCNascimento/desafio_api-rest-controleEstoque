package starter.apirest.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Venda {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idRequisição;

	@ManyToOne
	private PedidoVenda pedidoVenda;
	
	private long quantidadeCompra;  
	
	private long valorCompra;  
	
	@OneToOne
	private Estoque estoque;

	public Venda(long idRequisição, PedidoVenda pedidoVenda, long quantidadeCompra, long valorCompra, Estoque estoque) {
		super();
		this.idRequisição = idRequisição;
		this.pedidoVenda = pedidoVenda;
		this.quantidadeCompra = quantidadeCompra;
		this.valorCompra = valorCompra;
		this.estoque = estoque;
	}

	public long getIdRequisição() {
		return idRequisição;
	}

	public void setIdRequisição(long idRequisição) {
		this.idRequisição = idRequisição;
	}

	public PedidoVenda getPedidoVenda() {
		return pedidoVenda;
	}

	public void setPedidoVenda(PedidoVenda pedidoVenda) {
		this.pedidoVenda = pedidoVenda;
	}

	public long getQuantidadeCompra() {
		return quantidadeCompra;
	}

	public void setQuantidadeCompra(long quantidadeCompra) {
		this.quantidadeCompra = quantidadeCompra;
	}

	public long getValorCompra() {
		return valorCompra;
	}

	public void setValorCompra(long valorCompra) {
		this.valorCompra = valorCompra;
	}

	public Estoque getEstoque() {
		return estoque;
	}

	public void setEstoque(Estoque estoque) {
		this.estoque = estoque;
	}
	
	


}
