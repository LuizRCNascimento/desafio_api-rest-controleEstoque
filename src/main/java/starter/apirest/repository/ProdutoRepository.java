package starter.apirest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import starter.apirest.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	Produto findById(long id);
	
	List<Produto> findByOrderByNomeAsc();	//Lista de produtos em ordem crescente de nome
	
	List<Produto> findByOrderByNomeDesc();	//Lista de produtos em ordem decrescente de nome

	Produto findByNome(String nome);	//Busca de produto por nome
}
