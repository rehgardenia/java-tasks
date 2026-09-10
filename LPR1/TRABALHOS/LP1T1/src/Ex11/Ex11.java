package Ex11;

import java.util.Scanner;

public class Ex11 {
    /*
    @author: Giovanna Ferreira e Renata Gardenia 
    @question: A partir do diâmetro de um círculo que será digitado, calcular e exibir sua área.
  */
    public static void main(String[] args) throws Exception {
        System.out.println("--- Exercicio 11 ---");
        // Variaveis
        double diametro, area;
        // Inicializar Scanner
        Scanner scan = new Scanner(System.in);
        // Entrada
        System.out.print("Diametro: ");
        diametro = scan.nextFloat();
        // Calculo
        area = Math.PI * Math.sqrt(diametro / 2);
        //Saida
        System.out.printf("Area do Circulo: %.2f \n", area);
        scan.close();
    }
}