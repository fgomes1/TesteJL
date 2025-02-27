package com.jlinformatica.desktop.service;

import com.jlinformatica.domain.model.Produto;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class ProdutoService {
    private static final String PERSISTENCE_UNIT = "estoquePU";


    public void salvar(Produto produto) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            if (produto.getId() == null) {
                em.persist(produto);
            } else {
                em.merge(produto);
            }
            em.getTransaction().commit();
        } finally {
            em.close();
            emf.close();
        }
    }


    public List<Produto> listarProdutos() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        EntityManager em = emf.createEntityManager();
        try {
            List<Produto> produtos = em.createQuery("SELECT p FROM Produto p", Produto.class).getResultList();
            return produtos;
        } finally {
            em.close();
            emf.close();
        }
    }
}
