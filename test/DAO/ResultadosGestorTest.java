/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entity.Resultados;
import java.text.DateFormat;
import java.text.DecimalFormat;
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
public class ResultadosGestorTest {
    
    private final ResultadosGestor resultadoController;
    private final DateFormat fecha_format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public ResultadosGestorTest() {
        this.resultadoController = new ResultadosGestor(Persistence.createEntityManagerFactory("StockTrackerPU"));
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of add_resultados method, of class ResultadosGestor.
     */
    @Test
    public void testAdd_resultados() throws ParseException {
        System.out.println("add_resultados");
         
         DateFormat fecha_format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        
         Date fecha = new Date();
         String sfecha = fecha_format.format(fecha);
        ResultadosGestor instance = this.resultadoController;
        
        instance.add_resultados(fecha_format.parse(sfecha),6,5101.89,100,.029787);
        
    }

    /**
     * Test of get_aportacionesList method, of class ResultadosGestor.
     */
    @Test
    public void testGet_aportacionesList() {
        System.out.println("get_aportacionesList");
        int p_idportafolios = 6;
        ResultadosGestor instance = this.resultadoController;
       
        List<Resultados> result = instance.get_aportacionesList(p_idportafolios);
        assertNotNull(result);
        
    }

    /**
     * Test of delete_aportaciones method, of class ResultadosGestor.
     */
    //@Test
    public void testDelete_aportaciones() throws Exception {
        System.out.println("delete_aportaciones");
        int p_id = 1;
        ResultadosGestor instance = this.resultadoController;
        instance.delete_aportaciones(p_id);
        
    }

    /**
     * Test of update_resultado method, of class ResultadosGestor.
     */
  //  @Test
    public void testUpdate_resultado() throws Exception {
        System.out.println("update_resultado");
        Resultados p_resultado = null;
        ResultadosGestor instance = null;
        instance.update_resultado(p_resultado);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calculate_profit method, of class ResultadosGestor.
     */
    @Test
    public void testCalculate_profit() throws ParseException {
        System.out.println("calculate_profit");
        double p_valor = 11000;
        int p_portafolios = 6;
  
        ResultadosGestor instance = this.resultadoController;
        double expResult = 0.0;
        double result = instance.calculate_profit(p_valor, p_portafolios, fecha_format.parse(fecha_format.format(new Date())));
        assertEquals(expResult, result, 0.0);
        
    }

    /**
     * Test of calculate_rendimiento method, of class ResultadosGestor.
     */
    @Test
    public void testCalculate_rendimiento() throws ParseException {
        System.out.println("calculate_rendimiento");
        ResultadosGestor instance = this.resultadoController;
         double p_valor = 11000;
        int p_portafolios = 6;
        double p_profit = instance.calculate_profit(p_valor, p_portafolios, fecha_format.parse(fecha_format.format(new Date())));
        
        double expResult = 0.0876;
        double result = instance.calculate_rendimiento(p_valor, p_profit);
        DecimalFormat format = new DecimalFormat("#.####"); 
        String sresult = format.format(result);
        assertEquals(expResult, Double.parseDouble(sresult), 0.0);
  
    }
    
}
