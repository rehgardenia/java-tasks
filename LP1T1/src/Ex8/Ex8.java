package Ex8;

import java.util.Scanner;

public class Ex8 {
    /*
    @author: Giovanna Ferreira e Renata Gardenia 
    @question: Sabendo que uma milha marítima equivale a um mil, oitocentos e cinquenta e
        dois metros e que um quilômetro possui mil metros, fazer um programa para
        converter milhas marítimas em quilômetros.
*/
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("--- Exercicio 8 ---");
        System.out.print("Digite o valor em milhas maritimas: ");
        double milhas = sc.nextDouble();

        double metros = milhas * 1852;
        double km = metros / 1000;

        System.out.println("Valor em km: " + km);

        sc.close();
    }
}