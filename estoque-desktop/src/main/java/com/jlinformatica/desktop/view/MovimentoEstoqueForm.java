package com.jlinformatica.desktop.view;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import com.jlinformatica.domain.model.Produto;

public class MovimentoEstoqueForm extends JFrame {

    private JComboBox produtoComboBox;

    private JTextField quantidadeField;
    private JComboBox tipoMovimentoComboBox;
    private JButton salvarButton;
    private JButton voltarButton;

    public MovimentoEstoqueForm(List<Produto> produtos) {
        setTitle("Movimentação de Estoque");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        initComponents(produtos);
    }

    private void initComponents(List<Produto> produtos) {
        produtoComboBox = new JComboBox(produtos.toArray(new Produto[0]));
        quantidadeField = new JTextField(10);
        tipoMovimentoComboBox = new JComboBox(new String[]{"Entrada", "Saída"});
        salvarButton = new JButton("Salvar");
        voltarButton = new JButton("Voltar");

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Produto:"), gbc);
        gbc.gridx = 1;
        add(produtoComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Quantidade:"), gbc);
        gbc.gridx = 1;
        add(quantidadeField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new JLabel("Tipo de Movimento:"), gbc);
        gbc.gridx = 1;
        add(tipoMovimentoComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        add(salvarButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        add(voltarButton, gbc);
    }

    public JComboBox getProdutoComboBox() {
        return produtoComboBox;
    }

    public String getQuantidade() {
        return quantidadeField.getText();
    }

    public String getTipoMovimento() {
        return (String) tipoMovimentoComboBox.getSelectedItem();
    }

    public JButton getSalvarButton() {
        return salvarButton;
    }

    public JButton getVoltarButton() {
        return voltarButton;
    }
}
