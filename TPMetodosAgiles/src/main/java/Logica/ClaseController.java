
package Logica;

import Persistencia.Clase;


public class ClaseController {
    private ClaseDAO claseDAO;
    
    public ClaseController(){
        this.claseDAO = new ClaseDAO();
    }
    
    public boolean verificarClase(String clase){
        return (!(claseDAO.read(clase)==null));
        
    }
}

