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
public class PersonaController {
    
    private PersonaDAO PersonaDAO;
    
    public PersonaController(){
        this.PersonaDAO = new PersonaDAO();
    }
    
    public Persona getPersona(int id){
        
        Persona persona = PersonaDAO.read(id);
                       
        return persona;
        
    }
       
}
