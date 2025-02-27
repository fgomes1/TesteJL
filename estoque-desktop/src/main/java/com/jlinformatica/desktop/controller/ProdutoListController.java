package com.jlinformatica.desktop.controller;

import com.jlinformatica.desktop.view.ProdutoListForm;
import com.jlinformatica.desktop.service.ProdutoService;
import com.jlinformatica.domain.model.Produto;

import java.util.List;

public class ProdutoListController {

    private ProdutoListForm listForm;
    private ProdutoService service;

    public ProdutoListController(ProdutoListForm listForm, ProdutoService service) {
        this.listForm = listForm;
        this.service = service;
    }

    public void listarProdutos() {
        List<Produto> produtos = service.listarProdutos();
        listForm.carregarProdutos(produtos);
    }


}
