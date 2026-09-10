package Ex10;
import java.util.Scanner;

public class Ex10 {
    /*
    @author: Giovanna Ferreira e Renata Gardenia 
    @question: Entrar via teclado com o valor de uma temperatura em graus Celsius, calcular e
                  exibir sua temperatura equivalente em Fahrenheit.
  */
    public static void main(String[] args) throws Exception {
    System.out.println("--- Exercicio 10 ---");
    // Variaveis
    double c, f;
    // Inicializar Scanner
    Scanner scan = new Scanner(System.in);
    // Entrada
    System.out.print("Celsius: ");
    c = scan.nextFloat();
    //Calculo
    f = (c * 1.8) + 32;
    // Saida
    System.out.printf("Fahrenheit: %.2f", f);
    scan.close();
}
}