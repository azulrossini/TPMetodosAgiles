/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Persistencia.Usuario;
import org.hibernate.Session;

/**
 *
 * @author Fausto
 */
public class UsuarioController {
    
    private UsuarioDAO ud;
    private static Session SS;
    
    public UsuarioController(){
        this.ud = new UsuarioDAO();
    }
    
    public Usuario validar(String username, byte[] pass){
        return ud.readByUsernameAndPassword(username, pass);
    }
    
    public void crearUsuario(Usuario user){
        this.ud.create(user);
    }
    
}
