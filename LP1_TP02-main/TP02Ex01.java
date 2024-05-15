/*
 * 1. Entrar com dois valores via teclado, onde o segundo valor deverá ser maior que o primeiro.
 *   Caso contrário solicitar novamente apenas o segundo valor.
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

import java.util.Scanner;

class EntradaValores {
    public int n1;
    public int n2;
    
    
    
    public void Verificacao() {
        Scanner teclado = new Scanner(System.in);
        
    do {
            System.out.print("Digite o primeiro valor: ");
            n1 = teclado.nextInt();
            System.out.print("Digite o segundo valor (maior que o primeiro): ");
            n2 = teclado.nextInt();
        } 
        while (n1 > n2);
        System.out.println("O segundo é maior que o primeiro!");
}
     
}

public class TP02Ex01 {
   
    public static void main(String[] args) {
        EntradaValores p1 = new EntradaValores();
        p1.Verificacao();
    }
}


