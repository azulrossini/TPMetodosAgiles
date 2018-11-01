/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Persistencia.Licencia;
import Persistencia.Persona;
import java.util.List;
import lic_sf_bd.util;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author JIC
 */
public class PersonaDAO {
    
    private Session SS;
    
    public PersonaDAO() {
    }
    
    public List<Persona> readAll(){
        SS = util.getSessionFactory().openSession();
        SS.beginTransaction();
        String sentencia = "SELECT * FROM persona WHERE 1;";
        Query query = SS.createSQLQuery(sentencia).addEntity(Persona.class);
        List<Persona> lista = query.list();
        SS.getTransaction().commit();
        SS.close();
        return lista;
    }
    
    public Persona read(int id){
        SS = util.getSessionFactory().openSession();
        SS.beginTransaction();
        String sentencia = "SELECT * FROM Persona P WHERE P.id='" + id + "' LIMIT 0,1;";
        Query query = SS.createSQLQuery(sentencia).addEntity(Persona.class);
        List<Persona> lista = query.list();
        SS.getTransaction().commit();
        SS.close();
        
        if (!lista.isEmpty()){
            return lista.get(0);
        }    
        else{
            return null;
        }    
    }
    
    public List<Persona> readTitular(int id){
        SS = util.getSessionFactory().openSession();
        SS.beginTransaction();
        //Devuelve los DNI que contengan un substring del dni
        String sentencia = "SELECT * FROM Persona P WHERE P.nro_id LIKE '%" + id + "%';";
        Query query = SS.createSQLQuery(sentencia).addEntity(Persona.class);
        List<Persona> lista = query.list();
        SS.getTransaction().commit();
        SS.close();
        return lista;
    }
    
    public void writeTitular(Persona p){
        SS = util.getSessionFactory().openSession();
        SS.beginTransaction();
        SS.save(p);
        SS.getTransaction().commit();
        SS.close();
    }
    

    
}
