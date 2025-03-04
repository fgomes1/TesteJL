package com.jlinformatica.desktop.controller;

import com.jlinformatica.desktop.view.ProdutoEditForm;
import com.jlinformatica.desktop.view.ProdutoListForm;
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
    private ProdutoListForm listForm;

    public ProdutoEditController(ProdutoEditForm form, ProdutoService service, Produto produto, ProdutoListForm listForm) {
        this.form = form;
        this.service = service;
        this.produto = produto;
        this.listForm = listForm;
        initController();
    }

    private void initController() {
        form.getSalvarButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                salvarProduto();
            }
        });
    }

    private void salvarProduto() {
        System.out.println("Salvando produto editado...");
        try {
            produto.setNome(form.getNome());
            produto.setDescricao(form.getDescricao());
            produto.setPreco(new BigDecimal(form.getPreco()));
            produto.setQuantidade(Integer.parseInt(form.getQuantidade()));

            service.salvar(produto);

            JOptionPane.showMessageDialog(form, "Produto editado com sucesso!");

            listForm.carregarProdutos(service.listarProdutos());

            form.dispose();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(form, "Erro ao salvar produto: " + ex.getMessage());
        }
    }
}
