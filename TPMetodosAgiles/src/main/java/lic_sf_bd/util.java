/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lic_sf_bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;
import org.hibernate.exception.JDBCConnectionException;
import org.hibernate.jdbc.Work;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author Fausto
 */
public class util {

    private static final SessionFactory sessionFactory;
    
    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            JOptionPane.showMessageDialog(null, "ERROR. Falló la conexión a la base de datos", "Error",  JOptionPane.ERROR_MESSAGE);
            System.exit(0);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getSessionFactory() {
        //Se verifica conexión
        try{
            DriverManager.getConnection("jdbc:mysql://localhost:3306/lic_sf_bd?zeroDateTimeBehavior=convertToNull", "root", "");
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "ERROR. Falló la conexión a la base de datos", "Error",  JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        return sessionFactory;
    }
}
