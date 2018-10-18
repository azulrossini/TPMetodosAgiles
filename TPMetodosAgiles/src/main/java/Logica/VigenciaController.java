/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Persistencia.Vigencias;
import java.util.List;

/**
 *
 * @author JIC
 */
public class VigenciaController {
       
    public List<Vigencias> getVigencias(){
        
        VigenciaDAO vigenciadao = new VigenciaDAO();
        
        return vigenciadao.readAll();
    } 
    
}
