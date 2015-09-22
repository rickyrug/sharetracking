/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPAControllers;

import JPAControllers.exceptions.IllegalOrphanException;
import JPAControllers.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entity.Aportaciones;
import entity.Portafolios;
import java.util.ArrayList;
import java.util.Collection;
import entity.Resultados;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

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
        if (portafolios.getAportacionesCollection() == null) {
            portafolios.setAportacionesCollection(new ArrayList<Aportaciones>());
        }
        if (portafolios.getResultadosCollection() == null) {
            portafolios.setResultadosCollection(new ArrayList<Resultados>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Aportaciones> attachedAportacionesCollection = new ArrayList<Aportaciones>();
            for (Aportaciones aportacionesCollectionAportacionesToAttach : portafolios.getAportacionesCollection()) {
                aportacionesCollectionAportacionesToAttach = em.getReference(aportacionesCollectionAportacionesToAttach.getClass(), aportacionesCollectionAportacionesToAttach.getIdaportaciones());
                attachedAportacionesCollection.add(aportacionesCollectionAportacionesToAttach);
            }
            portafolios.setAportacionesCollection(attachedAportacionesCollection);
            Collection<Resultados> attachedResultadosCollection = new ArrayList<Resultados>();
            for (Resultados resultadosCollectionResultadosToAttach : portafolios.getResultadosCollection()) {
                resultadosCollectionResultadosToAttach = em.getReference(resultadosCollectionResultadosToAttach.getClass(), resultadosCollectionResultadosToAttach.getIdresultados());
                attachedResultadosCollection.add(resultadosCollectionResultadosToAttach);
            }
            portafolios.setResultadosCollection(attachedResultadosCollection);
            em.persist(portafolios);
            for (Aportaciones aportacionesCollectionAportaciones : portafolios.getAportacionesCollection()) {
                Portafolios oldPortafoliosOfAportacionesCollectionAportaciones = aportacionesCollectionAportaciones.getPortafolios();
                aportacionesCollectionAportaciones.setPortafolios(portafolios);
                aportacionesCollectionAportaciones = em.merge(aportacionesCollectionAportaciones);
                if (oldPortafoliosOfAportacionesCollectionAportaciones != null) {
                    oldPortafoliosOfAportacionesCollectionAportaciones.getAportacionesCollection().remove(aportacionesCollectionAportaciones);
                    oldPortafoliosOfAportacionesCollectionAportaciones = em.merge(oldPortafoliosOfAportacionesCollectionAportaciones);
                }
            }
            for (Resultados resultadosCollectionResultados : portafolios.getResultadosCollection()) {
                Portafolios oldProtafoliosOfResultadosCollectionResultados = resultadosCollectionResultados.getProtafolios();
                resultadosCollectionResultados.setProtafolios(portafolios);
                resultadosCollectionResultados = em.merge(resultadosCollectionResultados);
                if (oldProtafoliosOfResultadosCollectionResultados != null) {
                    oldProtafoliosOfResultadosCollectionResultados.getResultadosCollection().remove(resultadosCollectionResultados);
                    oldProtafoliosOfResultadosCollectionResultados = em.merge(oldProtafoliosOfResultadosCollectionResultados);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Portafolios portafolios) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Portafolios persistentPortafolios = em.find(Portafolios.class, portafolios.getIdportafolios());
            Collection<Aportaciones> aportacionesCollectionOld = persistentPortafolios.getAportacionesCollection();
            Collection<Aportaciones> aportacionesCollectionNew = portafolios.getAportacionesCollection();
            Collection<Resultados> resultadosCollectionOld = persistentPortafolios.getResultadosCollection();
            Collection<Resultados> resultadosCollectionNew = portafolios.getResultadosCollection();
            List<String> illegalOrphanMessages = null;
            for (Aportaciones aportacionesCollectionOldAportaciones : aportacionesCollectionOld) {
                if (!aportacionesCollectionNew.contains(aportacionesCollectionOldAportaciones)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Aportaciones " + aportacionesCollectionOldAportaciones + " since its portafolios field is not nullable.");
                }
            }
            for (Resultados resultadosCollectionOldResultados : resultadosCollectionOld) {
                if (!resultadosCollectionNew.contains(resultadosCollectionOldResultados)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Resultados " + resultadosCollectionOldResultados + " since its protafolios field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Aportaciones> attachedAportacionesCollectionNew = new ArrayList<Aportaciones>();
            for (Aportaciones aportacionesCollectionNewAportacionesToAttach : aportacionesCollectionNew) {
                aportacionesCollectionNewAportacionesToAttach = em.getReference(aportacionesCollectionNewAportacionesToAttach.getClass(), aportacionesCollectionNewAportacionesToAttach.getIdaportaciones());
                attachedAportacionesCollectionNew.add(aportacionesCollectionNewAportacionesToAttach);
            }
            aportacionesCollectionNew = attachedAportacionesCollectionNew;
            portafolios.setAportacionesCollection(aportacionesCollectionNew);
            Collection<Resultados> attachedResultadosCollectionNew = new ArrayList<Resultados>();
            for (Resultados resultadosCollectionNewResultadosToAttach : resultadosCollectionNew) {
                resultadosCollectionNewResultadosToAttach = em.getReference(resultadosCollectionNewResultadosToAttach.getClass(), resultadosCollectionNewResultadosToAttach.getIdresultados());
                attachedResultadosCollectionNew.add(resultadosCollectionNewResultadosToAttach);
            }
            resultadosCollectionNew = attachedResultadosCollectionNew;
            portafolios.setResultadosCollection(resultadosCollectionNew);
            portafolios = em.merge(portafolios);
            for (Aportaciones aportacionesCollectionNewAportaciones : aportacionesCollectionNew) {
                if (!aportacionesCollectionOld.contains(aportacionesCollectionNewAportaciones)) {
                    Portafolios oldPortafoliosOfAportacionesCollectionNewAportaciones = aportacionesCollectionNewAportaciones.getPortafolios();
                    aportacionesCollectionNewAportaciones.setPortafolios(portafolios);
                    aportacionesCollectionNewAportaciones = em.merge(aportacionesCollectionNewAportaciones);
                    if (oldPortafoliosOfAportacionesCollectionNewAportaciones != null && !oldPortafoliosOfAportacionesCollectionNewAportaciones.equals(portafolios)) {
                        oldPortafoliosOfAportacionesCollectionNewAportaciones.getAportacionesCollection().remove(aportacionesCollectionNewAportaciones);
                        oldPortafoliosOfAportacionesCollectionNewAportaciones = em.merge(oldPortafoliosOfAportacionesCollectionNewAportaciones);
                    }
                }
            }
            for (Resultados resultadosCollectionNewResultados : resultadosCollectionNew) {
                if (!resultadosCollectionOld.contains(resultadosCollectionNewResultados)) {
                    Portafolios oldProtafoliosOfResultadosCollectionNewResultados = resultadosCollectionNewResultados.getProtafolios();
                    resultadosCollectionNewResultados.setProtafolios(portafolios);
                    resultadosCollectionNewResultados = em.merge(resultadosCollectionNewResultados);
                    if (oldProtafoliosOfResultadosCollectionNewResultados != null && !oldProtafoliosOfResultadosCollectionNewResultados.equals(portafolios)) {
                        oldProtafoliosOfResultadosCollectionNewResultados.getResultadosCollection().remove(resultadosCollectionNewResultados);
                        oldProtafoliosOfResultadosCollectionNewResultados = em.merge(oldProtafoliosOfResultadosCollectionNewResultados);
                    }
                }
            }
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

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
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
            List<String> illegalOrphanMessages = null;
            Collection<Aportaciones> aportacionesCollectionOrphanCheck = portafolios.getAportacionesCollection();
            for (Aportaciones aportacionesCollectionOrphanCheckAportaciones : aportacionesCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Portafolios (" + portafolios + ") cannot be destroyed since the Aportaciones " + aportacionesCollectionOrphanCheckAportaciones + " in its aportacionesCollection field has a non-nullable portafolios field.");
            }
            Collection<Resultados> resultadosCollectionOrphanCheck = portafolios.getResultadosCollection();
            for (Resultados resultadosCollectionOrphanCheckResultados : resultadosCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Portafolios (" + portafolios + ") cannot be destroyed since the Resultados " + resultadosCollectionOrphanCheckResultados + " in its resultadosCollection field has a non-nullable protafolios field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
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
      
        return (Portafolios)em.createNamedQuery("Portafolios.findByNombre").setParameter("valnombre", name).getSingleResult();
    }
}
