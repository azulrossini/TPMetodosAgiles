
package Logica;

import Persistencia.Licencia;
import java.util.Date;
import Persistencia.*;
import Persistencia.*;
import java.util.List;
import lic_sf_bd.util;
import org.hibernate.Query;
import org.hibernate.Session;


public class LicenciaDAO extends GenericDAO {
    
    private Session SS;
    
    public LicenciaDAO() {
    }
    
    public void writeLicencia(Licencia l){
        SS = util.getSessionFactory().openSession();
        SS.beginTransaction();
        SS.save(l);
        SS.getTransaction().commit();
        SS.close();
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
        
    //TRAE LAS VIGENCIAS EN EL RANGO Y VIGENTES
    //FORMATE DATE MYSQL: yyyy-MM-dd
    public List<Licencia> readRangoVigentes(String fechaDesde, String fechaHasta){
    SS = util.getSessionFactory().openSession();
    SS.beginTransaction();
    String sentencia = "SELECT * FROM licencia WHERE fecha_venc BETWEEN " + "'" + fechaDesde + "'" + " AND " + "'" + fechaHasta + "'" +"AND fecha_venc > NOW() ORDER BY fecha_venc ASC";
    Query query = SS.createSQLQuery(sentencia).addEntity(Licencia.class);
    List<Licencia> lista = query.list();
    SS.getTransaction().commit();
    SS.close();
    return lista;
    }

    //TRAE LAS VIGENCIAS EN EL RANGO Y EXPIRADAS
    //FORMATE DATE MYSQL: yyyy-MM-dd
    public List<Licencia> readRangoExpiradas(String fechaDesde, String fechaHasta){
    SS = util.getSessionFactory().openSession();
    SS.beginTransaction();
    String sentencia = "SELECT * FROM licencia WHERE fecha_venc BETWEEN " + "'" + fechaDesde + "'" + " AND " + "'" + fechaHasta + "'" +"AND fecha_venc < NOW() ORDER BY fecha_venc ASC";
    Query query = SS.createSQLQuery(sentencia).addEntity(Licencia.class);
    List<Licencia> lista = query.list();
    SS.getTransaction().commit();
    SS.close();
    return lista;
    }       
        
    //TRAE TODAS LAS VIGENTES     
    public List<Licencia> readAllVigentes(){
        SS = util.getSessionFactory().openSession();
        SS.beginTransaction();
        String sentencia = "SELECT * FROM licencia WHERE fecha_venc > NOW()";
        Query query = SS.createSQLQuery(sentencia).addEntity(Licencia.class);
        List<Licencia> lista = query.list();
        SS.getTransaction().commit();
        SS.close();
        return lista;
    }
    
    //TRAE TODAS LAS EXPIRADAS    
    public List<Licencia> readAllExpiradas(){
        SS = util.getSessionFactory().openSession();
        SS.beginTransaction();
        String sentencia = "SELECT * FROM licencia WHERE fecha_venc < NOW()";
        Query query = SS.createSQLQuery(sentencia).addEntity(Licencia.class);
        List<Licencia> lista = query.list();
        SS.getTransaction().commit();
        SS.close();
        return lista;
    }
    
    //TRAE TODAS LAS EXPIRADAS    
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
    
    public void update(Licencia l){
        SS = util.getSessionFactory().openSession();
        SS.beginTransaction();
        SS.update(l);
        SS.getTransaction().commit();
        SS.close();
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
