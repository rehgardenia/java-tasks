
package lp1t3;

/**
 *
 * @author Renata Gardenia e Giovanna Ferreira
 */
public class LP1T3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("=== Teste 1: Construtor vazio (entrada do usuário) ===");
        Hora h1 = new Hora();

        System.out.println("Hora formato 24h: " + h1.getHora1());
        System.out.println("Hora formato 12h: " + h1.getHora2());
        System.out.println("Total de segundos: " + h1.getSegundos());

        System.out.println("\n=== Teste 2: Construtor com parâmetros ===");
        Hora h2 = new Hora(14, 5, 9);

        System.out.println("Hora formato 24h: " + h2.getHora1());
        System.out.println("Hora formato 12h: " + h2.getHora2());
        System.out.println("Total de segundos: " + h2.getSegundos());

        System.out.println("\n=== Teste 3: Alterando valores com setters ===");
        h2.setHor(10);
        h2.setMin(59);
        h2.setSeg(50);

        System.out.println("Nova hora 24h: " + h2.getHora1());
        System.out.println("Nova hora 12h: " + h2.getHora2());
        System.out.println("Total de segundos: " + h2.getSegundos());
    }
    
}
