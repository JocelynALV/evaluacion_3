/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

import Modelo.Usuario;

/**
 *
 * @author JocelioCalzon
 */
public class SesionUsuario {
    public static Usuario Usuario;
    
    public static void SetUsuario(Usuario usuario){
        Usuario = usuario;
    }
    
}
