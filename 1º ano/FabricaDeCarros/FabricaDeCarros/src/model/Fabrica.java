package model;
import java.util.ArrayList;

import view.Visualizacao;

public class Fabrica { 
	
	private static ArrayList<Carro> listaDeCarros = new ArrayList<Carro>();
	
	public static ArrayList<Carro> getListaDeCarros() {
		return listaDeCarros;
	}

	public void setListaDeCarros(ArrayList<Carro> listaDeCarros) {
		Fabrica.listaDeCarros = listaDeCarros;
	}
	
	// inserir um novo carro no vetor
	public static void fabricarCarro() {
		Carro carro = new Carro();
		String modelo = Visualizacao.solicitaModelo();
		String cor = Visualizacao.solicitaCor();
		String ano = Visualizacao.solicitaAno();
		
		carro.novoCarro(modelo, cor, ano);
		listaDeCarros.add(carro);
	}
	
	public static void venderCarro() {
		
		int index = Visualizacao.removerCarro(listaDeCarros);
		listaDeCarros.remove(index);
	}
	
	public static void geraInfoCarro() {
		String informacoes = "";
		for(Carro carro:listaDeCarros){
			informacoes+= "\nModelo: "+carro.getModelo()+"\nCor: "+carro.getCor()+"\nAno: "+carro.getAno();
		}
		
		Visualizacao.mostrarInformacoes(informacoes);

	}
}
