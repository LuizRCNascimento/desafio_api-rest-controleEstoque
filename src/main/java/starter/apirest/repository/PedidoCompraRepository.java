package starter.apirest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import starter.apirest.model.PedidoCompra;

public interface PedidoCompraRepository extends JpaRepository<PedidoCompra, Long> {

	PedidoCompra findById (long id);
	
	List<PedidoCompra> findAllByDaoUserId (long idUsuario); //My orders
	
}
