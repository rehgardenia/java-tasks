package LPR2T5;

import javax.swing.*;

public class PainelContador extends JPanel implements Runnable {

    private DefaultListModel<String> model;
    private JList<String> lista;
    private JLabel lblFim;
    private int maximo;

    public PainelContador() {
        setLayout(null);
        setSize(90, 165);

        // Lista com barra de rolagem
        model = new DefaultListModel<>();
        lista = new JList<>(model);
        JScrollPane scroll = new JScrollPane(lista);
        scroll.setBounds(5, 0, 75, 130);
        add(scroll);

        // Label "Final" (começa invisível e só aparece ao fim do laço)
        lblFim = new JLabel("Final", SwingConstants.CENTER);
        lblFim.setBounds(5, 140, 75, 20);
        lblFim.setVisible(false);
        add(lblFim);
    }

    public void preparar(int maximo) {
        this.maximo = maximo;
        limpar();
    }

    public void limpar() {
        model.clear();
        lblFim.setVisible(false);
    }

    @Override
    public void run() {
        for (int i = 0; i < maximo; i++) {
            final int valorAtual = i;

            // Atualiza a interface gráfica de forma segura
            SwingUtilities.invokeLater(() -> {
                model.addElement(String.valueOf(valorAtual));
                lista.ensureIndexIsVisible(model.getSize() - 1);
            });

            // Pausa rápida para dar tempo de ver a diferença de prioridade na tela
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        // Quando termina o laço, exibe a palavra "Final"
        SwingUtilities.invokeLater(() -> lblFim.setVisible(true));
    }
}