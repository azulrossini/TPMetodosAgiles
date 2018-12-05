/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Persistencia.Vigencias;
import java.util.List;
import lic_sf_bd.util;
import org.hibernate.Query;
import org.hibernate.Session;


public class VigenciaDAO extends GenericDAO{
    
    private Session SS;
    
    public VigenciaDAO() {
    }
    
    public List<Vigencias> readAll(){
        SS = util.getSessionFactory().openSession();
        SS.beginTransaction();
        String sentencia = "SELECT * FROM vigencias WHERE 1;";
        Query query = SS.createSQLQuery(sentencia).addEntity(Vigencias.class);
        List<Vigencias> lista = query.list();
        SS.getTransaction().commit();
        SS.close();
        return lista;
    }
    
}
