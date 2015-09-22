/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import JPAControllers.OperacionesJpaController;
import JPAControllers.exceptions.NonexistentEntityException;
import entity.Operaciones;
import entity.Portafolios;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author 60044723
 */
public class OperacionGestor {
    
    private final OperacionesJpaController controller;

    public OperacionGestor(EntityManagerFactory p_emf) {
        this.controller = new OperacionesJpaController(p_emf);
    }
    
    public void add_operacion(Date p_fecha,double p_cantidad, int p_portafolios, String p_tipo){
        Operaciones newOperacion = new Operaciones();
        newOperacion.setCantidad(p_cantidad);
        newOperacion.setFecha(p_fecha);
        newOperacion.setPortafolios(new Portafolios(p_portafolios));
        newOperacion.setTipooperacion(p_tipo);
        this.controller.create(newOperacion);
        
    }
    
     public List<Operaciones> get_operacionesList(){
       
        return this.controller.findOperacionesEntities();
    }
     
   public void delete_operaciones(int p_id) throws NonexistentEntityException{
       this.controller.destroy(p_id);
   }
   
   public void update_operaciones(double p_cantidad, Date p_fecha,int p_portafolios, String p_tipo,int p_idoperacion) throws Exception{
       Operaciones new_operacion = new Operaciones();
       new_operacion.setCantidad(p_cantidad);
       new_operacion.setFecha(p_fecha); 
       new_operacion.setPortafolios(new Portafolios(p_portafolios));
       new_operacion.setTipooperacion(p_tipo);
       new_operacion.setIdaportaciones(p_idoperacion);
       this.controller.edit(new_operacion);
   }
    
   public double get_operaciones_totales(int p_portafolios, Date p_fecha, String p_tipo){
       return this.controller.getSumOperacion(p_portafolios, p_fecha,p_tipo);
   }
   
   public List<Operaciones> get_aportaciones_by_portafolios(int p_idportafolios,String p_tipooperacion){
     return  this.controller.get_aportaciones_by_portafolios(p_idportafolios,p_tipooperacion);
   }
   
   public Operaciones find_operacionbyid(int p_idoperacion){
      return this.controller.findOperaciones(p_idoperacion);
   }
}
