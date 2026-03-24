package Ex12;
import java.util.Scanner;

public class Ex12 {
    /*
    @author: Giovanna Ferreira e Renata Gardenia 
    @question: Calcular e exibir o volume de um cone a partir dos valores da altura e do raio da
                base que serão digitados.
  */
    
    public static void main(String[] args) throws Exception {
        System.out.println("--- Exercicio 12 ---");
        // Variaveis
        double altura, raioBase, volume;
        // Inicializar Scanner
        Scanner scan = new Scanner(System.in);
        // Entrada
        System.out.print("Raio da Base: ");
        raioBase = scan.nextDouble();
        
        System.out.print("Altura: ");
        altura = scan.nextDouble();
        // Calculo 
        volume = (Math.PI * raioBase * raioBase * altura) / 3;
        // Saida
        System.out.printf("Volume do Cone: %.2f \n", volume);
        scan.close();
    }
}
