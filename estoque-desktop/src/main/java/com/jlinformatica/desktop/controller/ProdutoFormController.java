package com.jlinformatica.desktop.controller;

import com.jlinformatica.desktop.view.ProdutoForm;
import com.jlinformatica.desktop.view.MovimentoEstoqueForm;


import com.jlinformatica.desktop.view.ProdutoListForm;
import com.jlinformatica.desktop.service.ProdutoService;
import com.jlinformatica.desktop.service.MovimentoEstoqueService;
import com.jlinformatica.domain.model.Produto;
import java.math.BigDecimal;
import java.util.List;



import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProdutoFormController {

    private ProdutoForm form;
    private ProdutoService service;

    public ProdutoFormController(ProdutoForm form, ProdutoService service) {
        this.form = form;
        this.service = service;
        initController();
    }

    private void initController() {
        form.getSalvarButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                salvarProduto();
            }
        });

        form.getVerListaButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirListaDeProdutos();
            }
        });

        form.getMovimentarEstoqueButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Botão Estoque clicado.");
                abrirMovimentacaoEstoque();
            }
        });

    }

    private void abrirMovimentacaoEstoque() {
        List<Produto> produtos = service.listarProdutos();
        MovimentoEstoqueForm movimentoForm = new MovimentoEstoqueForm(produtos);
        MovimentoEstoqueService movimentoService = new MovimentoEstoqueService();
        ProdutoService produtoService = new ProdutoService();
        new MovimentoEstoqueController(movimentoForm, movimentoService, produtoService);

        movimentoForm.setLocationRelativeTo(form);
        movimentoForm.setVisible(true);
    }

    private void salvarProduto() {
        try {
            Produto produto = new Produto();
            produto.setNome(form.getNome());
            produto.setDescricao(form.getDescricao());
            produto.setPreco(new BigDecimal(form.getPreco()));
            produto.setQuantidade(Integer.parseInt(form.getQuantidade()));

            service.salvar(produto);

            JOptionPane.showMessageDialog(form, "Produto salvo com sucesso!");

            limparCampos();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(form, "Erro ao salvar produto: " + ex.getMessage());
        }
    }

    private void limparCampos() {
        form.getNomeField().setText("");
        form.getDescricaoArea().setText("");
        form.getPrecoField().setText("");
        form.getQuantidadeField().setText("");
    }

    private void abrirListaDeProdutos() {
        ProdutoListForm listForm = new ProdutoListForm();
        ProdutoListController listController = new ProdutoListController(listForm, service);
        listController.listarProdutos();
        listForm.setLocationRelativeTo(null);
        listForm.setVisible(true);
    }
}
