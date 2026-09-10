package Ex14;
import java.util.Scanner;

public class Ex14 {
    /*
    @author: Giovanna Ferreira e Renata Gardenia 
    @question:  Calcular e exibir o volume livre de um ambiente que contém uma esfera de raio
                “r” inscrita em um cubo perfeito de aresta “a”. Os valores de “r “ e “a” serão digitados.

  */
        public static void main(String[] args) throws Exception {
            System.out.println("--- Exercicio 14 ---");
        // Variaveis
        double a, r;
        // Inicializar Scanner
        Scanner scan = new Scanner(System.in);
        // Entrada
        System.out.print("Raio: ");
        r = scan.nextDouble();
        System.out.print("Aresta: ");
        a = scan.nextDouble();
        // Calculo Volume
        double volumeLivre = (a * a * a) - ((4.0 / 3) * Math.PI * r * r * r);
        // Saida
        System.out.printf("Volume Livre: %.2f \n", volumeLivre);
        scan.close();
    }
}
