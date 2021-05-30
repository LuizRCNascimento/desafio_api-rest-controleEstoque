package starter.apirest.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import starter.apirest.model.Estoque;
import starter.apirest.repository.EstoqueRepository;

@RestController
@RequestMapping ("/estoque")
public class EstoqueController {

	@Autowired
	private EstoqueRepository er;
	
	@GetMapping
	public List<Estoque> listar() {
		return er.findAll();
	}
	
//	@PostMapping
//	public ResponseEntity<Estoque> salvarEstoque(@Valid @RequestBody Estoque estoque){
//		er.save(estoque);
//		return ResponseEntity.ok(estoque);
//	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Estoque> pesquisaPorId(@PathVariable long id) {
		Estoque estoque = er.findById(id);
		return estoque !=null ? ResponseEntity.ok(estoque) : ResponseEntity.notFound().build();
	}
//	@DeleteMapping("/{id}")
//	public void delete(@PathVariable long id) {
//		er.deleteById(id);
//	}	
	
	@PutMapping("/{id}")
	public ResponseEntity<?> atualizarEstoque(@PathVariable(value = "id") long id, @RequestBody Estoque estoque) {
		System.out.println("Entrou no UpdatedEstoque: ");
		Estoque updatedEstoque = er.findById(id);
		System.out.println("UpdatedEstoque: "+updatedEstoque);
		BeanUtils.copyProperties(estoque,updatedEstoque,"id");
		er.save(updatedEstoque);
		return ResponseEntity.ok(updatedEstoque);
	}
	
	
}
