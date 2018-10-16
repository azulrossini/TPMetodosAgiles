/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Presentacion.IndexView;

/**
 *
 * @author JIC
 */
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
