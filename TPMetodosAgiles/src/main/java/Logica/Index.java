
package Logica;

import Persistencia.Usuario;
import Presentacion.Inicio;
import Presentacion.Login;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;


public class Index {
    
    public static List<JFrame> historial = new ArrayList(); 
    
    public static void main(String[] args) throws Exception {
        Inicio init = new Inicio();
        //Se crea cuenta ejemplo con privilegios de superusuario
        Usuario nuevo = new Usuario("admin", CryptoUtils.computeHash("admin"), true);
        try{
            GenericDAO.create(nuevo);
        }catch(Exception e){
        }
        //Se presenta la ventana para el control de acceso al sistema
        init.dispose();
        Login log = new Login();
    }
    
}
