import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class App {
    public static void main(String[] args) throws Exception {
        StringBuilder resultado = new StringBuilder();

        // --- Exercício 03 ---

        // p1: construtor com parâmetros
        ConsultaAgendada p1 = new ConsultaAgendada(14, 30, 0, 15, 6, 2025, "João Silva", "Dr. Carlos");
        String bloco1 = exibir("p1", p1);
        System.out.print(bloco1);
        resultado.append(bloco1);

        // p2: construtor com digitação
        System.out.println("\n--- Informe os dados de p2 ---");
        ConsultaAgendada p2 = new ConsultaAgendada();
        String bloco2 = exibir("p2", p2);
        System.out.print(bloco2);
        resultado.append(bloco2);

        // Alterar p1 via setters de digitação
        System.out.println("\n--- Altere os dados de p1 ---");
        p1.setData();
        p1.setHora();
        while (System.in.read() != '\n'); // descarta o \r\n residual do último nextInt() de Hora
        p1.setNomePaciente();
        p1.setNomeMedico();

        String bloco3 = exibir("p1 (atualizado)", p1);
        System.out.print(bloco3);
        resultado.append(bloco3);

        String qtd = "Total de consultas agendadas: " + p1.getAmostra() + "\n";
        System.out.print(qtd);
        resultado.append(qtd);

        // --- Exercício 04 ---
        try (PrintWriter pw = new PrintWriter(new FileWriter("resultado.txt"))) {
            pw.print(resultado.toString());
        } catch (IOException e) {
            System.out.println("Erro ao salvar arquivo: " + e.getMessage());
        }
        System.out.println("Resultado salvo em resultado.txt");
    }

    static String exibir(String label, ConsultaAgendada c) {
        return "\n--- " + label + " ---\n" +
               "Paciente : " + c.getNomePaciente() + "\n" +
               "Medico   : " + c.getNomeMedico() + "\n" +
               "Data     : " + c.getData() + "\n" +
               "Hora     : " + c.getHora() + "\n";
    }
}
