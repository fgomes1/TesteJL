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
        initController();
    }

    private void initController() {
        // Adiciona o listener ao botão "Salvar"
        form.getSalvarButton().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                salvarProduto();
            }
        });
    }

    private void salvarProduto() {
        System.out.println("Salvando produto editado...");
        try {
            // Atualiza os campos do produto com os valores do formulário
            produto.setNome(form.getNome());
            produto.setDescricao(form.getDescricao());
            produto.setPreco(new BigDecimal(form.getPreco()));
            produto.setQuantidade(Integer.parseInt(form.getQuantidade()));

            // Persiste as alterações no banco
            service.salvar(produto);

            // Mensagem de sucesso
            JOptionPane.showMessageDialog(form, "Produto editado com sucesso!");
            form.dispose(); // Fecha a tela de edição

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(form, "Erro ao salvar produto: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
