package Ex5;

import java.util.Scanner;

public class Ex5{
    /*
    @author: Giovanna Ferreira e Renata Gardenia 
    @question: 5. Calcular e exibir o volume de uma esfera a partir do valor de seu diâmetro que
será digitado.
  */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("--- Exercicio 5 ---");
        System.out.print("Diametro da esfera: ");
        double diametro = sc.nextDouble();

        double raio = diametro / 2;
        double volume = (4.0/3.0) * Math.PI * Math.pow(raio, 3);

        System.out.println("Volume da esfera: " + volume);

        sc.close();
    }
}