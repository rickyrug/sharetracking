/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entity.Operaciones;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.Persistence;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 60044723
 */
public class OperacionGestorTest {
    
    private final OperacionGestor controller;
    private DateFormat fecha_format ;
    public OperacionGestorTest() {
        this.controller = new OperacionGestor(Persistence.createEntityManagerFactory("StockTrackerPU"));
        this.fecha_format =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
       }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of add_operacion method, of class OperacionGestor.
     */
    @Test
    public void testAdd_operacion() throws ParseException {
        System.out.println("add_operacion");
        Date sysdate = new Date();
//        Date p_fecha = fecha_format.format(sysdate);
        double p_cantidad =1000;
        int p_portafolios = 6;
        String p_tipo = "AP";
        OperacionGestor instance = this.controller;
        instance.add_operacion(fecha_format.parse(fecha_format.format(sysdate)), p_cantidad, p_portafolios, p_tipo);
        
    }

    /**
     * Test of get_operacionesList method, of class OperacionGestor.
     */
    @Test
    public void testGet_operacionesList() {
        System.out.println("get_operacionesList");
        OperacionGestor instance = this.controller;
       
        List<Operaciones> result = instance.get_operacionesList();
       
        for(int i = 0; i < result.size();i++){
        
            System.out.println(result.get(i).getPortafolios() +" cantidad: "+result.get(i).getCantidad());
        }
        
       
    }

    /**
     * Test of delete_operaciones method, of class OperacionGestor.
     */
    @Test
    public void testDelete_operaciones() throws Exception {
        System.out.println("delete_operaciones");
        int p_id = 3;
        OperacionGestor instance = this.controller;
        instance.delete_operaciones(p_id);
        
    }

    /**
     * Test of update_operaciones method, of class OperacionGestor.
     */
   // @Test
    public void testUpdate_operaciones() throws Exception {
        System.out.println("update_aportaciones");
        double p_cantidad = 4000;
        int p_portafolios = 6;
        String p_tipo = "AP";
        int p_idoperacion = 2;
        OperacionGestor instance = this.controller;
        instance.update_operaciones(p_cantidad, fecha_format.parse(fecha_format.format(new Date())), 
                                    p_portafolios, p_tipo,p_idoperacion);
       
    }

    /**
     * Test of get_operaciones_totales method, of class OperacionGestor.
     */
    @Test
    public void testGet_operaciones_totales() throws ParseException {
        System.out.println("get_operaciones_totales");
        int p_portafolios = 6;
        String p_tipo = "AP";
        OperacionGestor instance = this.controller;
        double expResult = 5000.0;
        double result = instance.get_operaciones_totales(p_portafolios, fecha_format.parse(fecha_format.format(new Date())), p_tipo);
        assertEquals(expResult, result, 0.0);
        
    }

    /**
     * Test of get_aportaciones_by_portafolios method, of class OperacionGestor.
     */
    @Test
    public void testGet_aportaciones_by_portafolios() {
        System.out.println("get_aportaciones_by_portafolios");
        int p_idportafolios = 0;
        String p_tipo         = "AP";
        OperacionGestor instance = this.controller;
       
        List<Operaciones> result = instance.get_aportaciones_by_portafolios(p_idportafolios,p_tipo);
        assertNotNull(result);

    }
    
}
