/*
 * 5. Armazenar seis valores em uma matriz de ordem 3x2. Apresentar os valores na tela.
 *
 *	Armando Righi
 *	Marcella Tavares
 *	Victoria Andraus
 *
 */

/**
 *
 * @author aluno
 */


public class TP02Ex05 {
	public static void main(String[] args) {
		Matriz m1 = new Matriz();
		m1.MostraMatriz();
		
	}
}	

class Matriz {
	int[][] matriz = {{1, 3, 5}, {2, 4, 6}};
	
	void MostraMatriz() {
		for (int y = 0; y < 3; y++) {
			for (int x = 0; x < 2; x++) {
				System.out.print(matriz[x][y]);
				if (x == 0) {
					System.out.print(" - ");
				}
			}
			System.out.println();
		}
	}
}
		