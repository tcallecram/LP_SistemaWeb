/*
 * 2. Entrar via teclado com dez valores positivos. Consistir a digitação e enviar 	mensagem de
 *	erro, se necessário. Após a digitação, exibir:
 *	a. O maior valor;
 *	b. A soma dos valores;
 *	c. A média aritmética dos valores.
 *
 *	Armando Righi
 *	Marcella Tavares
 *	Victoria Andraus
 */


import java.util.Scanner;

public class TP02Ex02 {
    public static void main (String[] args){
    Scanner teclado = new Scanner(System.in);
    
    int[] numeros = new int[11];          
    int maior = 0;
    int soma = 0;
    int media;
    
    System.out.println("Digite dez números positivos e inteiro: ");
    
   
    for (int i=1; i<11; i++){
        
    numeros[i] = teclado.nextInt(); 
    
        if(numeros[i] < 1){
        System.out.println("Digite um valor positivo e inteiro. ");
        i--;
        }
        
        else{
            if(numeros[i] > maior){
            maior = numeros[i];
            }
        }
        
    soma = soma + numeros[i];
    
    }
    
    System.out.println("Maior número: " + maior);
    System.out.println("A média é igual a: " + soma/10);
    }   
}