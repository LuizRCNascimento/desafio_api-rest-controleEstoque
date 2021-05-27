package starter.apirest.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import starter.apirest.model.Produto;
import starter.apirest.repository.ProdutoRepository;

@RestController
@RequestMapping ("/produto")
public class ProdutoController {

	@Autowired
	private ProdutoRepository pr;
	
	@GetMapping
	public List<Produto> listar() {
		return pr.findAll();
	}
	
	@PostMapping
	public ResponseEntity<Produto> salvarProduto(@Valid @RequestBody Produto produto){
		pr.save(produto);
		return ResponseEntity.ok(produto);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Produto> pesquisaPorId(@PathVariable long id) {
		Produto produto = pr.findById(id);
		return produto !=null ? ResponseEntity.ok(produto) : ResponseEntity.notFound().build();
	}
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		pr.deleteById(id);
	}	
	
	@PutMapping("/{id}")
	public ResponseEntity<?> atualizarProduto(@PathVariable(value = "id") long id, @RequestBody Produto produto) {
		Produto updatedProduto = pr.findById(id);
		BeanUtils.copyProperties(produto,updatedProduto,"id");
		pr.save(updatedProduto);
		return ResponseEntity.ok(updatedProduto);
	}
	
	
}
