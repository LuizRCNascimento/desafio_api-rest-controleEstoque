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
	private long idRequisição;

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

	//Getters & Setters




	public long getValorCompra() {
		return valorCompra;
	}

	public void setValorCompra(long valorCompra) {
		this.valorCompra = valorCompra;
	}

	public long getQuantidadeCompra() {
		return quantidadeCompra;
	}

	public void setQuantidadeCompra(long quantidadeCompra) {
		this.quantidadeCompra = quantidadeCompra;
	}

//	public Fornecedor getFornecedor() {
//		return fornecedor;
//	}
//
//	public void setFornecedor(Fornecedor fornecedor) {
//		this.fornecedor = fornecedor;
//	}
//
//	public List<Produto> getProdutos() {
//		return produtos;
//	}
//
//	public void setProdutos(List<Produto> produtos) {
//		this.produtos = produtos;
//	}
//
//	public Estoque getEstoque() {
//		return estoque;
//	}
//
//	public void setEstoque(Estoque estoque) {
//		this.estoque = estoque;
//	}
	
	
}
