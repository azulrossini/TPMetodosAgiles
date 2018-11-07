
package Logica;

import Presentacion.Login;
import Presentacion.IndexView;


public class Index {
    
    public static void main(String[] args) {

        try{
            GenericDAO gd = new GenericDAO();
            IndexView index = new IndexView();
            index.setVisible(true);
            
        }catch(Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();            
        }
    }
    
}
