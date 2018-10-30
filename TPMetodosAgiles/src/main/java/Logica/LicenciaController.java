/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Persistencia.Licencia;
import Persistencia.Persona;
import Persistencia.Vigencias;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

/**
 *
 * @author JIC
 */
public class LicenciaController {
    
    private LicenciaDAO LicenciaDAO;
    
    public enum Motivo{ORIGINAL, RENOVACION}
    
    public LicenciaController(){
        this.LicenciaDAO = new LicenciaDAO();
    }
    
    public List<Licencia> getLicencias(){
        return LicenciaDAO.readAll();
    }   
    
    public Persona getPersona(int id){
              
        PersonaController personaController = new PersonaController();
        
        return personaController.getPersona(id);
    }
    
    public Date getVigencia(Licencia licencia,Date fechaNacimiento) throws ParseException{
        
        PersonaController personaController = new PersonaController();
        VigenciaController vigenciaController = new VigenciaController();

        List<Vigencias> listaVigencias = vigenciaController.getVigencias();
             
        Calendar fechaVigencia = Calendar.getInstance();
        fechaVigencia.setTime(licencia.getFechaEmision());
        
        int edad = personaController.getEdad(fechaNacimiento);
        
        if(edad < 21){
            if(licencia.getMotivo().equals(Motivo.ORIGINAL.toString())){
                
                fechaVigencia.add(Calendar.YEAR, listaVigencias.get(0).getDuracion());
                
            }
            if(licencia.getMotivo().equals(Motivo.RENOVACION.toString())){
                
                fechaVigencia.add(Calendar.YEAR, listaVigencias.get(1).getDuracion()); 
                
            }
        }
        if(edad >=21 && edad <= 46){
            
            fechaVigencia.add(Calendar.YEAR, listaVigencias.get(2).getDuracion()); 
            
        }
        if(edad>46 && edad <= 60){
            
            fechaVigencia.add(Calendar.YEAR, listaVigencias.get(3).getDuracion());
            
        }
        if(edad >60 && edad <= 70){
            
            fechaVigencia.add(Calendar.YEAR, listaVigencias.get(4).getDuracion());
            
        }
        if(edad > 70){
           
           fechaVigencia.add(Calendar.YEAR, listaVigencias.get(5).getDuracion());
           
        }
        Calendar c = Calendar.getInstance();
        c.setTime(fechaNacimiento);
        fechaVigencia.set(Calendar.DAY_OF_MONTH, c.get(Calendar.DAY_OF_MONTH));
        fechaVigencia.set(Calendar.MONTH, c.get(Calendar.MONTH));
        
        return fechaVigencia.getTime();
    }
    
    
    
}
