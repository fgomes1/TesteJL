package com.jlinformatica.desktop.view;

import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
import com.jlinformatica.domain.model.Produto;
import java.util.List;

public class ProdutoListForm extends JFrame {

    private JTable produtoTable;
    private JButton editarButton;
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

        JScrollPane scrollPane = new JScrollPane(produtoTable);

        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
        add(editarButton, BorderLayout.SOUTH);
    }

    public void carregarProdutos(List<Produto> produtos) {
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

    public int getProdutoSelecionado() {
        int selectedRow = produtoTable.getSelectedRow();
        if (selectedRow >= 0) {
            Object value = produtoTable.getValueAt(selectedRow, 0);

            if (value instanceof Integer) {
                return (Integer) value;
            }
        }
        return -1;
    }

}
