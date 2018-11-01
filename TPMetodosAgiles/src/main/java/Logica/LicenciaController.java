/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Persistencia.Clase;
import Persistencia.Licencia;
import Persistencia.Persona;
import Persistencia.Vigencias;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class LicenciaController {
    
    private LicenciaDAO LicenciaDAO;
    
    public enum Motivo{ORIGINAL, RENOVACION}
    
    public LicenciaController(){
        this.LicenciaDAO = new LicenciaDAO();
    }
    
    public List<Licencia> getLicencias(){
        return LicenciaDAO.readAll();
    }
    
    public List<Licencia> getLicenciasVigentes(Date fechaVigencia){
        return LicenciaDAO.read(fechaVigencia);
    }  
    
    public boolean verificarClase(String clase, Persona titular){
        ClaseController cc = new ClaseController();
        //Si la clase existe
        if(cc.verificarClase(clase)){

            if(clase =="A" || clase =="B" || clase== "F" || clase =="G" ){
                //Si es de esta clase no necesita validacion extra, puede sacarla sin problema a la licencia
                return true;
            }
            else{
                List<Licencia> licencias_anteriores = LicenciaDAO.getLicenciasTitular(titular.getId());
                for(int i=0; i<licencias_anteriores.size(); i++){
                    
                //Verifica si tuvo una licencia de clase B en algun momento, al menos 1 anio antes
                    if(licencias_anteriores.get(i).getClaseId() == "B"){
                        Date hoy = new Date();
                        long diff = hoy.getTime() - licencias_anteriores.get(i).getFechaEmision().getTime();
                        
                        //Tiene que haberla sacado 1 anio antes al menos
                        int diffDays = (int) (diff / (24 * 60 * 60 * 1000));
                        if(diffDays>= 365){
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }
    
    public void eliminarLicenciasHeredadas(String clase, Persona titular){
        
        switch (clase){
            case "A":
                return;
            case "B":
                return;
            case"C":
                List<String> heredadas = LicenciaDAO.getHeredadas("C");
                
                for(int i=0; i<heredadas.size(); i++){
                    List<Licencia> licencia_anterior = LicenciaDAO.getLicenciasPorClase(titular.getId(), heredadas.get(i));
                    
                }
        }
        
        
        
        
        
        List<Licencia> licencias_anteriores = LicenciaDAO.getLicenciasTitular(titular.getId());
                for(int i=0; i<licencias_anteriores.size(); i++){
                    
                //Verifica si tuvo una licencia de clase B en algun momento, al menos 1 anio antes
                    if(licencias_anteriores.get(i).getClaseId() == "B"){
                        
                    }
                }
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
