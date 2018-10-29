
package Logica;

import Persistencia.Vigencias;
import java.util.List;

public class VigenciaController {
       
    public List<Vigencias> getVigencias(){
        
        VigenciaDAO vigenciadao = new VigenciaDAO();
        
        return vigenciadao.readAll();
    } 
    
}
