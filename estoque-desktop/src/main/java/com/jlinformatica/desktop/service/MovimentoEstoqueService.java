package com.jlinformatica.desktop.service;

import com.jlinformatica.domain.model.MovimentoEstoque;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MovimentoEstoqueService {

    private static final String PERSISTENCE_UNIT = "estoquePU";

    public void salvar(MovimentoEstoque movimento) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            if (movimento.getId() == null) {
                em.persist(movimento);
            } else {
                em.merge(movimento);
            }
            em.getTransaction().commit();
        } finally {
            em.close();
            emf.close();
        }
    }
}
