package com.jlinformatica.desktop.controller;

import com.jlinformatica.desktop.view.ProdutoForm;
import com.jlinformatica.desktop.view.ProdutoListForm;
import com.jlinformatica.desktop.service.ProdutoService;
import com.jlinformatica.desktop.view.ProdutoEditForm;
import com.jlinformatica.domain.model.Produto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ProdutoListController {

    private ProdutoListForm listForm;
    private ProdutoService service;

    public ProdutoListController(ProdutoListForm listForm, ProdutoService service) {
        this.listForm = listForm;
        this.service = service;
        initController();
    }

    private void initController() {
        listForm.getEditarButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                editarProduto();
            }
        });

        listForm.getVoltarButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                listForm.dispose();

                ProdutoForm formCriacao = new ProdutoForm();
                formCriacao.setLocationRelativeTo(null);
                formCriacao.setVisible(true);

            }
        });
    }

    public void listarProdutos() {
        List<Produto> produtos = service.listarProdutos();
        listForm.carregarProdutos(produtos);
    }


    private void editarProduto() {
        Long produtoId = listForm.getProdutoSelecionado();
        if (produtoId != null) {
            Produto produto = service.buscarProdutoPorId(produtoId);
            if (produto != null) {
                ProdutoEditForm editForm = new ProdutoEditForm(produto);
                new ProdutoEditController(editForm, service, produto, listForm);
                editForm.setLocationRelativeTo(null);
                editForm.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(listForm, "Produto não encontrado.");
            }
        } else {
            JOptionPane.showMessageDialog(listForm, "Selecione um produto para editar.");
        }
    }


}


