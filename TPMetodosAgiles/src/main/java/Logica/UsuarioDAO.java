/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Persistencia.Usuario;
import java.util.Arrays;
import java.util.List;
import lic_sf_bd.util;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Fausto
 */
public class UsuarioDAO extends GenericDAO{
    
    private static Session SS;
    
    public UsuarioDAO(){
        
    }
    public List<Usuario> buscarUsernameAdministrativo(String username){
        SS = util.getSessionFactory().openSession();
        SS.beginTransaction();
        String sentencia = "SELECT * FROM Usuario U WHERE U.username LIKE '%" + username + "%' AND U.privilegio = 0";
        Query query = SS.createSQLQuery(sentencia).addEntity(Usuario.class);
        List<Usuario> lista = query.list();
        SS.getTransaction().commit();
        SS.close();
        if (lista.isEmpty())
            return null;
        else
            return lista;
    }
    
    public Usuario readByUsername(String username){
        SS = util.getSessionFactory().openSession();
        SS.beginTransaction();
        String sentencia = "SELECT * FROM Usuario U WHERE U.username='" + username + "' LIMIT 0,1;";
        Query query = SS.createSQLQuery(sentencia).addEntity(Usuario.class);
        List<Usuario> lista = query.list();
        SS.getTransaction().commit();
        SS.close();
        if (lista.isEmpty())
            return null;
        else
            return lista.get(0);
    }
    
}
