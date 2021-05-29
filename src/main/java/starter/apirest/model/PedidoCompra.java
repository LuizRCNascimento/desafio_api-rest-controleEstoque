package starter.apirest.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class PedidoCompra {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@OneToOne
	private Fornecedor fornecedor;
	
	@OneToMany (mappedBy = "pedidoCompra")
	private List<Compra> compra;
	
	public PedidoCompra() {
	}

	public PedidoCompra(long idFornecedor, long id) {
		super();
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	
	
}
