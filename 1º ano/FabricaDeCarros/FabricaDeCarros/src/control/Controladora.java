package control;
import model.Fabrica;
import view.Visualizacao;

public class Controladora {

	public void exibeMenu() {
		int opcao;
		Fabrica fabrica = new Fabrica();
		do {
			opcao = Visualizacao.solicitaOpcao();
			switch(opcao) {
				case 0: // fabricar carro
					Fabrica.fabricarCarro();
				break;
				case 1: // vender carro
					Fabrica.venderCarro();
				break;
				
				case 2: //ver informações dos carros
					Fabrica.geraInfoCarro();
				break;
				
				case 3: //sair
					System.exit(0);
				break;
			}
		} while(opcao!=3);
	}
}
