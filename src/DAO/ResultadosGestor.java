/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import JPAControllers.OperacionesJpaController;
import JPAControllers.PortafoliosJpaController;
import JPAControllers.ResultadosJpaController;
import JPAControllers.exceptions.NonexistentEntityException;
import entity.Portafolios;
import entity.Resultados;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author 60044723
 */
public class ResultadosGestor {
    
    private final ResultadosJpaController controller;
    private final PortafoliosJpaController controllerPortafolios;
    private final OperacionesJpaController controllerOperaciones;
   
    public ResultadosGestor(EntityManagerFactory p_emf) {
        this.controller = new ResultadosJpaController(p_emf);
        this.controllerOperaciones = new OperacionesJpaController(p_emf);
        this.controllerPortafolios  = new PortafoliosJpaController(p_emf);
    }
    
    public void add_resultados(Date p_fecha, int p_portafolios,
                               double p_valor, double p_profit,
                               double p_rendimiento){
        
       
        Resultados new_resultado = new Resultados();
        new_resultado.setFecha(p_fecha);
        new_resultado.setProtafolios(new Portafolios(p_portafolios));
        new_resultado.setValor(p_valor);
        new_resultado.setProfit(p_profit);
        new_resultado.setRendimiento(p_rendimiento);
        this.controller.create(new_resultado);
    }
    
    public List<Resultados> get_aportacionesList(int p_idportafolios){
        return controller.getResultadosByPortafolios(p_idportafolios);
    }
    
    public void delete_aportaciones(int p_id) throws NonexistentEntityException{
        this.controller.destroy(p_id);
    }
    
    public void update_resultado(Resultados p_resultado) throws Exception{
        this.controller.edit(p_resultado);
    }
    
    public double calculate_profit(double p_valor, int p_portafolios, Date p_fecha) throws ParseException{
        DateFormat fecha_format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        
        Portafolios currentPortafolios = this.controllerPortafolios.findPortafolios(p_portafolios);
        double aportaciones            = this.controllerOperaciones.getSumOperacion(p_portafolios, 
                                         fecha_format.parse(fecha_format.format(p_fecha)),"AP");
        double retiros                =  this.controllerOperaciones.getSumOperacion(p_portafolios, 
                                         fecha_format.parse(fecha_format.format(p_fecha)),"RT");
        
        return p_valor -(currentPortafolios.getValorinicial() + aportaciones - retiros );
    }

    public double calculate_rendimiento(int p_portafolios, double p_profit,Date p_fecha) throws ParseException{
        
         DateFormat fecha_format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        
        Portafolios currentPortafolios = this.controllerPortafolios.findPortafolios(p_portafolios);
        double      aportaciones       = this.controllerOperaciones.getSumOperacion(p_portafolios, 
                                         fecha_format.parse(fecha_format.format(p_fecha)),"AP");
        double retiros                =  this.controllerOperaciones.getSumOperacion(p_portafolios, 
                                         fecha_format.parse(fecha_format.format(p_fecha)),"RT");  
        return p_profit  / (currentPortafolios.getValorinicial() + aportaciones - retiros);
    }
    
    public Resultados get_resultadobyid(int p_idresultado){
       return this.controller.findResultados(p_idresultado);
    }
}
