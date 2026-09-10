package Ex9;

import java.util.Scanner;

public class Ex9 {
    /*
    @author: Giovanna Ferreira e Renata Gardenia 
    @question:Calcular e exibir a tensão de um determinado circuito eletrônico a partir dos
            valores da resistência e corrente elétrica que serão digitados. Utilize a lei de Ohm.
  */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("--- Exercicio 9 ---");
        double resistencia, corrente;

        System.out.print("Digite a resistencia (ohms): ");
        resistencia = sc.nextDouble();

        System.out.print("Digite a corrente (ampere): ");
        corrente = sc.nextDouble();

        double tensao = resistencia * corrente;

        System.out.println("Tensao do circuito: " + tensao + " volts");

        sc.close();
    }
}