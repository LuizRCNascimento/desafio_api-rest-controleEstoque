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
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import starter.apirest.model.Cliente;
import starter.apirest.model.Estoque;
import starter.apirest.repository.ClienteRepository;
import starter.apirest.repository.EstoqueRepository;
import starter.apirest.security.config.JwtTokenUtil;
import starter.apirest.security.dao.UserDao;
import starter.apirest.security.model.DAOUser;

@RestController
@RequestMapping ("/cliente")
public class ClienteController {

	@Autowired
	private ClienteRepository cr;

	@Autowired
	private EstoqueRepository er;	
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private UserDao userDAO;
	
//	@Autowired
//	private JwtRequestFilter jwtRequestFilter;
	
	@GetMapping
	public List<Cliente> listar() {
		return cr.findAll();
	}
	@GetMapping("/user")
	public List<Cliente> listarPorUsuarioLogado(@Valid @RequestHeader("Authorization") String requestTokenHeader){
		String jwtToken = requestTokenHeader.substring(7);
		jwtTokenUtil.getUsernameFromToken(jwtToken);
		return cr.findByUsuarioId_Username(jwtTokenUtil.getUsernameFromToken(jwtToken));
	}
	
	@GetMapping("/produto")
	public List<Estoque> listarProdutosEmEstoque() {
		return er.findByValorVendaGreaterThanAndQuantidadeEstoqueGreaterThan(0,0);
	}
	
	
	
	
	
	
	
	
	@PostMapping
	public ResponseEntity<Cliente> salvarCliente(@Valid @RequestBody Cliente cliente, @RequestHeader("Authorization") String requestTokenHeader) {
		//Obter o usu??rio para gravar na Entidade Cliente
		String jwtToken = requestTokenHeader.substring(7);
		jwtTokenUtil.getUsernameFromToken(jwtToken);
		DAOUser username= userDAO.findByUsername(jwtTokenUtil.getUsernameFromToken(jwtToken));
		cliente.setUsuario(username);

		cr.save(cliente);
		return ResponseEntity.ok(cliente);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> pesquisaPorId(@PathVariable long id) {
		Cliente cliente = cr.findById(id);
		return cliente !=null ? ResponseEntity.ok(cliente) : ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		cr.deleteById(id);
	}	
	
	@PutMapping("/{id}")
	public ResponseEntity<?> atualizarCliente(@Valid @PathVariable(value = "id") long id, @RequestBody Cliente cliente) {
		Cliente updatedCliente = cr.findById(id);
		BeanUtils.copyProperties(cliente,updatedCliente,"id");
		cr.save(updatedCliente);
		return ResponseEntity.ok(updatedCliente);
	}
	
	
}
