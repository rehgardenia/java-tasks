import javax.swing.*;
import java.awt.*;

public class CalculadoraForm extends JFrame {

    private JTextField resultado;
    private double primeiroNumero = 0;
    private String operador = "";
    private boolean novoNumero = true;

    public CalculadoraForm() {
        setTitle("Calculadora");
        setSize(230, 270);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        resultado = new JTextField("0");
        resultado.setHorizontalAlignment(JTextField.RIGHT);
        resultado.setEditable(false);

        add(resultado, BorderLayout.NORTH);

        JPanel painel = new JPanel(new GridLayout(5, 4, 2, 2));

        String[] botoes = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+",
            "C", "", "", ""
        };

        for (String texto : botoes) {
            JButton botao = new JButton(texto);

            if (!texto.isEmpty()) {
                painel.add(botao);
                botao.addActionListener(e -> clicar(texto));
            } else {
                painel.add(new JLabel(""));
            }
        }

        add(painel, BorderLayout.CENTER);
    }

    private void clicar(String texto) {

        if (texto.equals("C")) {
            resultado.setText("0");
            primeiroNumero = 0;
            operador = "";
            novoNumero = true;
            return;
        }

        if (texto.matches("[0-9]")) {
            if (novoNumero || resultado.getText().equals("Erro")) {
                resultado.setText(texto);
                novoNumero = false;
            } else {
                resultado.setText(resultado.getText() + texto);
            }
            return;
        }

        if (texto.equals(".")) {
            if (novoNumero || resultado.getText().equals("Erro")) {
                resultado.setText("0.");
                novoNumero = false;
            } else if (!resultado.getText().contains(".")) {
                resultado.setText(resultado.getText() + ".");
            }
            return;
        }

        if (texto.equals("=")) {
            calcular();
            return;
        }

        try {
            primeiroNumero = Double.parseDouble(resultado.getText());
            operador = texto;
            novoNumero = true;

        } catch (NumberFormatException erro) {
            resultado.setText("Erro");

        } finally {
            // Finaliza a leitura do primeiro número.
        }
    }

    private void calcular() {
        try {
            double segundoNumero =
                Double.parseDouble(resultado.getText());

            double resultadoFinal;

            switch (operador) {
                case "+":
                    resultadoFinal = primeiroNumero + segundoNumero;
                    break;

                case "-":
                    resultadoFinal = primeiroNumero - segundoNumero;
                    break;

                case "*":
                    resultadoFinal = primeiroNumero * segundoNumero;
                    break;

                case "/":
                    if (segundoNumero == 0) {
                        throw new ArithmeticException(
                            "Divisão por zero"
                        );
                    }
                    resultadoFinal = primeiroNumero / segundoNumero;
                    break;

                default:
                    return;
            }

            resultado.setText(
                String.valueOf(resultadoFinal)
            );

        } catch (ArithmeticException | NumberFormatException erro) {
            resultado.setText("Erro");

        } finally {
            operador = "";
            novoNumero = true;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CalculadoraForm janela = new CalculadoraForm();
            janela.setVisible(true);
        });
    }
}