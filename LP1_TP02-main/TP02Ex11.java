/*
 * 11. Entrar com uma matriz de ordem MxM, onde a ordem também será escolhida pelo usuário,
 *	sendo que no máximo será de ordem 10 e quadrática. Após a digitação dos elementos,
 *	calcular e exibir determinante da matriz.
 *	Armando Righi
 *	Marcella Tavares
 *	Victoria Andraus
 *
 */

/**
 *
 * @author aluno
 */


import java.util.Scanner;

public class TP02Ex11 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Obter a ordem da matriz
        System.out.print("Digite a ordem da matriz (até 10): ");
        int ordem = input.nextInt();

        int[][] matriz = new int[ordem][ordem];

        // Obter os elementos da matriz
        System.out.println("Digite os elementos da matriz:");
        for (int i = 0; i < ordem; i++) {
            for (int j = 0; j < ordem; j++) {
                matriz[i][j] = input.nextInt();
            }
        }

        int determinante = calcularDeterminante(matriz);

        System.out.println("O determinante da matriz é: " + determinante);
    }

    // Método para calcular o determinante
    public static int calcularDeterminante(int[][] matriz) {
        int ordem = matriz.length;

        if (ordem == 1) {
            return matriz[0][0];
        }

        if (ordem == 2) {
            return matriz[0][0] * matriz[1][1] - matriz[0][1] * matriz[1][0];
        }

        int determinante = 0;

        for (int i = 0; i < ordem; i++) {
            int[][] submatriz = new int[ordem - 1][ordem - 1];

            for (int j = 1; j < ordem; j++) {
                for (int k = 0; k < ordem; k++) {
                    if (k < i) {
                        submatriz[j - 1][k] = matriz[j][k];
                    } else if (k > i) {
                        submatriz[j - 1][k - 1] = matriz[j][k];
                    }
                }
            }

            determinante += matriz[0][i] * Math.pow(-1, i) * calcularDeterminante(submatriz);
        }

        return determinante;
    }
}
