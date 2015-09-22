/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPAControllers;

import JPAControllers.exceptions.NonexistentEntityException;
import entity.Operaciones;
import entity.Portafolios;
import java.io.Serializable;
import java.util.Date;
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
public class OperacionesJpaController implements Serializable {

    public OperacionesJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Operaciones operaciones) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(operaciones);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Operaciones operaciones) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            operaciones = em.merge(operaciones);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = operaciones.getIdaportaciones();
                if (findOperaciones(id) == null) {
                    throw new NonexistentEntityException("The operaciones with id " + id + " no longer exists.");
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
            Operaciones operaciones;
            try {
                operaciones = em.getReference(Operaciones.class, id);
                operaciones.getIdaportaciones();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The operaciones with id " + id + " no longer exists.", enfe);
            }
            em.remove(operaciones);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Operaciones> findOperacionesEntities() {
        return findOperacionesEntities(true, -1, -1);
    }

    public List<Operaciones> findOperacionesEntities(int maxResults, int firstResult) {
        return findOperacionesEntities(false, maxResults, firstResult);
    }

    private List<Operaciones> findOperacionesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Operaciones.class));
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

    public Operaciones findOperaciones(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Operaciones.class, id);
        } finally {
            em.close();
        }
    }

    public int getOperacionesCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Operaciones> rt = cq.from(Operaciones.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
     public double getSumOperacion(int p_portafolios, Date p_fecha, String p_operacion){
        String resultado = "";
       
        EntityManager em = getEntityManager();
        Query query = em.createNamedQuery("Operaciones.getSumbyOperation");
        query.setParameter("portafolios", new Portafolios(p_portafolios));
        query.setParameter("fecha", p_fecha);
        query.setParameter("operacion", p_operacion);
        List<Object> operacioneslist = query.getResultList();
//        resultado = query.getSingleResult().toString();
        
        if (operacioneslist.get(0) == null) {
            return 0;
        } else {
            
            return (double)operacioneslist.get(0);
        }
        
    }
        
     public List<Operaciones> get_aportaciones_by_portafolios(int p_idportafolios, String p_tipooperacion){
         EntityManager em = getEntityManager();
        Query query = em.createNamedQuery("Operaciones.findaportacionesbyportafolios");
        query.setParameter("portafolios", new Portafolios(p_idportafolios));
        query.setParameter("operacion", p_tipooperacion);
        
        return query.getResultList();
     }
     
     public Portafolios findbyname(String name){
        EntityManager em = getEntityManager();
      
        return (Portafolios)em.createNamedQuery("Portafolios.findByNombre").setParameter("valnombre", name).getSingleResult();
    }
}
