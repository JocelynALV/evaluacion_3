
package Controlador;

import BD.Conexion;
import Modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;


/**
 *
 * @author evelyn
 */
public class repositorioUser {
    
    private Conexion conectar;
    

    public repositorioUser() {
        this.conectar = new Conexion();

    }
    
    
    public boolean agregarUsuario(Usuario usuario){
        
        try {
            Connection con = conectar.ObtConexion();
            
            String query = "INSERT INTO usuario(nombre,apellido,username,password)VALUES(?,?,?,?)";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, usuario.getNombre());
            stmt.setString(2, usuario.getApellido());
            stmt.setString(3, usuario.getUsername());
            stmt.setString(4, usuario.getPassword());
            
            stmt.executeUpdate();
            stmt.close();
            con.close();
            
            return true;
            
        } catch (SQLException e) {
            System.out.println("Error en SQL al agregar USER"+e.getMessage());
            return false;
        }
    }

    public boolean actualizarUser(Usuario usuario){
        try {
            Connection con = conectar.ObtConexion();
            
            String query = "UPDATE usuario set nombre = ?, apellido = ?, username = ?, password = ? WHERE IDusuario = ?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, usuario.getNombre());
            stmt.setString(2, usuario.getApellido());
            stmt.setString(3, usuario.getUsername());
            stmt.setString(4, usuario.getPassword());
            stmt.setInt(5, usuario.getIDusuario());
            
            stmt.executeUpdate();
            stmt.close();
            con.close();
            
            return true; 
            
        } catch (SQLException e) {
            System.out.println("Error en SQL al actualizar USER"+e.getMessage());
            return false;
        }
    }
    
    public boolean eliminarUser(String username){
        try {
            Connection con = conectar.ObtConexion();
            
            String query = "DELETE FROM usuario WHERE username = ?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, username);
            
            stmt.executeUpdate();
            stmt.close();
            con.close();
            
            return true;
            
        } catch (SQLException e) {
            
            System.out.println("Error en SQL al eliminar USER"+e.getMessage());
            return false;

        }
    }
    
    public Usuario buscarUsuario(String username){
        
        Usuario usuario = new Usuario();
        
        try {
            Connection con = conectar.ObtConexion();
            
            String query = "SELECT * FROM Usuario WHERE username = ?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, username);
            
            ResultSet resultado = stmt.executeQuery(); // ResulSet trae un SELECT
            
            if (resultado.next()) { //Si existe el dato muestralo, si el SELECT no existe pasa de largo.
                usuario.setIDusuario(resultado.getInt("IDusuario"));
                usuario.setNombre(resultado.getString("nombre"));
                usuario.setApellido(resultado.getString("apellido"));
                usuario.setUsername(resultado.getString("username"));
                usuario.setPassword(resultado.getNString("password"));
            }
            else  {
                usuario = null; // si no s?? encuentra usuario el metodo retornara null, no un usuario vacio c??mo lo estaba haciendo (Error que nos lanzo)
            }
            resultado.close(); 
            stmt.close();
            con.close();    
            
        } catch (SQLException e) {
            
            System.out.println("Error en SQL al  buscar USER "+e.getMessage());
        }
        return usuario;
    }
}
