package starter.apirest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import starter.apirest.model.Compra;
import starter.apirest.model.Estoque;
import starter.apirest.repository.CompraRepository;
import starter.apirest.repository.EstoqueRepository;

@Service
public class AjusteInventarioService {
	
	@Autowired
	private CompraRepository cr;
	
	@Autowired
	private EstoqueRepository er;
	
	//Busca requisiçoes por numero de pedido 
	public void ajustarInventario(long idPedido){
		List<Compra> materialComprado = cr.findByPedidoCompraIdAndAtivoTrue(idPedido);
		for (Compra item:materialComprado) {
			Estoque estoque = er.findById(item.getEstoque().getIdProduto());
			long estoqueAjustado = estoque.getQuantidadeEstoque()+item.getQuantidadeCompra();
			estoque.setQuantidadeEstoque(estoqueAjustado);
			er.save(estoque);
			//Alerta para preços de Venda menores que preços de Compra...
			if (estoque.getValorVenda() < item.getValorCompra()) {
				System.out.println("Atenção, o produto "+estoque.getIdProduto()+" - "+estoque.getProduto().getNome()+" está com o valor de venda abaixo do valor comprado");
			}
		}
	}

}
