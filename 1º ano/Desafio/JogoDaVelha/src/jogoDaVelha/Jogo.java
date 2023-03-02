package jogoDaVelha;

import javax.swing.JOptionPane;

public class Jogo {

	public static void main(String[] args) {

		String[][] matrizJogo = new String[3][3];
		String simbolos[] = { "X", "O" };
		int tipoDoJogadorInt = 0;
		String tipoDoJogadorChar = "";
		String vitoria = "";
		boolean fimDeJogo = false;

		for (int i = 0; i < 3; i++) {
			for (int a = 0; a < 3; a++) { // Apenas pra colocar o espaço vazio nas matrizes
				matrizJogo[i][a] = " ";
			}
		}

		tipoDoJogadorInt = JOptionPane.showOptionDialog(null, "Qual o simbolo do primeiro jogador?", "Símbolo",
				JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, simbolos, null);

		if (tipoDoJogadorInt == 0) { // Optei por essa forma para não precisar pegar a entrada do dado e converter // para
			tipoDoJogadorChar = "X"; // toUpperCase e não precisar validar se o usuário estava usando X e O
		} else {
			tipoDoJogadorChar = "O";
		}

		for (int i = 0; i < 3; i++) {
			for (int a = 0; a < 3; a++) {
				if(vitoria == "") {
					vitoria = selecionarPosicao(tipoDoJogadorChar, matrizJogo);
				} else {
					fimDeJogo = true;
				}

				if (tipoDoJogadorChar == "X") {
					tipoDoJogadorChar = "O";
				} else {
					tipoDoJogadorChar = "X";
				}
			}
		}

		if (fimDeJogo == true) {
			JOptionPane.showMessageDialog(null, "Vitoria de: " + (vitoria));
		} else {
			if( vitoria != "" ) {
				JOptionPane.showMessageDialog(null, "Vitoria de: " + (vitoria));
			} else {
				JOptionPane.showMessageDialog(null, "Velha");
			}
		}
	}

	public static String selecionarPosicao(String tipoDoJogadorChar, String matrizJogo[][]) {

		String vitoria = "";
		boolean posOcupada = false;
		int linha = 0;
		int coluna = 0;

		do {
			do {
				linha = Integer
						.parseInt(JOptionPane.showInputDialog(null, "Selecione uma linha de 1 a 3 válida para marcar: ",
								"Jogador " + (tipoDoJogadorChar), JOptionPane.INFORMATION_MESSAGE));
			} while (linha < 1 || linha > 3);

			do {
				coluna = Integer.parseInt(
						JOptionPane.showInputDialog(null, "Selecione uma coluna de 1 a 3 válida para marcar: ",
								"Jogador " + (tipoDoJogadorChar), JOptionPane.INFORMATION_MESSAGE));
			} while (coluna < 1 || coluna > 3);

			if (matrizJogo[linha - 1][coluna - 1] != " ") {
				JOptionPane.showMessageDialog(null, "Posição ocupada");
				mostraJogo(matrizJogo, tipoDoJogadorChar);
			} else {
				matrizJogo[linha - 1][coluna - 1] = tipoDoJogadorChar;
				posOcupada = true;
			}
		} while (posOcupada == false);
		
		if(vitoria == "") {	 // deixei em dois ifs porque são comparações diferentes, e caso ficasse no else, ele não validava a linha 3
			vitoria = verificaVitoria(tipoDoJogadorChar, matrizJogo, 0, 1, 2);
		}
		
		if (vitoria == ""){
			vitoria = verificaVitoria(tipoDoJogadorChar, matrizJogo, 2, 1, 0);
		} 
		
		mostraJogo(matrizJogo, tipoDoJogadorChar);

		return vitoria;

	}

	public static void mostraJogo(String matrizJogo[][], String tipoDoJogadorChar) {

		// concatena a matriz com as barrinhas para fazer o formato # e depois uma
		// quebra de linha
		// pra formar o desenho de matriz

		String jogoConcatenado = "";

		for (int i = 0; i < 3; i++) {
			for (int z = 0; z < 3; z++) {
				if (matrizJogo[i][z] == " ") { // esse if é apenas pra deixar os quadradinhos do mesmo tamanho, caso
												// esteja ocupado, tem menos espaço depois da barra
					jogoConcatenado += (" |   " + matrizJogo[i][z] + "   | ");
				} else {
					jogoConcatenado += (" |  " + matrizJogo[i][z] + "  | ");
				}
			}
			jogoConcatenado += "\n";
		}

		JOptionPane.showMessageDialog(null, jogoConcatenado, "Jogador da Vez: " + (tipoDoJogadorChar),
				JOptionPane.QUESTION_MESSAGE);

	}
	
	public static String verificaVitoria(String tipoDoJogadorChar, String matrizJogo[][], int x, int y, int z) { 
		
		String simbVitoria = "";

		if (matrizJogo[x][x] == tipoDoJogadorChar && matrizJogo[y][x] == tipoDoJogadorChar && matrizJogo[z][x] == tipoDoJogadorChar) {
			simbVitoria = tipoDoJogadorChar;
		} else if (matrizJogo[x][x] == tipoDoJogadorChar && matrizJogo[y][y] == tipoDoJogadorChar && matrizJogo[z][z] == tipoDoJogadorChar) {
			simbVitoria = tipoDoJogadorChar;
		} else if (matrizJogo[x][x] == tipoDoJogadorChar && matrizJogo[x][y] == tipoDoJogadorChar && matrizJogo[x][z] == tipoDoJogadorChar) {
			simbVitoria = tipoDoJogadorChar;
		} else if (matrizJogo[x][z] == tipoDoJogadorChar && matrizJogo[y][y] == tipoDoJogadorChar && matrizJogo[z][x] == tipoDoJogadorChar) {
			simbVitoria = tipoDoJogadorChar;
		} else if (matrizJogo[x][y] == tipoDoJogadorChar && matrizJogo[y][y] == tipoDoJogadorChar && matrizJogo[z][y] == tipoDoJogadorChar) {
			simbVitoria = tipoDoJogadorChar;
		} else if (matrizJogo[y][x] == tipoDoJogadorChar && matrizJogo[y][y] == tipoDoJogadorChar && matrizJogo[y][z] == tipoDoJogadorChar) {
			simbVitoria = tipoDoJogadorChar;
		} else {
			simbVitoria = "";
		}

		return simbVitoria;
	}

}
