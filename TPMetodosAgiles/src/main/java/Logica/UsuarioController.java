/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Persistencia.Usuario;
import java.util.Arrays;
import javax.swing.JOptionPane;
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
    
    public Usuario validarAcc(String username, String pass) throws Exception{
        Usuario user =  ud.readByUsername(username);
        if (Arrays.equals(user.getPassword(), CryptoUtils.computeHash(pass))){
            return user;
        }else{
            return null;
        }
    }
    
    public boolean validarUsername(String username){
        if (ud.readByUsername(username)!=null)
            return false;
        else
            return true;
    }
    
    public int validarCampos (String username, String pass, boolean superusuario, boolean administrativo){
        if (!this.validarUsername(username)){
            return 1;
        }else{
            if (username.isEmpty()){
                return 2;
            }else{
                if (pass.isEmpty()){
                    return 3;
                }else
                    if (superusuario || administrativo){
                        return 0;
                    }else
                        return 4;
            }
        }
    }
    
}
