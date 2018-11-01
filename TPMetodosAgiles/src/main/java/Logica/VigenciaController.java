
package Logica;

import Logica.LicenciaController.Motivo;
import Persistencia.Vigencias;
import java.util.Date;
import java.util.List;

public class VigenciaController {
       
    public List<Vigencias> getVigencias(){
        
        VigenciaDAO vigenciadao = new VigenciaDAO();
        
        return vigenciadao.readAll();
    } 
    public Vigencias getVigencia(String m, Date fechaNacimiento){
        PersonaController personaController = new PersonaController();
        int edad = personaController.getEdad(fechaNacimiento);
        
        List<Vigencias> listaVigencias = this.getVigencias();
        
        if(edad < 21){
            if(m.equals(Motivo.ORIGINAL.toString())){

                return listaVigencias.get(0);
                
            }
            if(m.equals(Motivo.RENOVACION.toString())){

                return listaVigencias.get(1); 
                
            }
        }
        if(edad >=21 && edad <= 46){

           return listaVigencias.get(2);
            
        }
        if(edad>46 && edad <= 60){
            
            return listaVigencias.get(3);
            
        }
        if(edad >60 && edad <= 70){
            
            return listaVigencias.get(4);
            
        }
        if(edad > 70){
            
           return listaVigencias.get(5);
           
        }
        
        
        return null;
    }
}
