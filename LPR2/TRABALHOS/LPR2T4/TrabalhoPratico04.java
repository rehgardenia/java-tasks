package LPR2T4;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class TrabalhoPratico04 extends JFrame {
    // Componentes da Interface
    private JTextField txtPesquisa;
    private JTextField txtNome;
    private JTextField txtSalario;
    private JTextField txtCargo;
    private JButton btnPesquisar, btnAnterior, btnProximo;

    // Gerenciamento de Dados / JDBC
    private Connection conexao;
    private ResultSet rs;

    public TrabalhoPratico04() {
        super("TRABALHO PRATICO 04");
        JPanel principal = new JPanel(new BorderLayout(0, 16));
        principal.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        setContentPane(principal);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel pesquisa = new JPanel(new BorderLayout(8, 8));
        pesquisa.setBorder(BorderFactory.createTitledBorder("Pesquisa"));
        JPanel dados = new JPanel(new GridBagLayout());
        dados.setBorder(BorderFactory.createTitledBorder("Dados do funcionário"));
        JPanel navegacao = new JPanel(new FlowLayout(FlowLayout.RIGHT, 8, 0));
        JPanel cabecalho = new JPanel(new BorderLayout(0, 12));
        JLabel titulo = new JLabel("Consulta de funcionários");
        titulo.setFont(titulo.getFont().deriveFont(Font.BOLD, 20f));
        cabecalho.add(titulo, BorderLayout.NORTH);
        cabecalho.add(pesquisa, BorderLayout.CENTER);
        principal.add(cabecalho, BorderLayout.NORTH);
        principal.add(dados, BorderLayout.CENTER);
        principal.add(navegacao, BorderLayout.SOUTH);

        // --- Painel de Pesquisa ---
        JLabel rotuloPesquisa = new JLabel("Nome do funcionário:");
        pesquisa.add(rotuloPesquisa, BorderLayout.NORTH);
        txtPesquisa = new JTextField(15);
        rotuloPesquisa.setLabelFor(txtPesquisa);
        pesquisa.add(txtPesquisa, BorderLayout.CENTER);

        btnPesquisar = new JButton("Pesquisar");
        pesquisa.add(btnPesquisar, BorderLayout.EAST);
        getRootPane().setDefaultButton(btnPesquisar);

        // --- Painel de Exibição dos Dados ---
        txtNome = new JTextField(20);
        txtNome.setEditable(false);
        adicionarCampo(dados, "Nome:", txtNome, 0);

        txtSalario = new JTextField(20);
        txtSalario.setEditable(false);
        adicionarCampo(dados, "Salário (R$):", txtSalario, 1);

        txtCargo = new JTextField(20);
        txtCargo.setEditable(false);
        adicionarCampo(dados, "Cargo:", txtCargo, 2);

        // --- Botões de Navegação ---
        btnAnterior = new JButton("Anterior");
        btnProximo = new JButton("Próximo");
        btnAnterior.setEnabled(false);
        btnProximo.setEnabled(false);
        navegacao.add(btnAnterior);
        navegacao.add(btnProximo);
        pack();
        setMinimumSize(getSize());
        setLocationRelativeTo(null);

        // Conectar ao Banco de Dados
        conectarBD();

        // --- Eventos ---
        btnPesquisar.addActionListener(e -> pesquisar());
        btnProximo.addActionListener(e -> navegarProximo());
        btnAnterior.addActionListener(e -> navegarAnterior());
    }

    private void adicionarCampo(JPanel painel, String texto, JTextField campo, int linha) {
        JLabel rotulo = new JLabel(texto);
        rotulo.setLabelFor(campo);
        GridBagConstraints restricoes = new GridBagConstraints();
        restricoes.gridx = 0;
        restricoes.gridy = linha;
        restricoes.anchor = GridBagConstraints.LINE_START;
        restricoes.insets = new Insets(8, 8, 8, 12);
        painel.add(rotulo, restricoes);
        restricoes.gridx = 1;
        restricoes.weightx = 1;
        restricoes.fill = GridBagConstraints.HORIZONTAL;
        restricoes.insets = new Insets(8, 0, 8, 8);
        painel.add(campo, restricoes);
    }

    private void conectarBD() {
        try {
            // Ajuste a URL, usuário e senha conforme seu ambiente
            String url = "jdbc:sqlserver://localhost:1433;databaseName=aulajava;encrypt=false;";
            String usuario = "sa";
            String senha = "sua_senha";

            conexao = DriverManager.getConnection(url, usuario, senha);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Erro ao conectar ao banco: " + e.getMessage());
        }
    }

    private void pesquisar() {
        String nome = txtPesquisa.getText().strip();
        if (nome.isEmpty()) {
            informarEntradaInvalida("Informe o nome do funcionário para pesquisar.");
            return;
        }
        if (!nome.matches("[\\p{L}\\p{M} .’'\\-]+")
                || !nome.matches(".*\\p{L}.*")) {
            informarEntradaInvalida("Informe um nome com letras. Espaços, pontos, apóstrofos e hífens são permitidos.");
            return;
        }
        txtPesquisa.setText(nome);
        try {
            if (conexao == null || conexao.isClosed()) {
                JOptionPane.showMessageDialog(this,
                    "Conexão com o banco indisponível. Verifique a configuração e reinicie o programa.",
                    "Pesquisa indisponível", JOptionPane.WARNING_MESSAGE);
                return;
            }
            limparCampos();
            // Consulta SQL com JOIN para buscar o nome do cargo
            String sql = "SELECT f.nome_func, f.sal_func, c.ds_cargo " +
                         "FROM tbfuncs f " +
                         "INNER JOIN tbcargos c ON f.cod_cargo = c.cd_cargo " +
                         "WHERE f.nome_func LIKE ?";

            // TYPE_SCROLL_INSENSITIVE permite navegar para frente e para trás no ResultSet
            PreparedStatement stmt = conexao.prepareStatement(
                sql,
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY
            );

            stmt.setString(1, "%" + nome + "%");
            rs = stmt.executeQuery();

            if (rs.next()) {
                atualizarCampos();
            } else {
                JOptionPane.showMessageDialog(this, "Nenhum registro encontrado.");
                limparCampos();
            }
        } catch (SQLException e) {
            limparCampos();
            JOptionPane.showMessageDialog(this, "Erro na pesquisa: " + e.getMessage());
        }
    }

    private void informarEntradaInvalida(String mensagem) {
        JOptionPane.showMessageDialog(this, mensagem, "Entrada inválida", JOptionPane.WARNING_MESSAGE);
        txtPesquisa.requestFocusInWindow();
        txtPesquisa.selectAll();
    }

    private void navegarProximo() {
        try {
            if (rs != null && rs.next()) {
                atualizarCampos();
            } else if (rs != null) {
                rs.last(); // Permanece no último registro se atingir o fim
                JOptionPane.showMessageDialog(this, "Você já está no último registro.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Erro ao navegar: " + e.getMessage());
        }
    }

    private void navegarAnterior() {
        try {
            if (rs != null && rs.previous()) {
                atualizarCampos();
            } else if (rs != null) {
                rs.first(); // Permanece no primeiro registro se atingir o início
                JOptionPane.showMessageDialog(this, "Você já está no primeiro registro.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Erro ao navegar: " + e.getMessage());
        }
    }

    private void atualizarCampos() throws SQLException {
        txtNome.setText(rs.getString("nome_func").trim());
        txtSalario.setText(String.format("%.2f", rs.getDouble("sal_func")));
        txtCargo.setText(rs.getString("ds_cargo").trim());
        btnAnterior.setEnabled(!rs.isFirst());
        btnProximo.setEnabled(!rs.isLast());
    }

    private void limparCampos() {
        txtNome.setText("");
        txtSalario.setText("");
        txtCargo.setText("");
        btnAnterior.setEnabled(false);
        btnProximo.setEnabled(false);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TrabalhoPratico04().setVisible(true));
    }
}
