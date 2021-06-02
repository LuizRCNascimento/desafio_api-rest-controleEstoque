package starter.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import starter.apirest.model.PedidoVenda;

public interface PedidoVendaRepository extends JpaRepository<PedidoVenda, Long> {


//	PedidoCompra findById (long id);
//
//	PedidoCompra findByIdAndStatus (long id, Status status); // Busca de pedido aberto por {id}
//
//	PedidoCompra findByStatus (Status status); // Consulta de pedidos abertos
//	
//	List<PedidoCompra> findAllByDaoUserId (long idUsuario); //My orders

	
}
