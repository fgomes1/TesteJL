package com.jlinformatica.web.bean;

import com.jlinformatica.domain.model.Produto;
import com.jlinformatica.desktop.service.ProdutoService;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

@Named("produtoBean")
@SessionScoped
public class ProdutoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private ProdutoService produtoService = new ProdutoService();

    private List<Produto> produtosBaixoEstoque;

    private String descricaoBusca;
    private List<Produto> produtosEncontrados;

    @PostConstruct
    public void init() {
        produtosBaixoEstoque = produtoService.listarProdutosBaixoEstoque();
    }

    public List<Produto> getProdutosBaixoEstoque() {
        return produtosBaixoEstoque;
    }

    public String getDescricaoBusca() {
        return descricaoBusca;
    }

    public void setDescricaoBusca(String descricaoBusca) {
        this.descricaoBusca = descricaoBusca;
    }

    public List<Produto> getProdutosEncontrados() {
        return produtosEncontrados;
    }

    public String buscarProduto() {
        produtosEncontrados = produtoService.buscarProdutoPorDescricao(descricaoBusca);
        return null;
}
