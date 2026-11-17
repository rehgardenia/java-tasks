package LPR2T5;
import javax.swing.*;
import java.awt.*;

public class FramePrincipal extends JFrame {

    private JTextField txtMaximo;
    private JTextField txtPrioridade1;
    private JTextField txtPrioridade2;
    private JButton btnIniciar;
    private JButton btnLimpar;
    private PainelContador painel1;
    private PainelContador painel2;

    public FramePrincipal() {
        setTitle("Trabalho Prático 5");
        setSize(520, 460);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        // Campos de texto e Rótulos
        JLabel lblMax = new JLabel("Máximo:");
        lblMax.setBounds(40, 20, 80, 25);
        add(lblMax);

        txtMaximo = new JTextField("1000");
        txtMaximo.setBounds(125, 20, 130, 25);
        add(txtMaximo);

        JLabel lblPrio1 = new JLabel("Prioridade 1:");
        lblPrio1.setBounds(40, 55, 80, 25);
        add(lblPrio1);

        txtPrioridade1 = new JTextField("1");
        txtPrioridade1.setBounds(125, 55, 130, 25);
        add(txtPrioridade1);

        JLabel lblPrio2 = new JLabel("Prioridade 2:");
        lblPrio2.setBounds(40, 90, 80, 25);
        add(lblPrio2);

        txtPrioridade2 = new JTextField("10");
        txtPrioridade2.setBounds(125, 90, 130, 25);
        add(txtPrioridade2);

        // Chave "}" e observação lateral
        JLabel lblChave = new JLabel("}");
        lblChave.setFont(new Font("Serif", Font.PLAIN, 48));
        lblChave.setBounds(265, 48, 30, 60);
        add(lblChave);

        JLabel lblObs = new JLabel("Número entre 1 e 10");
        lblObs.setBounds(295, 70, 150, 25);
        add(lblObs);

        // Botão Iniciar
        btnIniciar = new JButton("Iniciar");
        btnIniciar.setBounds(215, 130, 80, 28);
        add(btnIniciar);

        // Adicionando os dois Painéis que implementam Runnable
        painel1 = new PainelContador();
        painel1.setLocation(105, 185);
        add(painel1);

        painel2 = new PainelContador();
        painel2.setLocation(350, 185);
        add(painel2);

        // Botão Limpar
        btnLimpar = new JButton("Limpar");
        btnLimpar.setBounds(215, 375, 80, 28);
        add(btnLimpar);

        // Ação do botão Iniciar
        btnIniciar.addActionListener(e -> iniciarContagem());

        // Ação do botão Limpar
        btnLimpar.addActionListener(e -> {
            painel1.limpar();
            painel2.limpar();
        });
    }

    private void iniciarContagem() {
        try {
            int max = Integer.parseInt(txtMaximo.getText().trim());
            int prio1 = Integer.parseInt(txtPrioridade1.getText().trim());
            int prio2 = Integer.parseInt(txtPrioridade2.getText().trim());

            if (prio1 < 1 || prio1 > 10 || prio2 < 1 || prio2 > 10) {
                JOptionPane.showMessageDialog(this, 
                    "A prioridade deve ser um número entre 1 e 10.", 
                    "Aviso", JOptionPane.WARNING_MESSAGE);
                return;
            }

            painel1.preparar(max);
            painel2.preparar(max);

            Thread t1 = new Thread(painel1);
            Thread t2 = new Thread(painel2);

            t1.setPriority(prio1);
            t2.setPriority(prio2);

            t1.start();
            t2.start();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, 
                "Digite apenas números inteiros válidos nos campos!", 
                "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new FramePrincipal().setVisible(true);
        });
    }
}