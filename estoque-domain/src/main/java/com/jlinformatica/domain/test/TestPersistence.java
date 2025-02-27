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
            // Cria o EntityManagerFactory usando o nome da unidade de persistência do seu persistence.xml
            emf = Persistence.createEntityManagerFactory("estoquePU");
            // Cria o EntityManager
            em = emf.createEntityManager();

            // Inicia uma transação
            em.getTransaction().begin();

            // Exemplo de criação de um objeto Produto
            Produto produto = new Produto();
            produto.setNome("Produto de Teste");
            produto.setDescricao("Teste de persistência com Hibernate");
            produto.setPreco(new BigDecimal("99.99"));
            produto.setQuantidade(10);

            // Persiste o objeto no banco
            em.persist(produto);

            // Confirma (commit) a transação
            em.getTransaction().commit();

            System.out.println("Persistência executada com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Fecha o EntityManager e o EntityManagerFactory
            if (em != null) {
                em.close();
            }
            if (emf != null) {
                emf.close();
            }
        }
    }
}
