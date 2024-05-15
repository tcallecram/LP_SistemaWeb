/*
 * 8. Entrar via teclado com doze valores e armazená-los em uma matriz de ordem 3x4. Após a
 *	digitação dos valores solicitar uma constante multiplicativa, que deverá multiplicar cada
 *	valor matriz e armazenar o resultado em outra matriz de mesma ordem, nas posições
 * 	correspondentes. Exibir as matrizes na tela, sob a forma matricial, ou seja, linhas por
 *	colunas.
 *
 *	Armando Righi
 *	Marcella Tavares
 *	Victoria Andraus
 *
 */

import java.util.Scanner;

public class TP02Ex08 {
    public static void main (String[] args){
    Scanner teclado = new Scanner(System.in);
    
    int matriz[][] = new int [3][4];
    int i, j = 0;
    int m;
    
    System.out.println("Digite doze valores: ");
    
    for(i=0; i<3; i++){
        for(j=0; j<4; j++){
            matriz[i][j] = teclado.nextInt();
            
        }
    }
   
    System.out.println("Digite uma constante para multiplicar a matriz: ");
    m = teclado.nextInt();
    
    for(i=0; i<3; i++){
        for(j=0; j<4; j++){
            System.out.print(matriz[i][j]*m + " ");
        }
        System.out.println("");
    }
    }
}