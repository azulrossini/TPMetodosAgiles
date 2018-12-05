
package Logica;

import Logica.LicenciaController.Motivo;
import Persistencia.Vigencias;
import java.util.Date;
import java.util.List;

public class VigenciaController {
    
    //Método para obtener todas las vigencias cargas en la BD
    public List<Vigencias> getVigencias(){
        
        VigenciaDAO vigenciadao = new VigenciaDAO();
        
        return vigenciadao.readAll();
    }
    //Método para obtener una vigencia en particular a partir del motivo y
    //la fecha de nacimiento de un titular
    public Vigencias getVigencia(String m, Date fechaNacimiento){
        
        //Se crea el controlador del titular para obtener la edad:
        PersonaController personaController = new PersonaController();
        //Obtenemos la edad:
        int edad = personaController.getEdad(fechaNacimiento);
        //Obtenemos una lista con todas las vigencias:
        List<Vigencias> listaVigencias = this.getVigencias();
        
        //Según los datos obtenidos retornamos la vigencia deseada:
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
