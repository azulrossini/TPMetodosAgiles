/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Persistencia.Licencia;
import Persistencia.Persona;
import Persistencia.Vigencias;
import java.util.Date;
import java.util.List;

/**
 *
 * @author JIC
 */
public class LicenciaController {
    
    private LicenciaDAO LicenciaDAO;
    
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
    
    public Date getVigencia(Licencia licencia){
        
        PersonaController personaController = new PersonaController();
        VigenciaController vigenciaController = new VigenciaController();
        
        //En listaVigencias tengo todas las edades para manejar las vigencias
        
        List<Vigencias> listaVigencias = vigenciaController.getVigencias();
        Persona persona = personaController.getPersona(licencia.getPersonaId());
               
        Date fecha_nacimiento = persona.getFechaNac();
        String motivo = licencia.getMotivo();
        
        fecha_nacimiento.getYear();
        
        //POR ACA IBAS NACHITO QUERIDO
        
        
        return fecha_nacimiento;
    }
    
}
