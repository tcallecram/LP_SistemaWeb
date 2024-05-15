/*
 * 4. Armazenar seis valores em uma matriz de ordem 2x3. Apresentar os valores na tela.
 *
 *	Armando Righi
 *	Marcella Tavares
 *	Victoria Andraus
 */

import java.util.Scanner;

public class TP02Ex04 {
    public static void main (String[] args){
    Scanner teclado = new Scanner(System.in);
    
    int m[][] = new int[2][3];
    int i, j = 0;
    
    System.out.println("Digite seis números: ");
    
    for(i=0; i<2; i++){
        for(j=0; j<3; j++){
            m[i][j] = teclado.nextInt();
        }
    }
    
    for(i=0; i<2; i++){
        for(j=0; j<3; j++){
            System.out.print(m[i][j]);
        }
        System.out.println("");
    }
    
    }
}