
package Pessoa;

import javax.swing.*;
import java.awt.*;

public class FormPessoa extends JFrame {

    private JTextField txtNumero;
    private JTextField txtNome;
    private JTextField txtSexo;
    private JTextField txtIdade;

    private Pessoa UmaPessoa;

    public FormPessoa() {

        setTitle("Formulário Pessoa");
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

        add(new JLabel("Sexo (M/F):"));
        txtSexo = new JTextField();
        add(txtSexo);

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
        String sexoTexto = txtSexo.getText().trim().toUpperCase();
        String idadeTexto = txtIdade.getText().trim();

        if (nome.isEmpty() || sexoTexto.isEmpty()
                || idadeTexto.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Preencha todos os campos!");
            return;
        }

        if (sexoTexto.length() != 1
                || (sexoTexto.charAt(0) != 'M'
                && sexoTexto.charAt(0) != 'F')) {
            JOptionPane.showMessageDialog(this,
                    "Digite M ou F no campo Sexo!");
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
        UmaPessoa.setSexo(sexoTexto.charAt(0));
        UmaPessoa.setIdade(idade);

        txtNumero.setText(
                String.valueOf(UmaPessoa.getNumero()));

        JOptionPane.showMessageDialog(this,
                "Dados cadastrados!");
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
        FormPessoa form = new FormPessoa();
        form.setVisible(true);
    }
}
