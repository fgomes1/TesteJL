package com.jlinformatica.desktop.controller;

import com.jlinformatica.desktop.view.MovimentoEstoqueForm;
import com.jlinformatica.desktop.service.MovimentoEstoqueService;
import com.jlinformatica.desktop.service.ProdutoService;
import com.jlinformatica.domain.model.MovimentoEstoque;
import com.jlinformatica.domain.model.Produto;
import com.jlinformatica.domain.model.TipoMovimento;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;

public class MovimentoEstoqueController {

    private MovimentoEstoqueForm form;
    private MovimentoEstoqueService service;
    private ProdutoService produtoService;

    public MovimentoEstoqueController(MovimentoEstoqueForm form, MovimentoEstoqueService service, ProdutoService produtoService) {
        this.form = form;
        this.service = service;
        this.produtoService = produtoService;
        initController();
    }

    private void initController() {
        form.getSalvarButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                salvarMovimentacao();
            }
        });

        form.getVoltarButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                form.dispose();
            }
        });
    }

    private void salvarMovimentacao() {
        try {
            Produto produto = (Produto) form.getProdutoComboBox().getSelectedItem();
            int quantidade = Integer.parseInt(form.getQuantidade());
            String tipoString = form.getTipoMovimento();

            TipoMovimento tipoEnum = "Entrada".equalsIgnoreCase(tipoString) ? TipoMovimento.ENTRADA : TipoMovimento.SAIDA;

            MovimentoEstoque movimento = new MovimentoEstoque();
            movimento.setDataMovimento(LocalDateTime.now());
            movimento.setProduto(produto);
            movimento.setQuantidade(quantidade);
            movimento.setTipo(tipoEnum);

            // Atualiza a quantidade do produto
            if (tipoEnum == TipoMovimento.ENTRADA) {
                produto.setQuantidade(produto.getQuantidade() + quantidade);
            } else {
                produto.setQuantidade(produto.getQuantidade() - quantidade);
            }

            service.salvar(movimento);
            produtoService.salvar(produto);

            JOptionPane.showMessageDialog(form, "Movimentação salva e produto atualizado!");
            form.dispose();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(form, "Erro ao salvar movimentação: " + ex.getMessage());
        }
    }
}
