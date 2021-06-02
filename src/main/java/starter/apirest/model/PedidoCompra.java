package starter.apirest.model;

import java.time.Instant;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

import starter.apirest.security.model.DAOUser;

@Entity
public class PedidoCompra {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@OneToOne
	private Fornecedor fornecedor;
	
	@CreatedBy
	@OneToOne
	private DAOUser daoUser;  
	
	@OneToMany (mappedBy = "pedidoCompra")
	private List<Compra> compra;
	
    @Enumerated(EnumType.STRING)
	private Status status;
    
    @CreatedDate
    private Instant createdDate;
	
	//Constructor
	public PedidoCompra() {
		this.setStatus(Status.Aberto);
	}

	public PedidoCompra(Fornecedor fornecedor, DAOUser daoUser, List<Compra> compra) {
		super();
		this.fornecedor = fornecedor;
		this.daoUser = daoUser;
		this.compra = compra;
		this.setStatus(Status.Aberto);
	}

	//Getters and Setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public List<Compra> getCompra() {
		return compra;
	}

	public void setCompra(List<Compra> compra) {
		this.compra = compra;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((compra == null) ? 0 : compra.hashCode());
		result = prime * result + ((fornecedor == null) ? 0 : fornecedor.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
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
		PedidoCompra other = (PedidoCompra) obj;
		if (compra == null) {
			if (other.compra != null)
				return false;
		} else if (!compra.equals(other.compra))
			return false;
		if (fornecedor == null) {
			if (other.fornecedor != null)
				return false;
		} else if (!fornecedor.equals(other.fornecedor))
			return false;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PedidoCompra [id=" + id + ", fornecedor=" + fornecedor + ", compra=" + compra + "]";
	}
	
}
