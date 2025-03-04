package com.jlinformatica.domain.test;

import com.jlinformatica.domain.model.Produto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class TestPersistence {

    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("estoquePU");
            em = emf.createEntityManager();

            em.getTransaction().begin();

            Produto produto = new Produto();
            produto.setNome("Produto de Teste");
            produto.setDescricao("Teste de persistência com Hibernate");
            produto.setPreco(new BigDecimal("99.99"));
            produto.setQuantidade(10);

            em.persist(produto);

            em.getTransaction().commit();

            System.out.println("Persistência executada com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
            if (emf != null) {
                emf.close();
            }
        }
    }
}
