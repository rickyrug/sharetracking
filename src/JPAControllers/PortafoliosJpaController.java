/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPAControllers;

import JPAControllers.exceptions.NonexistentEntityException;
import entity.Portafolios;
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
public class PortafoliosJpaController implements Serializable {

    public PortafoliosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Portafolios portafolios) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(portafolios);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Portafolios portafolios) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            portafolios = em.merge(portafolios);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = portafolios.getIdportafolios();
                if (findPortafolios(id) == null) {
                    throw new NonexistentEntityException("The portafolios with id " + id + " no longer exists.");
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
            Portafolios portafolios;
            try {
                portafolios = em.getReference(Portafolios.class, id);
                portafolios.getIdportafolios();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The portafolios with id " + id + " no longer exists.", enfe);
            }
            em.remove(portafolios);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Portafolios> findPortafoliosEntities() {
        return findPortafoliosEntities(true, -1, -1);
    }

    public List<Portafolios> findPortafoliosEntities(int maxResults, int firstResult) {
        return findPortafoliosEntities(false, maxResults, firstResult);
    }

    private List<Portafolios> findPortafoliosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Portafolios.class));
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

    public Portafolios findPortafolios(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Portafolios.class, id);
        } finally {
            em.close();
        }
    }

    public int getPortafoliosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Portafolios> rt = cq.from(Portafolios.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    public Portafolios findbyname(String name){
        EntityManager em = getEntityManager();
      
        return (Portafolios)em.createNamedQuery("Portafolios.findByNombre").setParameter("nombre", name).getSingleResult();
    }
}
