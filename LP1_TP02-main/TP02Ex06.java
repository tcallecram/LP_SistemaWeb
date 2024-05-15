/*
 * 6. Armazenar seis nomes em uma matriz de ordem 2x3. Apresentar os nomes na tela.
 *
 *	Armando Righi
 *	Marcella Tavares
 *	Victoria Andraus
 *
 */

import java.util.Scanner;

public class TP02Ex06 {
    public static void main (String[] args){
    Scanner teclado = new Scanner(System.in);
    
    String m[][] = new String [2][3];
    int i, j = 0;
    
    System.out.println("Digite seis nomes: ");
    
    for(i=0; i<2; i++){
        for(j=0; j<3; j++){
            m[i][j] = teclado.next();
        }
    }
    
    for(i=0; i<2; i++){
        for(j=0; j<3; j++){
            System.out.print(m[i][j] + " ");
        }
        System.out.println("");
    }
    
    }
}