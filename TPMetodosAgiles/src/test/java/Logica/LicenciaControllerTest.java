/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Logica.LicenciaController.Motivo;
import Persistencia.Licencia;
import Persistencia.Persona;
import Persistencia.Vigencias;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ale_b
 */
public class LicenciaControllerTest {
    
    VigenciaController vigenciaController = new VigenciaController();
    LicenciaController licenciaController = new LicenciaController();
    
    
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
    public void LicenciaControllerTest() {
        Vigencias vigencia= new Vigencias();
        Date fechaV = new Date();
        Calendar fechaHoy= Calendar.getInstance();
        
       String condicion1 = "primera_menor_21";
       String condicion2 = "segunda_menor_21";
       String condicion3 = "menor_46";
       String condicion4 = "menor_60";
       String condicion5 = "menor_70";
       String condicion6 = "mayor_70";
       
       int anio1= 1;
       int anio3= 3;
       int anio4= 4;
       int anio5= 5;
       
       Calendar fecha = Calendar.getInstance();
       
       fecha.set(2000, 0, 30);
       vigencia = vigenciaController.getVigencia(Motivo.ORIGINAL.toString(), fecha.getTime());
       assertEquals(condicion1, vigencia.getCondicion());
       assertEquals(anio1, vigencia.getDuracion());
       Assert.assertFalse(anio3==vigencia.getDuracion());
       
       fechaV=licenciaController.getFechaVigencia(vigencia, fecha.getTime());
       fechaHoy.add(Calendar.YEAR, vigencia.getDuracion());
       fechaHoy.set(Calendar.DAY_OF_MONTH, fecha.get(Calendar.DAY_OF_MONTH));
       fechaHoy.set(Calendar.MONTH, fecha.get(Calendar.MONTH));
       assertEquals(fechaHoy.getTime().getYear(), fechaV.getYear());
       assertEquals(fechaHoy.getTime().getMonth(), fechaV.getMonth());
       assertEquals(fechaHoy.getTime().getDay(), fechaV.getDay());
       
       vigencia = vigenciaController.getVigencia(Motivo.RENOVACION.toString(), fecha.getTime());
       assertEquals(condicion2, vigencia.getCondicion());
       assertEquals(anio3, vigencia.getDuracion());
       
       fechaHoy = Calendar.getInstance();
       
       fechaV=licenciaController.getFechaVigencia(vigencia, fecha.getTime());
       fechaHoy.add(Calendar.YEAR, vigencia.getDuracion());
       fechaHoy.set(Calendar.DAY_OF_MONTH, fecha.get(Calendar.DAY_OF_MONTH));
       fechaHoy.set(Calendar.MONTH, fecha.get(Calendar.MONTH));
       assertEquals(fechaHoy.getTime().getYear(), fechaV.getYear());
       assertEquals(fechaHoy.getTime().getMonth(), fechaV.getMonth());
       assertEquals(fechaHoy.getTime().getDay(), fechaV.getDay());
       
       fecha.set(1985, 5, 12);
       vigencia = vigenciaController.getVigencia(Motivo.RENOVACION.toString(), fecha.getTime());
       assertEquals(condicion3, vigencia.getCondicion());
       assertEquals(anio5, vigencia.getDuracion());
       
       fechaHoy = Calendar.getInstance();
       
       fechaV=licenciaController.getFechaVigencia(vigencia, fecha.getTime());
       fechaHoy.add(Calendar.YEAR, vigencia.getDuracion());
       fechaHoy.set(Calendar.DAY_OF_MONTH, fecha.get(Calendar.DAY_OF_MONTH));
       fechaHoy.set(Calendar.MONTH, fecha.get(Calendar.MONTH));
       assertEquals(fechaHoy.getTime().getYear(), fechaV.getYear());
       assertEquals(fechaHoy.getTime().getMonth(), fechaV.getMonth());
       assertEquals(fechaHoy.getTime().getDay(), fechaV.getDay());
       
       fecha.set(1960, 8, 25);
       vigencia = vigenciaController.getVigencia(Motivo.RENOVACION.toString(), fecha.getTime());
       assertEquals(condicion4, vigencia.getCondicion());
       assertEquals(anio4, vigencia.getDuracion());
       
       fechaHoy = Calendar.getInstance();
       
       fechaV=licenciaController.getFechaVigencia(vigencia, fecha.getTime());
       fechaHoy.add(Calendar.YEAR, vigencia.getDuracion());
       fechaHoy.set(Calendar.DAY_OF_MONTH, fecha.get(Calendar.DAY_OF_MONTH));
       fechaHoy.set(Calendar.MONTH, fecha.get(Calendar.MONTH));
       assertEquals(fechaHoy.getTime().getYear(), fechaV.getYear());
       assertEquals(fechaHoy.getTime().getMonth(), fechaV.getMonth());
       assertEquals(fechaHoy.getTime().getDay(), fechaV.getDay());
       
       fecha.set(1950, 11, 10);
       vigencia = vigenciaController.getVigencia(Motivo.RENOVACION.toString(), fecha.getTime());
       assertEquals(condicion5, vigencia.getCondicion());
       assertEquals(anio3, vigencia.getDuracion());
       
       fechaHoy = Calendar.getInstance();
       
       fechaV=licenciaController.getFechaVigencia(vigencia, fecha.getTime());
       fechaHoy.add(Calendar.YEAR, vigencia.getDuracion());
       fechaHoy.set(Calendar.DAY_OF_MONTH, fecha.get(Calendar.DAY_OF_MONTH));
       fechaHoy.set(Calendar.MONTH, fecha.get(Calendar.MONTH));
       assertEquals(fechaHoy.getTime().getYear(), fechaV.getYear());
       assertEquals(fechaHoy.getTime().getMonth(), fechaV.getMonth());
       assertEquals(fechaHoy.getTime().getDay(), fechaV.getDay());
       
       fecha.set(1945, 4, 15);
       vigencia = vigenciaController.getVigencia(Motivo.RENOVACION.toString(), fecha.getTime());
       assertEquals(condicion6, vigencia.getCondicion());
       assertEquals(anio1, vigencia.getDuracion());
       
       fechaHoy = Calendar.getInstance();
       
       fechaV=licenciaController.getFechaVigencia(vigencia, fecha.getTime());
       fechaHoy.add(Calendar.YEAR, vigencia.getDuracion());
       fechaHoy.set(Calendar.DAY_OF_MONTH, fecha.get(Calendar.DAY_OF_MONTH));
       fechaHoy.set(Calendar.MONTH, fecha.get(Calendar.MONTH));
       assertEquals(fechaHoy.getTime().getYear(), fechaV.getYear());
       assertEquals(fechaHoy.getTime().getMonth(), fechaV.getMonth());
       assertEquals(fechaHoy.getTime().getDay(), fechaV.getDay());
       
       
       assertEquals(true, licenciaController.validarClaseNuevoTitular("A"));
       assertEquals(true, licenciaController.validarClaseNuevoTitular("B"));
       assertEquals(true, licenciaController.validarClaseNuevoTitular("F"));
       assertEquals(true, licenciaController.validarClaseNuevoTitular("G"));
       assertEquals(false, licenciaController.validarClaseNuevoTitular("C"));
       assertEquals(false, licenciaController.validarClaseNuevoTitular("D"));
       assertEquals(false, licenciaController.validarClaseNuevoTitular("E"));
       
       
    }

    
    
}
