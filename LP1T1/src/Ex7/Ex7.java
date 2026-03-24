package Ex7;

import java.util.Scanner;

public class Ex7 {
    /*
    @author: Giovanna Ferreira e Renata Gardenia 
    @question: Calcular e exibir a média geométrica de dois valores quaisquer que serão
digitados.
*/
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("--- Exercicio 7 ---");
        double v1, v2;

        System.out.print("Digite o primeiro valor: ");
        v1 = sc.nextDouble();

        System.out.print("Digite o segundo valor: ");
        v2 = sc.nextDouble();

        double media = Math.sqrt(v1 * v2);

        System.out.println("Media geometrica: " + media);

        sc.close();
    }
}