/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Persistencia.Licencia;
import Persistencia.Persona;
import java.util.Date;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author JIC
 */
public class LicenciaControllerTest {
    
    public LicenciaControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getLicencias method, of class LicenciaController.
     */
    @Test
    public void testGetLicencias() {
        System.out.println("getLicencias");
        LicenciaController instance = new LicenciaController();
        List<Licencia> expResult = null;
        List<Licencia> result = instance.getLicencias();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPersona method, of class LicenciaController.
     */
    @Test
    public void testGetPersona() {
        System.out.println("getPersona");
        int id = 0;
        LicenciaController instance = new LicenciaController();
        Persona expResult = null;
        Persona result = instance.getPersona(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getVigencia method, of class LicenciaController.
     */
    @Test
    public void testGetVigencia() {
        System.out.println("getVigencia");
        Licencia licencia = null;
        LicenciaController instance = new LicenciaController();
        int expResult = 0;
//        Date result = instance.getVigencia(licencia);
//        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
