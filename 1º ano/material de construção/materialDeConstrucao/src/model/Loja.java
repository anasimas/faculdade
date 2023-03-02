package model;

import java.text.NumberFormat;
import java.util.ArrayList;
import view.*;

public class Loja {

	private ArrayList<Produto> estoque = new ArrayList<Produto>(); // adicionar o "= new ArrayList" � equivalente �
																	// inicializar uma vari�vel. � necess�rio para o
																	// array n�o ser uma refer�ncia nula
	private ArrayList<Produto> listaDeProdutosCadastrados = new ArrayList<Produto>();
	
	private ArrayList<Cupom> vendas = new ArrayList<Cupom>();

	// ------------------------------- getters e setters -------------------------------//

	public ArrayList<Produto> getEstoque() {
		return estoque;
	}

	public void setEstoque(ArrayList<Produto> estoque) {
		this.estoque = estoque;
	}

	public ArrayList<Produto> getListaDeProdutosCadastrados() {
		return listaDeProdutosCadastrados;
	}

	public void setListaDeProdutosCadastrados(ArrayList<Produto> listaDeProdutosCadastrados) {
		this.listaDeProdutosCadastrados = listaDeProdutosCadastrados;
	}

	public ArrayList<Cupom> getVendas() {
		return vendas;
	}

	public void setVendas(ArrayList<Cupom> vendas) {
		this.vendas = vendas;
	}

	// ------------------------------- fim getters e setters-------------------------------//

	public void novoProduto(Produto produto) {
		listaDeProdutosCadastrados.add(produto);
		estoque.add(produto);
	}

	public void entradaDeEstoque(String codigoDoProdutoEntrada, int quantidadeAdicionada) {
			Produto produto = this.validacaoProdutoExistente(codigoDoProdutoEntrada);
			
			if(produto != null) {
				produto.setQuantidade(produto.getQuantidade() + quantidadeAdicionada);
			}else{
				View.msgProdutoNaoEncontradoEstoque(this, codigoDoProdutoEntrada, quantidadeAdicionada);
			}
	}
	
	public Produto validacaoProdutoExistente(String codigoDoProdutoEntrada){
		Produto produtoRetornado = null;
		
		for (Produto produto : this.estoque) {
			if (produto.getCodigo().equals(codigoDoProdutoEntrada)) {
				produtoRetornado = produto;
			}
		}
		
		return produtoRetornado;
	}

	public void buscarEstoque(String codigoDoProduto) {
		Produto produto = this.validacaoProdutoExistente(codigoDoProduto);
		
		if(produto != null) {
			View.msgResultadoBuscaEstoque(produto.getQuantidade(), produto.getDescricao());
		}else{
			View.msgProdutoNaoEncontradoEstoque(this, codigoDoProduto, 0);
		}
	}
	
	public void vender(String codigoProdutoVendido, int quantidadeVendida) {
		Produto produto = this.validacaoProdutoExistente(codigoProdutoVendido);
		
		if(produto.getQuantidade() == 0 || (produto.getQuantidade() - quantidadeVendida) <= 0) {
			View.msgErroSemEstoque();
		}
		
		if(produto.getCodigo() == codigoProdutoVendido) {
			produto.setQuantidade(produto.getQuantidade() - quantidadeVendida);
			double valorVenda = (produto.getPreco() * quantidadeVendida);
			
			Cupom cupomNovo = new Cupom();
			
			cupomNovo.setCodigoProduto(codigoProdutoVendido);
			cupomNovo.setQuantidadeVendida(quantidadeVendida);
			cupomNovo.setValorVenda(valorVenda);
			
			vendas.add(cupomNovo);
			} else {
				View.msgProdutoNaoEncontradoEstoque(this, codigoProdutoVendido, 0);
			}
		
		}
	
	public String verCupons() {
		
		String totalDeCupons = "Vendas: ";
		double vendaTotal = 0;
		
		for(Cupom cupons : vendas) {
			vendaTotal += cupons.getValorVenda();
			totalDeCupons += "\n Produto: "+cupons.getCodigoProduto()+"\n Quantidade: "+cupons.getQuantidadeVendida()+"\n Valor da venda: "+cupons.getValorVenda();
		}
		
		String stringValorVenda = NumberFormat.getCurrencyInstance().format(vendaTotal);
		totalDeCupons += "\n Total de vendas: "+ vendaTotal;
		
		return totalDeCupons;
	}
	
	public String listarProdutosCadastrados(){
		String lista = "Produtos cadastrados: ";
		for (Produto produto : listaDeProdutosCadastrados) {
			// pre�o, descri��o, qtd, codigo
			String valorDoProduto = NumberFormat.getCurrencyInstance().format(produto.getPreco());
			lista += "\nDescri��o: " + produto.getDescricao() + "\nC�digo: " + produto.getCodigo() + "\nPre�o: "
					+ valorDoProduto + "\nQuantidade em estoque: " + produto.getQuantidade();
		}
		return lista;
	}
	}
