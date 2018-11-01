/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;


import Persistencia.Costos;
import java.util.List;
import lic_sf_bd.util;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author ayr_1
 */
public class CostoDAO {
    
    private Session ss;
    
    public CostoDAO() {
    }
    
    public Costos calcularCosto(String clase, int vigencia){
        ss = util.getSessionFactory().openSession();
        ss.beginTransaction();
        
        String sentencia = "SELECT C.* "
                        + "FROM costos C "
                        + "WHERE C.clase='" + clase + "' "
                        + "AND C.anios ='" + vigencia + "';";        
             
        Query query = ss.createSQLQuery(sentencia).addEntity(Costos.class);
        List<Costos> lista = query.list();
        
        ss.getTransaction().commit();
        ss.close();
        
        //Si me devuelve una sola fila
        if (lista.size() == 1){
            return lista.get(0);
        }    
        else{
            return null;
        }
        
    }
    
}
