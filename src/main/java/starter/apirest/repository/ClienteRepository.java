package starter.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import starter.apirest.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

	Cliente findById(long id);
}
