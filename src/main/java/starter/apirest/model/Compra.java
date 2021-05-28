package starter.apirest.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Compra {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idCompra;
	private long quantidadeCompra;  
	
//	@OneToOne (mappedBy = "id")
//	private Fornecedor fornecedor;
	
//	@OneToMany(fetch = FetchType.EAGER,mappedBy = "id")
//	@JoinColumn
//	private List<Produto> produtos;
	
//	@OneToOne(mappedBy = "idProduto")
//	@JoinColumn
//	private Estoque estoque;

	//Constructors
	public Compra() {
	}

	

	
	//Getters & Setters
	public long getIdCompra() {
		return idCompra;
	}

	public void setIdCompra(long idCompra) {
		this.idCompra = idCompra;
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
