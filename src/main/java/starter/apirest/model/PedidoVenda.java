package starter.apirest.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class PedidoVenda {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@OneToOne
	private Cliente cliente;
	
//	@OneToOne
//	private DAOUser daoUser;
	
//	@OneToMany (mappedBy = "pedidoVenda")
//	private List<Venda> venda;

    @Enumerated(EnumType.STRING)
	private Status status;
	
    //Constructor
	public PedidoVenda() {
		super();
		this.setStatus(Status.Aberto);
	}

	//Getters and Setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

//	public DAOUser getDaoUser() {
//		return daoUser;
//	}

//	public void setDaoUser(DAOUser daoUser) {
//		this.daoUser = daoUser;
//	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

//	public List<Venda> getVenda() {
//		return venda;
//	}
//
//	public void setVenda(List<Venda> venda) {
//		this.venda = venda;
//	}
	
	@Override
	public String toString() {
		return "PedidoVenda [id=" + id + ", cliente=" + cliente + ", status=" + status + "]";
	}
	
}
