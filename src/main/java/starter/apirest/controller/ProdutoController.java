package starter.apirest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import starter.apirest.model.Produto;
import starter.apirest.repository.ProdutoRepository;

@RestController
@RequestMapping ("/api/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoRepository pr;
	
	@GetMapping("/asc")
	public List<Produto> listarOrdemAsc() {
		return pr.findByOrderByNomeAsc();
	}
	
	@GetMapping("/desc")
	public List<Produto> listarOrdemDesc() {
		return pr.findByOrderByNomeDesc();
	}
	
	@GetMapping("/nome/{nome}")
	public Produto buscarNome(@PathVariable ("nome") String nome) {
		return pr.findByNomeStartingWithIgnoreCase(nome);
	}	
	
}