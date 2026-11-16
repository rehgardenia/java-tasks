package LPR2T4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        setLayout(new FlowLayout());
        setSize(350, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // --- Painel de Pesquisa ---
        add(new JLabel("Nome:"));
        txtPesquisa = new JTextField(15);
        add(txtPesquisa);

        btnPesquisar = new JButton("Pesquisar");
        add(btnPesquisar);

        // --- Painel de Exibição dos Dados ---
        add(new JLabel("Nome:"));
        txtNome = new JTextField(20);
        txtNome.setEditable(false);
        add(txtNome);

        add(new JLabel("Salário:"));
        txtSalario = new JTextField(20);
        txtSalario.setEditable(false);
        add(txtSalario);

        add(new JLabel("Cargo:"));
        txtCargo = new JTextField(20);
        txtCargo.setEditable(false);
        add(txtCargo);

        // --- Botões de Navegação ---
        btnAnterior = new JButton("Anterior");
        btnProximo = new JButton("Próximo");
        add(btnAnterior);
        add(btnProximo);

        // Conectar ao Banco de Dados
        conectarBD();

        // --- Eventos ---
        btnPesquisar.addActionListener(e -> pesquisar());
        btnProximo.addActionListener(e -> navegarProximo());
        btnAnterior.addActionListener(e -> navegarAnterior());
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
        try {
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

            stmt.setString(1, "%" + txtPesquisa.getText() + "%");
            rs = stmt.executeQuery();

            if (rs.next()) {
                atualizarCampos();
            } else {
                JOptionPane.showMessageDialog(this, "Nenhum registro encontrado.");
                limparCampos();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Erro na pesquisa: " + e.getMessage());
        }
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
    }

    private void limparCampos() {
        txtNome.setText("");
        txtSalario.setText("");
        txtCargo.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TrabalhoPratico04().setVisible(true));
    }
}