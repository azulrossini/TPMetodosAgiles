/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Persistencia.Licencia;
import org.hibernate.Session;
import java.util.List;
import lic_sf_bd.util;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author JIC
 */
public class LicenciaDAO extends GenericDAO {
    
    private util HU;
    private Session SS;
    
    public LicenciaDAO() {
    }
    
    public List<Licencia> readAll(){
        SS = HU.getSessionFactory().openSession();
        SS.beginTransaction();
        String sentencia = "SELECT * FROM licencia WHERE 1;";
        Query query = SS.createSQLQuery(sentencia).addEntity(Licencia.class);
        List<Licencia> lista = query.list();
        SS.getTransaction().commit();
        SS.close();
        return lista;
    }
    
}
