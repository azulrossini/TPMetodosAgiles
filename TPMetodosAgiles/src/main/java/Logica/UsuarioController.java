/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Persistencia.Usuario;
import java.util.Arrays;
import java.util.List;
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
        //Verificar la existencia de nombre de usuario
        if (ud.readByUsername(username)!=null)
            return false;
        else
            return true;
    }
    
    public int validarCampos (String username, String pass, boolean superusuario, boolean administrativo){
        //Verificar existencia de usuario
        if (!this.validarUsername(username)){
            return 1;
        }else{
            //Verificar que se haya ingresado un nombre de usuario
            if (username.isEmpty()){
                return 2;
            }else{
                //Verificar que se haya ingresado una contraseña
                if (pass.isEmpty()){
                    return 3;
                }else
                    //Verificar que se haya seleccionado un privilegio
                    if (superusuario || administrativo){
                        return 0;
                    }else
                        //No se selecciona privilegio
                        return 4;
            }
        }
    }
    
    public void crearUsuario (String username, String pass, boolean priv) throws Exception{
        //Se almacena en la base de datos el usuario
        GenericDAO.create(new Usuario(username, CryptoUtils.computeHash(pass), priv));
    }
    
}
