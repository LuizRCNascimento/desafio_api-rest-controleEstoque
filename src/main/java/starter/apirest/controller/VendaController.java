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
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import starter.apirest.model.Cliente;
import starter.apirest.model.PedidoVenda;
import starter.apirest.model.Status;
import starter.apirest.model.Venda;
import starter.apirest.repository.ClienteRepository;
import starter.apirest.repository.PedidoVendaRepository;
import starter.apirest.repository.VendaRepository;
import starter.apirest.security.config.JwtTokenUtil;
import starter.apirest.service.AjusteInventarioService;

@RestController
@RequestMapping ("/venda")
public class VendaController {

	@Autowired
	private AjusteInventarioService inventario;
	
	@Autowired
	private PedidoVendaRepository pvr;

	@Autowired
	private VendaRepository vr;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private ClienteRepository cr;
	
	@PostMapping 
	public ResponseEntity<?> criarPedidoVenda(@Valid @RequestBody PedidoVenda pedido, @RequestHeader("Authorization") String requestTokenHeader){
		//Validar se o usuário tem acesso ao Cliente ao qual o pedido será criado
		String jwtToken = requestTokenHeader.substring(7);
		String usuario =jwtTokenUtil.getUsernameFromToken(jwtToken);

		Cliente clientePedido = cr.findByIdAndUsuarioId_Username(pedido.getCliente().getId(), usuario);
		if (clientePedido==null) {
			return ResponseEntity.badRequest().body(clientePedido);
		}
		
		pedido.setCliente(clientePedido);
		pvr.save(pedido);
		return ResponseEntity.ok(pedido);
	}
	
	@GetMapping("/{id}")
	@ResponseBody
	public List<PedidoVenda> listar(@PathVariable long id) {
		return pvr.findByCliente_Usuario_id(id);
	}
	
	//Cria requisiçoes por numero de pedido
	@PostMapping("/{id}")  
	public ResponseEntity<Venda> salvarProdutoVenda(@Valid @PathVariable (value = "id")long id, @RequestBody Venda venda){
		PedidoVenda pedido = pvr.findById(id);
		if (pedido==null) {
			System.out.println("Pedido inexistente");
			return ResponseEntity.notFound().build();
		}
		System.out.println(venda);
		venda.setPedidoVenda(pedido);
		vr.save(venda);
		return ResponseEntity.ok(venda);
	}
	
	//Aprovação de pedido de Venda e ajuste de inventario, caso necessario
	@PutMapping ("/{id}")
	public ResponseEntity<?> aprovarPedidoVenda (@PathVariable long id, @RequestBody PedidoVenda pedidoBody) {
		PedidoVenda pedido = pvr.findByIdAndStatus(id,Status.Aberto); //buscar apenas os pedidos abertos
		if (pedido==null) {
			System.out.println("pedido inexistente"+pedidoBody);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		else if (pedidoBody.getStatus().toString() == "Cancelado") {
			pedido.setStatus(pedidoBody.getStatus());
			pvr.save(pedido);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body("Pedido "+pedidoBody.getStatus()+" com Sucesso!");
		}
		else if (pedidoBody.getStatus().toString() == "Aprovado") {
			inventario.ajustarInventarioVenda(id);

				return ResponseEntity.status(HttpStatus.ACCEPTED).body("Pedido "+pedidoBody.getStatus()+" com Sucesso! ");
		}
		//Pedido que necessita de revisão de volumes
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("Quantidade de material em estoque já não se encontra mais disponível para venda.");
			
		
	}
	
}
