
package Logica;

import Persistencia.Usuario;
import Presentacion.Login;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;


public class Index {
    
    public static List<JFrame> historial = new ArrayList(); 
    
    public static void main(String[] args) throws Exception {
        Usuario nuevo = new Usuario("fausto", CryptoUtils.computeHash("fedele"), true);
        try{
            GenericDAO.create(nuevo);
        }catch(Exception e){
            System.out.println("YA EXISTE EL USUARIO");
        }
        Login log = new Login();
    }
    
}
