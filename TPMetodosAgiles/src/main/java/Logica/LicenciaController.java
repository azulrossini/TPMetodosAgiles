/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Persistencia.Licencia;
import Persistencia.Persona;
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
    
}
