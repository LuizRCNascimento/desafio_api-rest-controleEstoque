package starter.apirest.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Compra {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idRequisicao;

	@ManyToOne
	private PedidoCompra pedidoCompra;
	
	private long quantidadeCompra;  
	
	private long valorCompra;  

	@OneToOne
	private Estoque estoque;
	
//	@OneToMany (mappedBy = "compra")
//	@JoinColumn(name = "idProduto")
//	private List<Estoque> estoque;
	
//	@OneToOne(mappedBy = "idProduto")
//	@JoinColumn
//	private Estoque estoque;

	//Constructors
	public Compra() {
	}
	
	public long getIdRequisicao() {
		return idRequisicao;
	}

	public void setIdRequisicao(long idRequisicao) {
		this.idRequisicao = idRequisicao;
	}

//	public PedidoCompra getPedidoCompra() {
//		return pedidoCompra;
//	}

//	public void setPedidoCompra(PedidoCompra pedidoCompra) {
//		this.pedidoCompra = pedidoCompra;
//	}

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((estoque == null) ? 0 : estoque.hashCode());
		result = prime * result + (int) (idRequisicao ^ (idRequisicao >>> 32));
		result = prime * result + ((pedidoCompra == null) ? 0 : pedidoCompra.hashCode());
		result = prime * result + (int) (quantidadeCompra ^ (quantidadeCompra >>> 32));
		result = prime * result + (int) (valorCompra ^ (valorCompra >>> 32));
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
		Compra other = (Compra) obj;
		if (estoque == null) {
			if (other.estoque != null)
				return false;
		} else if (!estoque.equals(other.estoque))
			return false;
		if (idRequisicao != other.idRequisicao)
			return false;
		if (pedidoCompra == null) {
			if (other.pedidoCompra != null)
				return false;
		} else if (!pedidoCompra.equals(other.pedidoCompra))
			return false;
		if (quantidadeCompra != other.quantidadeCompra)
			return false;
		if (valorCompra != other.valorCompra)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Compra [idRequisicao=" + idRequisicao + ", quantidadeCompra="
				+ quantidadeCompra + ", valorCompra=" + valorCompra + "]";
	}
	
}
