package view;
import model.Carro;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import javax.swing.JComboBox;

public class Visualizacao {
	
	public static int solicitaOpcao() {
		
		String[] opcoes = {"Fabricar carro", "Vender carro", "Ver informações", "Sair"}; // cria a string de menu p/ o jcombobox
		JComboBox<String> menu = new JComboBox<String>(opcoes); //instancia o jcombobox
		JOptionPane.showConfirmDialog(null, menu, "Selecione a opção", JOptionPane.OK_CANCEL_OPTION);
		
		return menu.getSelectedIndex(); //retorna o nº escolhido p/ opção em controladora, para o switch/case
	}
	
	public static String solicitaModelo() {
		
		return JOptionPane.showInputDialog("Informe o modelo do carro");
		
	}
	
	public static String solicitaCor() {
			
			return JOptionPane.showInputDialog("Informe a cor do carro");
			
		}

	public static String solicitaAno() {
		
		return JOptionPane.showInputDialog("Informe o ano do carro");
		
	}
	
	public static int removerCarro(ArrayList<Carro> fabricaDeCarros) {
		
		int qtdCarros = fabricaDeCarros.size();
		String[] descricoesCarros = new String[qtdCarros];
		
		for(int i=0; i<qtdCarros; i++) {
			descricoesCarros[i]=fabricaDeCarros.get(i).getModelo();
		}
		
		String msg = "Escolha o carro a ser vendido";
		JComboBox exibeListaCarros = new JComboBox(descricoesCarros);
		int opcao = JOptionPane.showConfirmDialog(null, exibeListaCarros, msg, JOptionPane.OK_CANCEL_OPTION);
		
		if(opcao == 0) {
			return exibeListaCarros.getSelectedIndex();
		} else {
			return -1;
		}
	}	
	
	public static void mostrarInformacoes(String informacoes) {
		JOptionPane.showMessageDialog(null, informacoes);
	}
}
