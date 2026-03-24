package Ex2;

import java.util.Scanner;

public class Ex2 {
    /*
    @author: Giovanna Ferreira e Renata Gardenia 
    @question: 2. Calcular e exibir a área de um quadrado, a partir do valor de sua aresta que será digitado.
  */

    public static void main(String[] args) throws Exception {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("--- Exercicio 2 ---");
        // entrar com a Aresta

        System.out.println("Valor da aresta: ");
        double aresta = sc.nextDouble();

        // Calcular área
        double area = aresta * aresta;

        System.out.println("Area: " + area);
        sc.close();
    }
}