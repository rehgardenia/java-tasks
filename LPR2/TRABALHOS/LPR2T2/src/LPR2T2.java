import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class TelaAluno extends JFrame {

    private JTextField txtNome;

    private JButton btnOk;
    private JButton btnLimpar;
    private JButton btnMostrar;
    private JButton btnSair;

    private List<Aluno> alunos;

    public TelaAluno() {

        alunos = new ArrayList<>();

        setTitle("Cadastro de Alunos");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        criarTela();
    }

    private void criarTela() {

        JLabel lblNome = new JLabel("Nome:");

        txtNome = new JTextField(20);

        btnOk = new JButton("OK");
        btnLimpar = new JButton("Limpar");
        btnMostrar = new JButton("Mostrar");
        btnSair = new JButton("Sair");

        JPanel painel = new JPanel();
        painel.setLayout(new GridLayout(5, 1, 5, 5));

        JPanel painelNome = new JPanel();
        painelNome.add(lblNome);
        painelNome.add(txtNome);

        JPanel painelBotoes = new JPanel();

        painelBotoes.add(btnOk);
        painelBotoes.add(btnLimpar);
        painelBotoes.add(btnMostrar);
        painelBotoes.add(btnSair);

        painel.add(painelNome);
        painel.add(painelBotoes);

        add(painel);

        configurarEventos();
    }

    private void configurarEventos() {

        // Botão OK
        btnOk.addActionListener(e -> {

            String nome = txtNome.getText();

            if (nome.isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Digite o nome do aluno."
                );

                return;
            }

            Aluno aluno = new Aluno(nome);

            alunos.add(aluno);

            JOptionPane.showMessageDialog(
                    this,
                    "Aluno cadastrado com sucesso!"
            );

            txtNome.setText("");
        });

        // Botão LIMPAR
        btnLimpar.addActionListener(e -> {

            txtNome.setText("");
        });

        // Botão MOSTRAR
        btnMostrar.addActionListener(e -> mostrarAlunos());

        // Botão SAIR
        btnSair.addActionListener(e -> {

            System.exit(0);
        });
    }

    private void mostrarAlunos() {

        if (alunos.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Nenhum aluno cadastrado."
            );

            return;
        }

        String mensagem = "";

        for (Aluno aluno : alunos) {

            mensagem += "ID: " + aluno.getId() + "\n";
            mensagem += "Nome: " + aluno.getNome() + "\n";
            mensagem += "--------------------------\n";
        }

        JOptionPane.showMessageDialog(
                this,
                mensagem
        );
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            TelaAluno tela = new TelaAluno();

            tela.setVisible(true);
        });
    }
}