package starter.apirest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import starter.apirest.model.Estoque;

public interface EstoqueRepository extends JpaRepository<Estoque, Long> {

	Estoque findById (long id);
	
	List<Estoque> findByValorVendaIsNotNull();
	
	List<Estoque> findByValorVendaGreaterThanAndQuantidadeEstoqueGreaterThan(long valorVenda, long quantidadeEstoque); //condicao de Venda
}
