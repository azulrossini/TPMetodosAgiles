/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Persistencia.Usuario;
import java.util.Arrays;
import java.util.List;
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
    
    public List<Usuario> buscarUsernameAdministrativo (String username){
        return ud.buscarUsernameAdministrativo(username);
    }
    
    public Usuario validarAcc(String username, String pass) throws Exception{
        //Se busca en la base de datos el usuario ingresado en la pantalla de Login
        Usuario user =  ud.readByUsername(username);
        //Se encripta la contraseña ingresada por el usuario y se compara con la recuperada de la base de datos, 
        //si coinciden, se retorna el objeto correspondiente a la cuenta válida. Caso contrario, se retorna null
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
    
    public void crearUsuario (String username, String pass, boolean priv) throws Exception{
        //Se almacena en la base de datos el usuario
        GenericDAO.create(new Usuario(username, CryptoUtils.computeHash(pass), priv));
    }
    
}
