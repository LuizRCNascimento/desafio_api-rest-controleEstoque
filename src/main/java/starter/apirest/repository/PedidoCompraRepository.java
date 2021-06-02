package starter.apirest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import starter.apirest.model.PedidoCompra;
import starter.apirest.model.Status;

public interface PedidoCompraRepository extends JpaRepository<PedidoCompra, Long> {

	PedidoCompra findById (long id);

	PedidoCompra findByIdAndStatus (long id, Status status); // Busca de pedido aberto por {id}

	PedidoCompra findByStatus (Status status); // Consulta de pedidos abertos
	
	List<PedidoCompra> findAllByDaoUserId (long idUsuario); //My orders
	
}
