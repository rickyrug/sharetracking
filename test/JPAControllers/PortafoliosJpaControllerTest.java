/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPAControllers;

import entity.Portafolios;
import java.util.List;
import javax.persistence.EntityManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 60044723
 */
public class PortafoliosJpaControllerTest {
    
    public PortafoliosJpaControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getEntityManager method, of class PortafoliosJpaController.
     */
    @Test
    public void testGetEntityManager() {
        System.out.println("getEntityManager");
        PortafoliosJpaController instance = null;
        EntityManager expResult = null;
        EntityManager result = instance.getEntityManager();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of create method, of class PortafoliosJpaController.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        Portafolios portafolios = null;
        PortafoliosJpaController instance = null;
        instance.create(portafolios);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of edit method, of class PortafoliosJpaController.
     */
    @Test
    public void testEdit() throws Exception {
        System.out.println("edit");
        Portafolios portafolios = null;
        PortafoliosJpaController instance = null;
        instance.edit(portafolios);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of destroy method, of class PortafoliosJpaController.
     */
    @Test
    public void testDestroy() throws Exception {
        System.out.println("destroy");
        Integer id = null;
        PortafoliosJpaController instance = null;
        instance.destroy(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findPortafoliosEntities method, of class PortafoliosJpaController.
     */
    @Test
    public void testFindPortafoliosEntities_0args() {
        System.out.println("findPortafoliosEntities");
        PortafoliosJpaController instance = null;
        List<Portafolios> expResult = null;
        List<Portafolios> result = instance.findPortafoliosEntities();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findPortafoliosEntities method, of class PortafoliosJpaController.
     */
    @Test
    public void testFindPortafoliosEntities_int_int() {
        System.out.println("findPortafoliosEntities");
        int maxResults = 0;
        int firstResult = 0;
        PortafoliosJpaController instance = null;
        List<Portafolios> expResult = null;
        List<Portafolios> result = instance.findPortafoliosEntities(maxResults, firstResult);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findPortafolios method, of class PortafoliosJpaController.
     */
    @Test
    public void testFindPortafolios() {
        System.out.println("findPortafolios");
        Integer id = null;
        PortafoliosJpaController instance = null;
        Portafolios expResult = null;
        Portafolios result = instance.findPortafolios(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPortafoliosCount method, of class PortafoliosJpaController.
     */
    @Test
    public void testGetPortafoliosCount() {
        System.out.println("getPortafoliosCount");
        PortafoliosJpaController instance = null;
        int expResult = 0;
        int result = instance.getPortafoliosCount();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
