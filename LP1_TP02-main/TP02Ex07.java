/*
 * 7. Entrar via teclado com doze valores e armazená-los em uma matriz de ordem 3x4. Após a digitação dos valores solicitar uma constante multiplicativa, que deverá                                                                                   	multiplicar cada valor matriz e armazenar o resultado na própria matriz, nas posições correspondentes.
 *
 *	Armando Righi
 *	Marcella Tavares
 *	Victoria Andraus
 */

/**
 *
 * @author aluno
 */

import java.util.Scanner;


public class TP02Ex07 {
	public static void main(String[] args) {
		Matriz m1 = new Matriz();
		m1.FazMatriz();
		m1.MostraMatriz();
		
	}
}	

class Matriz {
	Scanner teclado = new Scanner(System.in);
	int[][] matriz = new int[3][4];
	int constante;
	
	void FazMatriz() {
		for (int y = 0; y < 4; y++) {
			for (int x = 0; x < 3; x++) {
				System.out.println("Digite um número");
				matriz[x][y] = teclado.nextInt();
			}
		}

		System.out.println("Digite ua constante multiplicativa");
		constante = teclado.nextInt();	
		System.out.println("");

		for (int y = 0; y < 4; y++) {
			for (int x = 0; x < 3; x++) {
				matriz[x][y] *= constante;
			}
		}
	}
	
	void MostraMatriz() {
		for (int y = 0; y < 4; y++) {
			for (int x = 0; x < 3; x++) {
				System.out.println(matriz[x][y]);
			}
		}
	}
}
		