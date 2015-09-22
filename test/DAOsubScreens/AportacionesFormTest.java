/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOsubScreens;

import javax.swing.DefaultComboBoxModel;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 60044723
 */
public class AportacionesFormTest {
    
    public AportacionesFormTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    @Test
    public void testSomeMethod() {
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of get_portafolios method, of class AportacionesForm.
     */
    @Test
    public void testGet_portafolios() {
        System.out.println("get_portafolios");
        AportacionesForm instance = null;
        DefaultComboBoxModel expResult = null;
        DefaultComboBoxModel result = instance.get_portafolios();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
