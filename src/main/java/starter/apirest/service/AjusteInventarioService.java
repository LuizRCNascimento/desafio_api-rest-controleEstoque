package starter.apirest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import starter.apirest.model.Compra;
import starter.apirest.model.Estoque;
import starter.apirest.model.Venda;
import starter.apirest.repository.CompraRepository;
import starter.apirest.repository.EstoqueRepository;
import starter.apirest.repository.VendaRepository;

@Service
public class AjusteInventarioService {
	
	@Autowired
	private CompraRepository cr;

	@Autowired
	private VendaRepository vr;

//	@Autowired
//	private PedidoVendaRepository pvr;
	
	@Autowired
	private EstoqueRepository er;
	
	//Busca requisiçoes de compra por numero de pedido e ajusta o inventário com base no pedido aprovado
	public void ajustarInventarioCompra(long idPedido){
		List<Compra> materialComprado = cr.findByPedidoCompraIdAndAtivoTrue(idPedido);
		for (Compra item:materialComprado) {
			Estoque estoque = er.findById(item.getEstoque().getIdProduto());
			long estoqueAjustado = estoque.getQuantidadeEstoque()+item.getQuantidadeCompra();
			estoque.setQuantidadeEstoque(estoqueAjustado);
			er.save(estoque);
			//Alerta para preços de Compra estão maiores que os preços de Venda...
			if (estoque.getValorVenda() < item.getValorCompra()) {
				System.out.println("Atenção, o produto "+estoque.getIdProduto()+" - "+estoque.getProduto().getNome()+" está com o valor de venda abaixo do valor comprado");
			}
		}
	}
	
	
	//Busca requisiçoes de Venda por numero de pedido e ajusta o inventário com base no pedido aprovado
	public void ajustarInventarioVenda(long idPedido){
		List<Venda> materialVendido = vr.findByPedidoVendaIdAndAtivoTrue(idPedido);
		for (Venda item:materialVendido) {
			Estoque estoque = er.findById(item.getEstoque().getIdProduto());
			long estoqueAjustado = estoque.getQuantidadeEstoque()-item.getQuantidadeVenda();
//			System.out.println("\nitem.getEstoque().getIdProduto(): "+ item.getEstoque().getIdProduto());
//			System.out.println("estoque.getQuantidadeEstoque(): "+ estoque.getQuantidadeEstoque());
//			System.out.println("estoqueAjustado: "+ estoqueAjustado);
			if  (estoqueAjustado<0) {
				System.out.println("Quantidade não disponível no estoque. Favor revisar o pedido. Item: "+item.getEstoque().getIdProduto());
				return;
			}
		}
		for (Venda item:materialVendido) {
			Estoque estoque = er.findById(item.getEstoque().getIdProduto());
			long estoqueAjustado = estoque.getQuantidadeEstoque()-item.getQuantidadeVenda();
			estoque.setQuantidadeEstoque(estoqueAjustado);
			item.setValorVenda(estoque.getValorVenda()); // Grava o valor vendido
			er.save(estoque);
			vr.save(item);

			}
		return;
	}
}
