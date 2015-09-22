/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entity.Portafolios;
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
public class PortafolioGestorTest {
    
    private final PortafolioGestor portafoliosGestor;
    
    public PortafolioGestorTest() {
        this.portafoliosGestor = new PortafolioGestor(Persistence.createEntityManagerFactory("StockTrackerPU"));
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

        /**
     * Test of add_portafolio method, of class PortafolioGestor.
     */
    @Test
    public void testAdd_portafolio() throws Exception {
        System.out.println("add_portafolio");
        String p_nombre = "Test Portafolios1";
        double p_valorinicial = 90.453;
        String p_fechainicial = "2015-08-20";
        PortafolioGestor instance = this.portafoliosGestor;
        instance.add_portafolio(p_nombre, p_valorinicial, p_fechainicial);
       
    }

    /**
     * Test of get_portafoliosList method, of class PortafolioGestor.
     */
    @Test
    public void testGet_portafoliosList() {
        System.out.println("get_portafoliosList");
        PortafolioGestor instance = this.portafoliosGestor;
        int expResult = 4;
        List<Portafolios> result = instance.get_portafoliosList();
        
       
        assertEquals(expResult, result.size());
       
       
    }

    /**
     * Test of find_portafoliosbyname method, of class PortafolioGestor.
     */
    @Test
    public void testFind_portafoliosbyname() {
        System.out.println("find_portafoliosbyname");
        String p_name = "Test Portafolios1";
        PortafolioGestor instance = this.portafoliosGestor;
        Portafolios expResult = new Portafolios(5);
        Portafolios result = instance.find_portafoliosbyname(p_name);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of delete_portafolio method, of class PortafolioGestor.
     */
    
    @Test
    public void testUpdate_portafolios() throws Exception {
        System.out.println("update_portafolios");
        Portafolios p_portafolios = null;
        PortafolioGestor instance = this.portafoliosGestor;
        instance.update_portafolios(p_portafolios);
        
    }
    
    @Test
    public void testDelete_portafolio() throws Exception {
        System.out.println("delete_portafolio");
        int p_id = 9;
        PortafolioGestor instance = this.portafoliosGestor;
        instance.delete_portafolio(p_id);
       
    }

    /**
     * Test of update_portafolios method, of class PortafolioGestor.
     */
    
    
}
