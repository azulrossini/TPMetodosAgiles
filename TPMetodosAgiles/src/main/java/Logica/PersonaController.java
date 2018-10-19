/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Persistencia.Licencia;
import Persistencia.Persona;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JIC
 */
public class PersonaController {
    
    private PersonaDAO PersonaDAO;
    
    public enum TipoDocumento{DNI, CUIT, CUIL}
    
    public PersonaController(){
        this.PersonaDAO = new PersonaDAO();
    }
    
    public Persona getPersona(int id){
        
        Persona persona = PersonaDAO.read(id);
                       
        return persona;
        
    }
    
    
    
    /*devuelve un arreglo de booleans, cada posicion indica si el dato es correcto o no
    0 numeroDocumento
    1 nombre
    2 apellido
    3 dia
    4 mes
    5 anio
    6 calle
    7 numero de calle
    8 piso
    9 departamento
    10 grupo sanguineo
    11 edad menor a 17
    */
    public boolean[] validarDatos(TipoDocumento tipo, String numeroDocumento, String nombre, String apellido, String dia, 
                                    String mes, String anio, String calle, String numeroCalle, String piso, String depart, String grupoSanguineo){
        //falta hacer
        boolean lista[]=null;
        
        return lista;
    }
    
    
       
}
