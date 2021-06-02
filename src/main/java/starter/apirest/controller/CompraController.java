package starter.apirest.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import starter.apirest.model.Compra;
import starter.apirest.model.PedidoCompra;
import starter.apirest.model.Status;
import starter.apirest.repository.CompraRepository;
import starter.apirest.repository.PedidoCompraRepository;
import starter.apirest.service.AjusteInventarioService;

@RestController
@RequestMapping ("/pedido")
public class CompraController {

	@Autowired
	private AjusteInventarioService inventario;
	
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
		PedidoCompra pedido = pr.findById(id);
		if (pedido==null) {
			System.out.println("pedido inexistente");
			return ResponseEntity.notFound().build();
		}
		cr.save(compra);
		return ResponseEntity.ok(compra);
	}
	
	//Aprovação de pedido
	@PutMapping ("/{id}")
	public ResponseEntity<?> aprovarPedido (@PathVariable long id, @RequestBody PedidoCompra pedidoBody) {
		PedidoCompra pedido = pr.findByIdAndStatus(id,Status.Aberto);
		if (pedido==null) {
			System.out.println("pedido inexistente");
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		if (pedidoBody.getStatus().toString() == "Aprovado") {
			inventario.ajustarInventario(id);
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("Pedido "+pedidoBody.getStatus()+" com Sucesso!");
	}
	
}
