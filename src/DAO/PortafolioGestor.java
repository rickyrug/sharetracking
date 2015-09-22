/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import JPAControllers.PortafoliosJpaController;
import JPAControllers.exceptions.IllegalOrphanException;
import JPAControllers.exceptions.NonexistentEntityException;
import entity.Portafolios;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author 60044723
 */
public class PortafolioGestor {
    
    private final PortafoliosJpaController controller;

    public PortafolioGestor(EntityManagerFactory p_emf) {
        controller = new PortafoliosJpaController(p_emf);
    }
    
    public List<Portafolios> get_portafoliosList(){
       
        return this.controller.findPortafoliosEntities();
    }
    
    public void add_portafolio(String p_nombre, double p_valorinicial, String p_fechainicial) throws ParseException{  
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Portafolios p_newPortafolio = new Portafolios(null, p_nombre, p_valorinicial, formatter.parse(p_fechainicial));
       
        this.controller.create(p_newPortafolio);
        
    }
    
    public Portafolios find_portafoliosbyname(String p_name){
       return this.controller.findbyname(p_name);
    }
    
    public void delete_portafolio(int p_id) throws IllegalOrphanException, NonexistentEntityException{
    
        this.controller.destroy(p_id);
    }
    
    public void update_portafolios(Portafolios p_portafolios) throws NonexistentEntityException, Exception{
        this.controller.edit(p_portafolios);
    }
}
