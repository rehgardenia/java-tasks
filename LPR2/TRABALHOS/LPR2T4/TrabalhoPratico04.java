
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.Locale;

public class TrabalhoPratico04 extends JFrame {

    private JTextField txtPesquisaNome;
    private JButton btnPesquisar;
    private JTextField txtNome;
    private JTextField txtSalario;
    private JTextField txtCargo;
    private JButton btnAnterior;
    private JButton btnProximo;

    // Objetos JDBC
    private Connection con;
    private PreparedStatement pstmt;
    private ResultSet rs;

    public TrabalhoPratico04() {
        setTitle("TRABALHO PRATICO 04");
        setSize(420, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(5, 5));

        // --- PAINEL SUPERIOR (Pesquisa) ---
        JPanel painelTopo = new JPanel(new GridLayout(2, 1, 5, 5));
        
        JPanel linhaBusca = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
        linhaBusca.add(new JLabel("Nome:"));
        txtPesquisaNome = new JTextField(22);
        linhaBusca.add(txtPesquisaNome);

        JPanel linhaBotao = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 2));
        btnPesquisar = new JButton("Pesquisar");
        linhaBotao.add(btnPesquisar);

        painelTopo.add(linhaBusca);
        painelTopo.add(linhaBotao);
        add(painelTopo, BorderLayout.NORTH);

        // --- PAINEL CENTRAL E INFERIOR (Dados e Navegação) ---
        JPanel painelDados = new JPanel(new GridLayout(4, 2, 2, 2));

        painelDados.add(new JLabel("Nome:"));
        txtNome = new JTextField();
        painelDados.add(txtNome);

        painelDados.add(new JLabel("Salário:"));
        txtSalario = new JTextField();
        painelDados.add(txtSalario);

        painelDados.add(new JLabel("Cargo:"));
        txtCargo = new JTextField();
        painelDados.add(txtCargo);

        btnAnterior = new JButton("Anterior");
        btnProximo = new JButton("Próximo");
        painelDados.add(btnAnterior);
        painelDados.add(btnProximo);

        add(painelDados, BorderLayout.CENTER);

        // Conecta e cria o banco em memória automaticamente
        conectarEInicializarBanco();

        // Eventos dos botões
        btnPesquisar.addActionListener(e -> pesquisar());
        btnAnterior.addActionListener(e -> navegarAnterior());
        btnProximo.addActionListener(e -> navegarProximo());
    }

    private void conectarEInicializarBanco() {
        try {
            // Para usar no SQL Server real da faculdade depois, basta trocar estas 2 linhas por:
            // Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // String url = "jdbc:sqlserver://localhost:1433;databaseName=aulajava;encrypt=false;";
            
            Class.forName("org.h2.Driver");
            String url = "jdbc:h2:mem:aulajava;MODE=MSSQLServer;DB_CLOSE_DELAY=-1";
            con = DriverManager.getConnection(url, "sa", "");

            Statement st = con.createStatement();

            // 2. Criação das tabelas conforme o esquema do PDF
            st.execute("CREATE TABLE tbcargos (" +
                       "cd_cargo SMALLINT PRIMARY KEY, " +
                       "ds_cargo CHAR(20))");

            st.execute("CREATE TABLE tbfuncs (" +
                       "cod_func DECIMAL(9) PRIMARY KEY, " +
                       "nome_func CHAR(30), " +
                       "sal_func DECIMAL(10,2), " +
                       "cod_cargo SMALLINT, " +
                       "FOREIGN KEY (cod_cargo) REFERENCES tbcargos(cd_cargo))");

            // 3. Inserção de registros respeitando chaves e relacionamento
            st.execute("INSERT INTO tbcargos VALUES (1, 'Administrativo')");
            st.execute("INSERT INTO tbcargos VALUES (2, 'Desenvolvedor')");
            st.execute("INSERT INTO tbcargos VALUES (3, 'Analista')");

            st.execute("INSERT INTO tbfuncs VALUES (1, 'Marcelo', 2000.00, 1)");
            st.execute("INSERT INTO tbfuncs VALUES (2, 'Marcelo Santos', 3500.00, 2)");
            st.execute("INSERT INTO tbfuncs VALUES (3, 'Maria Oliveira', 4200.50, 3)");
            st.execute("INSERT INTO tbfuncs VALUES (4, 'Marcos Silva', 1800.00, 1)");
            st.execute("INSERT INTO tbfuncs VALUES (5, 'Ana Costa', 5000.00, 2)");

            st.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao iniciar banco: " + ex.getMessage());
        }
    }

    // 5. Botão Pesquisar usando SELECT com LIKE e PreparedStatement
    private void pesquisar() {
        try {
            if (rs != null) rs.close();
            if (pstmt != null) pstmt.close();

            String sql = "SELECT f.nome_func, f.sal_func, c.ds_cargo " +
                         "FROM tbfuncs f " +
                         "INNER JOIN tbcargos c ON f.cod_cargo = c.cd_cargo " +
                         "WHERE LOWER(f.nome_func) LIKE LOWER(?)";

            // TYPE_SCROLL_INSENSITIVE permite navegar para frente e para trás no ResultSet
            pstmt = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            pstmt.setString(1, "%" + txtPesquisaNome.getText().trim() + "%");

            rs = pstmt.executeQuery();

            if (rs.next()) {
                exibirRegistroAtual();
            } else {
                JOptionPane.showMessageDialog(this, "Nenhum funcionário encontrado.");
                txtNome.setText("");
                txtSalario.setText("");
                txtCargo.setText("");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erro na pesquisa: " + ex.getMessage());
        }
    }

    // 6. Navegação Anterior até o limite inicial
    private void navegarAnterior() {
        try {
            if (rs != null) {
                if (rs.previous()) {
                    exibirRegistroAtual();
                } else {
                    rs.first(); // Mantém posicionado no primeiro registro
                    JOptionPane.showMessageDialog(this, "Você já está no primeiro registro!");
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao voltar: " + ex.getMessage());
        }
    }

    // 6. Navegação Próximo até o limite final
    private void navegarProximo() {
        try {
            if (rs != null) {
                if (rs.next()) {
                    exibirRegistroAtual();
                } else {
                    rs.last(); // Mantém posicionado no último registro
                    JOptionPane.showMessageDialog(this, "Você já está no último registro!");
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao avançar: " + ex.getMessage());
        }
    }

    private void exibirRegistroAtual() throws SQLException {
        txtNome.setText(rs.getString("nome_func").trim());
        txtSalario.setText(String.format(Locale.US, "%.2f", rs.getDouble("sal_func")));
        txtCargo.setText(rs.getString("ds_cargo").trim());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TrabalhoPratico04().setVisible(true));
    }
}