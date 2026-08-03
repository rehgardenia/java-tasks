package Ex16;
import java.util.Scanner;

public class Ex16 {
    /*
    @author: Giovanna Ferreira e Renata Gardenia 
    @question:  Entrar via teclado com o valor de um ângulo em graus, calcular e exibir as seguintes funções trigonométricas: 
                seno, cosseno, tangente e secante deste ângulo. Lembre-se que uma função trigonométrica trabalha em radianos.

  */

    public static void main(String[] args) throws Exception {
        System.out.println("--- Exercicio 16 ---");
        // Inicializar Scanner
        Scanner scan = new Scanner(System.in);
        // Entrada
        System.out.print("Angulo (graus): ");
        double angulo = scan.nextDouble();        
        // Calculo da Trigonometrica
        double rad = Math.toRadians(angulo);
        double seno = Math.sin(rad);
        double cosseno = Math.cos(rad);
        double tangente = Math.tan(rad);
        double secante = 1 / Math.cos(rad);
        // Saida
        System.out.printf("Seno: R$ %.2f \n", seno);
        System.out.printf("Cosseno: R$ %.2f \n", cosseno);
        System.out.printf("Tangente: R$ %.2f \n", tangente);
        System.out.printf("Secante: R$ %.2f \n", secante);
        scan.close();
    }
}
