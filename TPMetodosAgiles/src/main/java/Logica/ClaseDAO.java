
package Logica;

import Persistencia.*;
import java.util.*;
import lic_sf_bd.util;
import org.hibernate.Query;
import org.hibernate.Session;


public class ClaseDAO {
    private Session SS;
    
    public ClaseDAO(){}

    public List<Clase> readAll(){
        SS = util.getSessionFactory().openSession();
        SS.beginTransaction();
        String sentencia = "SELECT * FROM clase;";
        Query query = SS.createSQLQuery(sentencia).addEntity(Persona.class);
        List<Clase> lista = query.list();
        SS.getTransaction().commit();
        SS.close();
        return lista;
    }
    
    public Clase read(String id){
        SS = util.getSessionFactory().openSession();
        SS.beginTransaction();
        String sentencia = "SELECT C.* FROM clase C WHERE C.id='" + id + "';";
        Query query = SS.createSQLQuery(sentencia).addEntity(Clase.class);
        List<Clase> lista = query.list();
        SS.getTransaction().commit();
        SS.close();
        
        if (!lista.isEmpty()){
            return lista.get(0);
        }    
        else{
            return null;
        }    
    }
}
