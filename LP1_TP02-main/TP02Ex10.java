/*
 *10. Entrar com uma matriz de ordem MxM, onde a ordem também será escolhida pelo usuário,
 *	sendo que no máximo será de ordem 10 e quadrática. Após a digitação dos elementos,calcular e exibir a matriz   ** *    *	inversa. Exibir as matrizes na tela, sob a forma matricial (linhas x
 *	colunas).
 *
 *	Armando Righi
 *	Marcella Tavares
 *	Victoria Andraus
 *
 */

import java.util.Scanner;

public class TP02Ex10 {

    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);  
        
        int x;
        int i, j = 0;
        int k = 0 ;
        int l =0;
        int o, n = 0;
        
        System.out.print("Digite a ordem de uma matriz (até 10): ");
        x = teclado.nextInt();
        
        double [][]m = new double[x][x];
        double [][]mi = new double[x][x];
        double [][]mf = new double[x][x];
        
            while (x > 10 || x < 1){
                System.out.print("Digite uma ordem entre 1 e 10: ");
                x = teclado.nextInt();
            }
                for(i=0; i<x; i++){
                    for(j=0; j<x; j++){
                        System.out.println("Digite um valor na matriz: ");
                        m[i][j] = teclado.nextDouble();
                    }                       
                }
                
                for(k=0; k<x; k++){
                    for(l=0; l<x; l++){
                        
                        if(k == l){
                        
                            mi[k][l] = 1;
                            
                        }
                        else{
                        
                            mi[k][l] = 0;
                        }
                                               
                    }  
                }                               
                
		System.out.println("A matriz identidade: ");
                for(k=0; k<x; k++){
                    for(l=0; l<x; l++){
                        System.out.print(" " + mi[k][l]);
                                               
                    }
                    System.out.println(" ");
                }   
                
                System.out.println(" ");
                
		System.out.println("A matriz identidade dividida pela matriz normal: ");
                for(o=0; o<x; o++){
                    for(n=0; n<x; n++){
                        mf[o][n] = mi[o][n] / m[o][n];
                        System.out.print(" " + mf[o][n]);
                    }
                    System.out.println(" ");
                } 
    }
}