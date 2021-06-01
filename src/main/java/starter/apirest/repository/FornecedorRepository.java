package starter.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import starter.apirest.model.Fornecedor;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Long>{

	Fornecedor findById(long id);

	
}
