package com.jlinformatica.desktop.view;

import com.jlinformatica.domain.model.Produto;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class ProdutoListForm extends JFrame {

    private JTable produtoTable;
    private JButton editarButton;
    private JButton voltarButton;
    private DefaultTableModel tableModel;

    public ProdutoListForm() {
        setTitle("Lista de Produtos");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
    }

    private void initComponents() {
        tableModel = new DefaultTableModel(new Object[]{"ID", "Nome", "Preço", "Quantidade"}, 0);
        produtoTable = new JTable(tableModel);


        editarButton = new JButton("Editar");
        voltarButton = new JButton("Voltar");

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));

        editarButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        voltarButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        buttonPanel.add(editarButton);
        buttonPanel.add(Box.createVerticalStrut(10));
        buttonPanel.add(voltarButton);

        JScrollPane scrollPane = new JScrollPane(produtoTable);

        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    public void carregarProdutos(List<Produto> produtos) {
        tableModel.setRowCount(0);
        for (Produto produto : produtos) {
            tableModel.addRow(new Object[]{
                    produto.getId(),
                    produto.getNome(),
                    produto.getPreco(),
                    produto.getQuantidade()
            });
        }
    }

    public JTable getProdutoTable() {
        return produtoTable;
    }

    public JButton getEditarButton() {
        return editarButton;
    }

    public JButton getVoltarButton() {
        return voltarButton;
    }


    public Long getProdutoSelecionado() {
        int selectedRow = produtoTable.getSelectedRow();
        if (selectedRow >= 0) {
            Object value = produtoTable.getValueAt(selectedRow, 0);
            if (value instanceof Long) {
                return (Long) value;
            } else if (value instanceof Integer) {
                return Long.valueOf((Integer) value);
            }
        }
        return null;
    }
}
