package starter.apirest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import starter.apirest.model.PedidoVenda;
import starter.apirest.model.Status;


public interface PedidoVendaRepository extends JpaRepository<PedidoVenda, Long> {


	PedidoVenda findById (long id);

	PedidoVenda findByIdAndStatus (long id, Status status); // Busca de pedido aberto por {id}

	List<PedidoVenda> findByStatus (Status status); // Consulta de pedidos abertos
	
	List<PedidoVenda> findByClienteId (long ClienteId); //My orders

	List<PedidoVenda> findByCliente_Usuario_id (long Usuario_id); //My orders por id do usuário
	
}
