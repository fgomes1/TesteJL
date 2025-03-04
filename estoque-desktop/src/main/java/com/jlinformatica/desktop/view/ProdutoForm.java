package com.jlinformatica.desktop.view;

import javax.swing.*;
import java.awt.*;

public class ProdutoForm extends JFrame {

    private JTextField nomeField;
    private JTextArea descricaoArea;
    private JTextField precoField;
    private JTextField quantidadeField;
    private JButton salvarButton;
    private JButton verListaButton;

    public ProdutoForm() {
        setTitle("Cadastro de Produto");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
    }

    private void initComponents() {
        nomeField = new JTextField(20);
        descricaoArea = new JTextArea(5, 20);
        precoField = new JTextField(10);
        quantidadeField = new JTextField(5);
        salvarButton = new JButton("Salvar");
        verListaButton = new JButton("Ver Lista de Produtos");  // Inicializa o novo botão

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Nome:"), gbc);
        gbc.gridx = 1;
        add(nomeField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Descrição:"), gbc);
        gbc.gridx = 1;
        JScrollPane scroll = new JScrollPane(descricaoArea);
        add(scroll, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new JLabel("Preço:"), gbc);
        gbc.gridx = 1;
        add(precoField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        add(new JLabel("Quantidade:"), gbc);
        gbc.gridx = 1;
        add(quantidadeField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        add(salvarButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        add(verListaButton, gbc);
    }

    public JButton getSalvarButton() {
        return salvarButton;
    }

    public JButton getVerListaButton() {
        return verListaButton;
    }

    public String getNome() {
        return nomeField.getText();
    }

    public String getDescricao() {
        return descricaoArea.getText();
    }

    public String getPreco() {
        return precoField.getText();
    }

    public String getQuantidade() {
        return quantidadeField.getText();
    }

    public JTextField getNomeField() {
        return nomeField;
    }

    public JTextArea getDescricaoArea() {
        return descricaoArea;
    }

    public JTextField getPrecoField() {
        return precoField;
    }

    public JTextField getQuantidadeField() {
        return quantidadeField;
    }
}
