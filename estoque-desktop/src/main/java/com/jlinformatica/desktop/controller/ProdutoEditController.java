package com.jlinformatica.desktop.controller;

import com.jlinformatica.desktop.view.ProdutoEditForm;
import com.jlinformatica.desktop.service.ProdutoService;
import com.jlinformatica.domain.model.Produto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import javax.swing.JOptionPane;

public class ProdutoEditController {

    private ProdutoEditForm form;
    private ProdutoService service;
    private Produto produto;

    public ProdutoEditController(ProdutoEditForm form, ProdutoService service, Produto produto) {
        this.form = form;
        this.service = service;
        this.produto = produto;
        initController();  // Inicializa o controlador
    }

    private void initController() {
        form.getSalvarButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                salvarProduto();  // Chama o método salvarProduto quando o botão "Salvar" é clicado
            }
        });
    }

    private void salvarProduto() {
        try {
            produto.setNome(form.getNome());
            produto.setDescricao(form.getDescricao());
            produto.setPreco(new BigDecimal(form.getPreco()));
            produto.setQuantidade(Integer.parseInt(form.getQuantidade()));

            service.salvar(produto);  // Atualiza o produto

            JOptionPane.showMessageDialog(form, "Produto editado com sucesso!");
            form.dispose();  // Fecha a tela de edição

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(form, "Erro ao editar produto: " + ex.getMessage());
        }
    }
}
