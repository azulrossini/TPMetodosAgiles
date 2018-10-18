/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Fausto
 */
public class AltaTitularTest {
    PersonaController p = new PersonaController();
    public AltaTitularTest() {
        
        //Test correcto dni
        String numDocumento="39765432";
        String nombre = "Juan";
        String apellido = "Perez";
        int dia = 1;
        int mes = 1;
        int anio = 1990;
        String calle = "Francia";
        int numeroCalle = 345;
        int piso = 1;
        String depart = "A";
        String grupoSanguineo="AB";
        char rh='+';
        boolean rtdo=p.validarDatos(PersonaController.TipoDocumento.DNI, numDocumento, nombre, apellido, dia, mes, anio, calle, numeroCalle, piso, depart, grupoSanguineo, rh);
        assertEquals(true, rtdo);
        
        //Test correcto cuit y cuil
        numDocumento = "20398765433";
         rtdo=p.validarDatos(PersonaController.TipoDocumento.CUIT, numDocumento, nombre, apellido, dia, mes, anio, calle, numeroCalle, piso, depart, grupoSanguineo, rh);
        assertEquals(true, rtdo);
        
        //Test erroneo numdocumento
        numDocumento="12";
        rtdo=p.validarDatos(PersonaController.TipoDocumento.CUIT, numDocumento, nombre, apellido, dia, mes, anio, calle, numeroCalle, piso, depart, grupoSanguineo, rh);
        assertEquals(false, rtdo);
        
       
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

   
}
