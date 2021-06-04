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
	private long idRequisicao;

	@ManyToOne
	private PedidoVenda pedidoVenda;
	
	private long quantidadeVenda;  
	
	private long valorVenda;  
	
	@OneToOne
	private Estoque estoque;

	private boolean ativo;

	public Venda() {
		this.setAtivo(true);
	}

	public Venda(long idRequisicao, PedidoVenda pedidoVenda, long quantidadeVenda, long valorVenda, Estoque estoque) {
		super();
		this.setAtivo(true);
		this.idRequisicao = idRequisicao;
		this.pedidoVenda = pedidoVenda;
		this.quantidadeVenda = quantidadeVenda;
		this.valorVenda = valorVenda;
		this.estoque = estoque;

	}

	public long getIdRequisicao() {
		return idRequisicao;
	}

	public void setIdRequisicao(long idRequisicao) {
		this.idRequisicao = idRequisicao;
	}

	public PedidoVenda getPedidoVenda() {
		System.out.println("Passou pelo Venda - getPedidoVenda");
		return pedidoVenda;
	}

	public void setPedidoVenda(PedidoVenda pedidoVenda) {
		this.pedidoVenda = pedidoVenda;
		System.out.println("Passou pelo Venda - setPedidoVenda");
	}

	public long getQuantidadeVenda() {
		return quantidadeVenda;
	}

	public void setQuantidadeVenda(long quantidadeVenda) {
		this.quantidadeVenda = quantidadeVenda;
	}

	public long getValorVenda() {
		return valorVenda;
	}

	public void setValorVenda(long valorVenda) {
		this.valorVenda = valorVenda;
	}

	public Estoque getEstoque() {
		return estoque;
	}

	public void setEstoque(Estoque estoque) {
		this.estoque = estoque;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

}
