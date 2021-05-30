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

import starter.apirest.model.Fornecedor;
import starter.apirest.repository.FornecedorRepository;

@RestController
@RequestMapping ("/fornecedor")
public class FornecedorController {

	@Autowired
	private FornecedorRepository fr;
	
	@GetMapping
	public List<Fornecedor> listar() {
		return fr.findAll();
	}
	
	@PostMapping
	public ResponseEntity<Fornecedor> salvarFornecedor(@Valid @RequestBody Fornecedor fornecedor){
		fr.save(fornecedor);
		return ResponseEntity.ok(fornecedor);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Fornecedor> pesquisaPorId(@PathVariable long id) {
		Fornecedor fornecedor = fr.findById(id);
		return fornecedor !=null ? ResponseEntity.ok(fornecedor) : ResponseEntity.notFound().build();
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable long id) {
		fr.deleteById(id);
		return ResponseEntity.ok("Fornecedor removido");
	}	
	
	@PutMapping("/{id}")
	public ResponseEntity<Fornecedor> atualizarFornecedor(@Valid @PathVariable(value = "id") long id, @RequestBody Fornecedor fornecedor) {
		Fornecedor updatedFornecedor = fr.findById(id);
		BeanUtils.copyProperties(fornecedor,updatedFornecedor,"id");
		fr.save(updatedFornecedor);
		return ResponseEntity.ok(updatedFornecedor);
	}
}
