package Ex15;
import java.util.Scanner;

public class Ex15 {
     /*
    @author: Giovanna Ferreira e Renata Gardenia 
    @question:  Entrar via teclado com o valor da cotação do dólar e uma certa quantidade de dólares.
                     Calcular e exibir o valor correspondente em Reais (R$).
  */
    public static void main(String[] args) throws Exception {
        System.out.println("--- Exercicio 15 ---");
        // Variaveis
        double cotacao, qtd;
        // Inicializar o Scanner
        Scanner scan = new Scanner(System.in);
        // Entrada 
        System.out.print("Valor do Dolar: ");
        cotacao = scan.nextDouble();
        System.out.print("Quantidade de Dolares: ");
        qtd = scan.nextDouble();
        // Calculo 
        double valor = cotacao * qtd;
        // Saida
        System.out.printf("Valor do Dolar em reais: R$ %.2f \n", valor);
        scan.close();
    }
}
