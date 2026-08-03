package Ex13;
import java.util.Scanner;

public class Ex13 {
     /*
    @author: Giovanna Ferreira e Renata Gardenia 
    @question: Calcular e exibir a velocidade final (em km/h) de um automóvel, a partir dos valores da velocidade inicial (em m/s),
                 da aceleração (m/s2) e do tempo de percurso (em s) que serão digitados.

  */
    public static void main(String[] args) throws Exception {
        System.out.println("--- Exercicio 13---");
       // Variveis
        double vInicial, acel, tempo;

        // Inicializar
        Scanner scan = new Scanner(System.in);
        
        // Entrada
        System.out.print("Velocidade Inicial: ");
        vInicial = scan.nextDouble();

        System.out.print("Acerelação: ");
        acel = scan.nextDouble();
        
        System.out.print("Tempo: ");
        tempo = scan.nextDouble();

        // Calculo
        double vFinal = (vInicial + acel * tempo) * 3.6;
        
        // Saida
        System.out.printf("Velocidade Final %.2f \n", vFinal);
        scan.close();
    }
}
