/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPAControllers;

import JPAControllers.exceptions.NonexistentEntityException;
import entity.Resultados;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author 60044723
 */
public class ResultadosJpaController implements Serializable {

    public ResultadosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Resultados resultados) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(resultados);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Resultados resultados) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            resultados = em.merge(resultados);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = resultados.getIdresultados();
                if (findResultados(id) == null) {
                    throw new NonexistentEntityException("The resultados with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Resultados resultados;
            try {
                resultados = em.getReference(Resultados.class, id);
                resultados.getIdresultados();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The resultados with id " + id + " no longer exists.", enfe);
            }
            em.remove(resultados);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Resultados> findResultadosEntities() {
        return findResultadosEntities(true, -1, -1);
    }

    public List<Resultados> findResultadosEntities(int maxResults, int firstResult) {
        return findResultadosEntities(false, maxResults, firstResult);
    }

    private List<Resultados> findResultadosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Resultados.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Resultados findResultados(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Resultados.class, id);
        } finally {
            em.close();
        }
    }

    public int getResultadosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Resultados> rt = cq.from(Resultados.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    public List<Resultados> getResultadosByPortafolios(int p_idportafolios){
        EntityManager em = getEntityManager();
        Query query = em.createNamedQuery("Resultados.findByPortafolios");
        query.setParameter("portafolios", p_idportafolios);
        return query.getResultList();
    }
}
