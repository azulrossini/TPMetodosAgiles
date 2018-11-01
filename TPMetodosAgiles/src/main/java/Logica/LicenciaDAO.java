
package Logica;

import Persistencia.Licencia;
import java.util.Date;
import Persistencia.*;
import java.util.List;
import lic_sf_bd.util;
import org.hibernate.Query;
import org.hibernate.Session;


public class LicenciaDAO extends GenericDAO {
    
    private Session SS;
    
    public LicenciaDAO() {
    }
    
    //SOLO TRAE LAS VIGENTES
        public List<Licencia> read(Date fechaVigencia){
        SS = util.getSessionFactory().openSession();
        SS.beginTransaction();
        String sentencia = "SELECT * FROM licencia WHERE fecha_venc >= " + fechaVigencia;
        Query query = SS.createSQLQuery(sentencia).addEntity(Licencia.class);
        List<Licencia> lista = query.list();
        SS.getTransaction().commit();
        SS.close();
        return lista;
    }
        
    //TRAE TODAS    
    public List<Licencia> readAll(){
        SS = util.getSessionFactory().openSession();
        SS.beginTransaction();
        String sentencia = "SELECT * FROM licencia WHERE 1";
        Query query = SS.createSQLQuery(sentencia).addEntity(Licencia.class);
        List<Licencia> lista = query.list();
        SS.getTransaction().commit();
        SS.close();
        return lista;
    }
    
    public List<Licencia> getLicenciasTitular(int idTitular){
        SS = util.getSessionFactory().openSession();
        SS.beginTransaction();
        String sentencia = "SELECT L.* FROM licencia L WHERE L.persona_id ='"+ idTitular +"';";
        Query query = SS.createSQLQuery(sentencia).addEntity(Licencia.class);
        List<Licencia> lista = query.list();
        SS.getTransaction().commit();
        SS.close();
        return lista;  
    }
    
    public List<String> getHeredadas(String clase){
        SS = util.getSessionFactory().openSession();
        SS.beginTransaction();
        String sentencia = "SELECT C.clases_heredadas_id FROM clase C WHERE C.id ='"+ clase +"';";
        Query query = SS.createSQLQuery(sentencia).addEntity(Licencia.class);
        List<String> lista = query.list();
        SS.getTransaction().commit();
        SS.close();
        return lista;
    }
    
    public List<Licencia> getLicenciasPorClase(int id, String clase){
        SS = util.getSessionFactory().openSession();
        SS.beginTransaction();
        String sentencia = "SELECT L.* FROM licencia L WHERE L.persona_id ='"+ id +"'"
                + "AND L.clase_id ='"+ clase +"';";
        Query query = SS.createSQLQuery(sentencia).addEntity(Licencia.class);
        List<Licencia> lista = query.list();
        SS.getTransaction().commit();
        SS.close();
        return lista;
    }
    
}
