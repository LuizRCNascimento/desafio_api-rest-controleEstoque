package starter.apirest.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

@Entity
public class Estoque {
	@Id
	private long idProduto;
	private long quantidadeEstoque;
	private long valorVenda;
	
	@OneToOne
	@MapsId
	@JoinColumn(name = "idProduto")
	private Produto produto;
	
	@OneToOne(mappedBy = "estoque", cascade = CascadeType.ALL)
//	@JoinColumn(name = "idProduto")
	private Compra compra;
	
	public Estoque() {
	}

	public Estoque(long idProduto, long quantidadeEstoque, long valorVenda) {
		super();
		this.idProduto = idProduto;
		this.quantidadeEstoque = quantidadeEstoque;
		this.valorVenda = valorVenda;
	}

	public long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(long idProduto) {
		this.idProduto = idProduto;
	}

	public long getQuantidadeEstoque() {
		return quantidadeEstoque;
	}

	public void setQuantidadeEstoque(long quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}

	public long getValorVenda() {
		return valorVenda;
	}

	public void setValorVenda(long valorVenda) {
		this.valorVenda = valorVenda;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idProduto ^ (idProduto >>> 32));
		result = prime * result + (int) (quantidadeEstoque ^ (quantidadeEstoque >>> 32));
		result = prime * result + (int) (valorVenda ^ (valorVenda >>> 32));
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
		Estoque other = (Estoque) obj;
		if (idProduto != other.idProduto)
			return false;
		if (quantidadeEstoque != other.quantidadeEstoque)
			return false;
		if (valorVenda != other.valorVenda)
			return false;
		return true;
	}

	
}