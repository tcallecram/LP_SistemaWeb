/**
 * 3. Entrar via teclado com “N” valores quaisquer. O valor “N” (que representa a quantidade de
 *  	números) será digitado, deverá ser positivo, porém menor que vinte. Caso a quantidade não
 *	satisfaça a restrição, enviar mensagem de erro e solicitar o valor novamente. Após a
 *	digitação dos “N” valores, exibir:
 *	a. O maior valor;
 *	b. O menor valor;
 *	c. A soma dos valores;
 *	d. A média aritmética dos valores;
 *	e. A porcentagem de valores que são positivos;
 *	f. A porcentagem de valores negativos;
 *	Após exibir os dados, perguntar ao usuário de deseja ou não uma nova execução do
 *	programa. Consistir a resposta no sentido de aceitar somente “S” ou “N” e encerrar o
 *	programa em função dessa resposta.
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


public class TP02Ex03 {
    
    public static void main(String[] args) {
        Valores p1 = new Valores();
        p1.Contas();
    }
    
}

class Valores{
    
    int[] vals = new int[20];
    int escolha;
    int maior = 0, menor = 0, soma = 0; 
    double pos = 0, neg = 0, qtd = 0, med;
    int cont = 0;
    
    public void Contas() {
        Scanner teclado = new Scanner(System.in);
        
        do {
            System.out.println("Digite um número: ");
            vals[cont] = teclado.nextInt(); 
            
            if (maior < vals[cont]) {
                maior = vals[cont];
            }
            if (menor > vals[cont]) {
                menor = vals[cont];
            }
            
            soma += vals[cont];
            
            qtd++;
            
            if (vals[cont] >= 0) {
                pos++;
            }
            if (vals[cont] < 0) {
                neg++;
            }
            cont++;
            
            System.out.println("Deseja continuar? (0 = não; 1 = sim)"); 
            escolha = teclado.nextInt();
            
            
            if (cont >= 20) {
                System.out.println("Números demais!");
		    System.out.println("");	
                escolha = 0;
            }
            
        } while(escolha != 0);
        
        med = soma/qtd;
        neg = neg/qtd;
        pos = pos/qtd;
        
        System.out.println("Maior " + maior);  
        System.out.println("Menor " + menor);  
        System.out.println("Soma " + soma);  
        System.out.println("Media " + med);  
        System.out.println("Positivos " + pos);  
        System.out.println("Negativos " + neg);
        
    }
}


