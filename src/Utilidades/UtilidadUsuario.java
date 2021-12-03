/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

import Controlador.repositorioUser;
import Modelo.Usuario;

/**
 *
 * @author JocelioCalzon
 */
public class UtilidadUsuario {
    
    
    private repositorioUser repositorioUser;
    
    public boolean validarUser(String usuario,String contraseña){
        this.repositorioUser = new repositorioUser();         
        Usuario user = repositorioUser.buscarUsuario(usuario);
        if (user != null){
            if(user.getUsername().equals(usuario) && user.getPassword().equals(contraseña)){
                SesionUsuario.SetUsuario(user);        
                return true;
            }
            else{
                return false;
            }
        }
        return false;
    }
    
}
