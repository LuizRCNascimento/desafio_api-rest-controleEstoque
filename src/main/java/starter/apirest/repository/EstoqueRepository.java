package starter.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import starter.apirest.model.Estoque;

public interface EstoqueRepository extends JpaRepository<Estoque, Long> {

	Estoque findById (long id);
	
	Estoque findByValorVendaIsNotNull();
	
	Estoque findByValorVendaIsNotNullAndQuantidadeEstoqueGreaterThan(long valorMinino); //condicao de Venda
}
