package starter.apirest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import starter.apirest.model.Venda;


public interface VendaRepository extends JpaRepository<Venda, Long> {

	Venda findByIdRequisicao (long id); //filtrar uma requisicao
	
	List<Venda> findByPedidoVendaIdOrderByIdRequisicaoAsc (long pedidoVendaId); //Lista de itens do pedido de Venda em ordem crescente
	
	List<Venda> findByPedidoVendaIdAndAtivoTrue (long pedidoVendaId); //Lista de itens do pedido de Venda em ordem crescente
}
