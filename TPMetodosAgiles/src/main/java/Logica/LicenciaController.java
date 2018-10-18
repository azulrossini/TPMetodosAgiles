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
        
        Persona p;      
        PersonaController personaController = new PersonaController();
        
        p = personaController.getPersona(id);
        
        return p;
    }
    
    public Object getVigencia(Licencia licencia) throws ParseException{
        
        PersonaController personaController = new PersonaController();
        VigenciaController vigenciaController = new VigenciaController();
        
        Persona persona = personaController.getPersona(licencia.getPersonaId());
        List<Vigencias> listaVigencias = vigenciaController.getVigencias();
        
                
        Calendar fechaVigencia = Calendar.getInstance();
        fechaVigencia.setTime(persona.getFechaNac());
        
        //HAB
        
        int edad = this.getEdad(persona.getFechaNac());
        
        if(edad < 21){
            if(licencia.getMotivo().equals(Motivo.ORIGINAL.toString())){
               
               fechaVigencia.add(Calendar.YEAR, listaVigencias.get(0).getPrimeraMenor21());
                
            }
            if(licencia.getMotivo().equals(Motivo.RENOVACION.toString())){
                
               fechaVigencia.add(Calendar.YEAR, listaVigencias.get(0).getSegundaMenor21()); 
                
            }
        }
        if(edad <= 46){
            
            fechaVigencia.add(Calendar.YEAR, listaVigencias.get(0).getMenor46()); 
            
        }
        if(edad <= 60){
            
            fechaVigencia.add(Calendar.YEAR, listaVigencias.get(0).getMenor60());
            
        }
        if(edad <= 70){
            
            fechaVigencia.add(Calendar.YEAR, listaVigencias.get(0).getMenor70());
            
        }
        if(edad > 70){
            
           fechaVigencia.add(Calendar.YEAR, listaVigencias.get(0).getMayor70());
           
        }
        
        SimpleDateFormat mdyFormat = new SimpleDateFormat("dd/MM/yyyy");
        String mdy = mdyFormat.format(fechaVigencia);
        
        return mdy;
    }
    
    public int getEdad(Date fechaNacimiento){
        
        if(fechaNacimiento!=null){
            
            Calendar c = new GregorianCalendar();
            c.setTime(fechaNacimiento);
            
            Calendar today = Calendar.getInstance();
            int diffYear = today.get(Calendar.YEAR) - c.get(Calendar.YEAR);
            int diffMonth = today.get(Calendar.MONTH) - c.get(Calendar.MONTH);
            int diffDay = today.get(Calendar.DAY_OF_MONTH) - c.get(Calendar.DAY_OF_MONTH);
            
            // Si está en ese año pero todavía no los ha cumplido
            if (diffMonth < 0 || (diffMonth == 0 && diffDay < 0)) {
                diffYear = diffYear - 1;
            }
            return diffYear;

        }else{
            return -1;
        }
    }
    
}
