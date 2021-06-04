package starter.apirest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import starter.apirest.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

	Cliente findById(long id);
	
	Cliente findByUsuarioId (long usuarioId);

	List<Cliente> findByUsuarioId_Username (String username); // Listar todos os clientes por usuario logado

	Cliente findByIdAndUsuarioId_Username (long idCliente, String username); //Validar se o usuário logado poderá acessar os dados do Cliente
}