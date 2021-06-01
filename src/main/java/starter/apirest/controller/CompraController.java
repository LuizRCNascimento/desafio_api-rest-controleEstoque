package starter.apirest.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import starter.apirest.model.Compra;
import starter.apirest.model.PedidoCompra;
import starter.apirest.repository.CompraRepository;
import starter.apirest.repository.PedidoCompraRepository;

@RestController
@RequestMapping ("/pedido")
public class CompraController {

	@Autowired
	private PedidoCompraRepository pr;
	
	@Autowired
	private CompraRepository cr;
	
	@GetMapping("/{id}")
	public List<PedidoCompra> listar(@PathVariable long id) {
		return pr.findAllByDaoUserId(id);
	}
	
	//Busca requisiçoes por numero de pedido 
	@PostMapping("/{id}")  
	public ResponseEntity<Compra> salvarProduto(@Valid @PathVariable (value = "id")long id, @RequestBody Compra compra){
		System.out.println("Entrou no /{idpedidoCompra}: ");
		System.out.println("compra: "+compra);
		PedidoCompra pedido = pr.findById(id);
		System.out.println("pedido: "+pedido);
		if (pedido==null) {
			System.out.println("pedido inexistente");
			return ResponseEntity.notFound().build();
		}
		cr.save(compra);
		return ResponseEntity.ok(compra);
	}
//	
//	@GetMapping("/{id}")
//	public ResponseEntity<Produto> pesquisaPorId(@PathVariable long id) {
//		Produto produto = pr.findById(id);
//		return produto !=null ? ResponseEntity.ok(produto) : ResponseEntity.notFound().build();
//	}
//	@DeleteMapping("/{id}")
//	public void delete(@PathVariable Long id) {
//		pr.deleteById(id);
//	}	
//	
//	@PutMapping("/{id}")
//	public ResponseEntity<?> atualizarProduto(@PathVariable(value = "id") long id, @RequestBody Produto produto) {
//		Produto updatedProduto = pr.findById(id);
//		BeanUtils.copyProperties(produto,updatedProduto,"id");
//		pr.save(updatedProduto);
//		return ResponseEntity.ok(updatedProduto);
//	}
//	
	
}
