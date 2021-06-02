package starter.apirest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import starter.apirest.model.Compra;

public interface CompraRepository extends JpaRepository<Compra, Long> {

	Compra findByIdRequisicao (long id); //filtrar uma requisicao
	
	List<Compra> findByPedidoCompraIdOrderByIdRequisicaoAsc (long pedidoCompraId); //Lista de itens do pedido de Compra em ordem crescente
	
	List<Compra> findByPedidoCompraIdAndAtivoTrue (long pedidoCompraId); //Lista de itens do pedido de Compra em ordem crescente
}
