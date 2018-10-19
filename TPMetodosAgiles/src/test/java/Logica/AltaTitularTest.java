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
        
        
        //TEST CORRECTOS
        
        //dni
        String numDocumento="39765432";
        String nombre = "Juan";
        String apellido = "Perez";
        String dia = "1";
        String mes = "1";
        String anio = "1990";
        String calle = "Francia";
        String numeroCalle = "345";
        String piso = "1";
        String depart = "A";
        String grupoSanguineo="AB";
        boolean[] rtdo=p.validarDatos(PersonaController.TipoDocumento.DNI, numDocumento, nombre, apellido, dia, mes, anio, calle, numeroCalle, piso, depart, grupoSanguineo);
        for(int i=0;i<13;i++) assertEquals(true, rtdo[i]);

        
        //cuit y cuil
        numDocumento = "20398765433";
        rtdo=p.validarDatos(PersonaController.TipoDocumento.CUIT, numDocumento, nombre, apellido, dia, mes, anio, calle, numeroCalle, piso, depart, grupoSanguineo);
        for(int i=0;i<13;i++) assertEquals(true, rtdo[i]);
        
        
        
        //TEST ERRONEOS
        
        
        //numdocumento (longitud muy corta)
        numDocumento="12";
        rtdo=p.validarDatos(PersonaController.TipoDocumento.CUIT, numDocumento, nombre, apellido, dia, mes, anio, calle, numeroCalle, piso, depart, grupoSanguineo);
        assertEquals(false, rtdo[0]);
        
        //numdocumento (caracteres erroneos)
        numDocumento="12avb+&c";
        rtdo=p.validarDatos(PersonaController.TipoDocumento.CUIT, numDocumento, nombre, apellido, dia, mes, anio, calle, numeroCalle, piso, depart, grupoSanguineo);
        assertEquals(false, rtdo[0]);
        
        //nombre (caracteres erroneos)
        numDocumento="20397654323";
        nombre = "Juan78";
        rtdo=p.validarDatos(PersonaController.TipoDocumento.CUIT, numDocumento, nombre, apellido, dia, mes, anio, calle, numeroCalle, piso, depart, grupoSanguineo);
        assertEquals(false, rtdo[1]);
        
        //apellido (caracteres erroneos)
        nombre = "Juan";
        apellido="Perez74";
        rtdo=p.validarDatos(PersonaController.TipoDocumento.CUIT, numDocumento, nombre, apellido, dia, mes, anio, calle, numeroCalle, piso, depart, grupoSanguineo);
        assertEquals(false, rtdo[2]);
        
        //dia (mayor a los dias de su mes)
        apellido="Perez";
        dia="32";
        rtdo=p.validarDatos(PersonaController.TipoDocumento.CUIT, numDocumento, nombre, apellido, dia, mes, anio, calle, numeroCalle, piso, depart, grupoSanguineo);
        assertEquals(false, rtdo[3]);
        
        //dia (caracteres erroneos)
        dia="32a";
        rtdo=p.validarDatos(PersonaController.TipoDocumento.CUIT, numDocumento, nombre, apellido, dia, mes, anio, calle, numeroCalle, piso, depart, grupoSanguineo);
        assertEquals(false, rtdo[3]);
        
        //mes (mayor a 12)
        dia="1";
        mes="13";
        rtdo=p.validarDatos(PersonaController.TipoDocumento.CUIT, numDocumento, nombre, apellido, dia, mes, anio, calle, numeroCalle, piso, depart, grupoSanguineo);
        assertEquals(false, rtdo[4]);
        
        //mes (caracteres erroneos)
        mes="13a";
        rtdo=p.validarDatos(PersonaController.TipoDocumento.CUIT, numDocumento, nombre, apellido, dia, mes, anio, calle, numeroCalle, piso, depart, grupoSanguineo);
        assertEquals(false, rtdo[4]);
        
        //anio (caracteres erroneos)
        mes="1";
        anio="1800a";
        rtdo=p.validarDatos(PersonaController.TipoDocumento.CUIT, numDocumento, nombre, apellido, dia, mes, anio, calle, numeroCalle, piso, depart, grupoSanguineo);
        assertEquals(false, rtdo[5]);
        
        //calle (caracteres erroneos)
        anio="1990";
        calle="Francia75";
        rtdo=p.validarDatos(PersonaController.TipoDocumento.CUIT, numDocumento, nombre, apellido, dia, mes, anio, calle, numeroCalle, piso, depart, grupoSanguineo);
        assertEquals(false, rtdo[6]);
        
        //numero de calle (caracteres erroneos)
        calle="Francia";
        numeroCalle="ab";
        rtdo=p.validarDatos(PersonaController.TipoDocumento.CUIT, numDocumento, nombre, apellido, dia, mes, anio, calle, numeroCalle, piso, depart, grupoSanguineo);
        assertEquals(false, rtdo[7]);
        
        //piso (caracteres erroneos)
        numeroCalle="345";
        piso="a";
        rtdo=p.validarDatos(PersonaController.TipoDocumento.CUIT, numDocumento, nombre, apellido, dia, mes, anio, calle, numeroCalle, piso, depart, grupoSanguineo);
        assertEquals(false, rtdo[8]);
        
        //departamento (mas de dos caracteres)
        piso="1";
        depart="123";
        rtdo=p.validarDatos(PersonaController.TipoDocumento.CUIT, numDocumento, nombre, apellido, dia, mes, anio, calle, numeroCalle, piso, depart, grupoSanguineo);
        assertEquals(false, rtdo[9]);
        
        //grupo sanguineo (caracteres erroneos)
        depart="A";
        grupoSanguineo="1";
        rtdo=p.validarDatos(PersonaController.TipoDocumento.CUIT, numDocumento, nombre, apellido, dia, mes, anio, calle, numeroCalle, piso, depart, grupoSanguineo);
        assertEquals(false, rtdo[10]);
        
        //edad menor a 17
        grupoSanguineo="A";
        anio="2010";
        rtdo=p.validarDatos(PersonaController.TipoDocumento.CUIT, numDocumento, nombre, apellido, dia, mes, anio, calle, numeroCalle, piso, depart, grupoSanguineo);
        assertEquals(false, rtdo[11]);
        
        
        
       
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
