
package Pessoa;

import javax.swing.*;
import java.awt.*;

public class FormPessoa2 extends JFrame {

    private JTextField txtNumero;
    private JTextField txtNome;
    private JTextField txtIdade;
    private JComboBox<String> cbSexo;

    private Pessoa UmaPessoa;

    public FormPessoa2() {

        setTitle("Formulário Pessoa - Versão 02");
        setSize(350, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new GridLayout(5, 2, 5, 5));

        add(new JLabel("Número:"));
        txtNumero = new JTextField();
        txtNumero.setEditable(false);
        add(txtNumero);

        add(new JLabel("Nome:"));
        txtNome = new JTextField();
        add(txtNome);

        add(new JLabel("Sexo:"));

        String[] sexos = {"", "M", "F"};
        cbSexo = new JComboBox<>(sexos);
        add(cbSexo);

        add(new JLabel("Idade:"));
        txtIdade = new JTextField();
        add(txtIdade);

        JButton btnOK = new JButton("OK");
        JButton btnMostrar = new JButton("Mostrar");

        add(btnOK);
        add(btnMostrar);

        btnOK.addActionListener(e -> transferirDados());
        btnMostrar.addActionListener(e -> mostrarDados());
    }

    private void transferirDados() {

        String nome = txtNome.getText().trim();
        String sexo = (String) cbSexo.getSelectedItem();
        String idadeTexto = txtIdade.getText().trim();

        if (nome.isEmpty() || idadeTexto.isEmpty()
                || sexo == null || sexo.isEmpty()) {

            JOptionPane.showMessageDialog(this,
                    "Preencha todos os campos!");
            return;
        }

        int idade;

        try {
            idade = Integer.parseInt(idadeTexto);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "Digite uma idade válida!");
            return;
        }

        if (idade < 0) {
            JOptionPane.showMessageDialog(this,
                    "A idade não pode ser negativa!");
            return;
        }

        UmaPessoa = new Pessoa();

        UmaPessoa.setNome(nome);
        UmaPessoa.setSexo(sexo.charAt(0));
        UmaPessoa.setIdade(idade);

        txtNumero.setText(
                String.valueOf(UmaPessoa.getNumero()));

        JOptionPane.showMessageDialog(this,
                "Dados cadastrados com sucesso!");
    }

    private void mostrarDados() {

        if (UmaPessoa == null) {
            JOptionPane.showMessageDialog(this,
                    "Cadastre uma pessoa primeiro!");
            return;
        }

        JOptionPane.showMessageDialog(this,
                "Número: " + UmaPessoa.getNumero()
                + "\nNome: " + UmaPessoa.getNome()
                + "\nSexo: " + UmaPessoa.getSexo()
                + "\nIdade: " + UmaPessoa.getIdade()
                + "\nContador kp: " + UmaPessoa.getKp());
    }

    public static void main(String[] args) {

        FormPessoa2 form = new FormPessoa2();
        form.setVisible(true);
    }
}
