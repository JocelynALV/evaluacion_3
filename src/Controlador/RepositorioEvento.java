
package Controlador;

import BD.Conexion;
import Modelo.Evento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Jocelyn
 */
public class RepositorioEvento {
    
    private Conexion conectar;
    
    RepositorioEvento(Conexion conexion){
        this.conectar = new Conexion();
    }
    
    public boolean agregarEvento(Evento evento){
        
        Date date;
        
        try {
            
            Connection con = conectar.ObtConexion();
            date = evento.getFecha();
            
            String query = "INSERT INTO evento (nombre,fecha,nota) VALUES (?,?,?) ";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, evento.getNombre());
            stmt.setDate(2, new java.sql.Date(date.getTime()));
            stmt.setString(3, evento.getNota());
            
            stmt.executeUpdate();
            stmt.close();
            con.close();
            
            return true;
            
        } catch (SQLException e) {
            
            System.out.println("Error en SQL al agregar EVENTO"+e.getMessage());
            return false;
        }
        
    }
    
    public boolean actualizarEvento(Evento evento){
        
        Date date;
        
        try {
            
            Connection con = conectar.ObtConexion();
            date = evento.getFecha();
            
            String query = "UPDATE evento set nombre = ?, set fecha = ?, set nota = ? WHERE IDevento = ?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, evento.getNombre());
            stmt.setDate(2, new java.sql.Date(date.getTime()));
            stmt.setString(3, evento.getNota());
            
            stmt.executeUpdate();
            stmt.close();
            con.close();
            
            return true;
            
            
        } catch (SQLException e) {
            
            System.out.println("Error en SQL al actualizar EVENTO"+e.getMessage());
            return false;
            
        }
    }
    
    public boolean eliminarEvento(String nombre){
        
        try {
            
            Connection con = conectar.ObtConexion();
            String query = "DELETE FROM evento WHERE nombre = ?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, nombre);
            
            stmt.executeUpdate();
            stmt.close();
            con.close();
            
            return true;
            
        } catch (SQLException e) {
            
            System.out.println("Error en SQL al eliminar EVENTO"+e.getMessage());
            return false;
            
        }
    }
    
    public Evento buscarEvento(int IDevento){
        
        Evento evento = new Evento();
        
        try {
            
            Connection con = conectar.ObtConexion();
            String query = "SELECT IDfecha,nombre,fecha,nota WHERE IDevento = ?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1, IDevento);
            
            ResultSet resultado = stmt.executeQuery(); 
            
            if(resultado.next()){
                evento.setIDevento(resultado.getShort("IDevento"));
                evento.setNombre(resultado.getString("nombre"));
                evento.setFecha(resultado.getDate("fecha"));
                evento.setNota(resultado.getString("nota"));
            }
            resultado.close();
            stmt.close();
            con.close();
            
        } catch (SQLException e) {
            
            System.out.println("Error en SQL al Listar EVENTO"+e.getMessage());
            
        }
        return evento;
    }
    
    public List<Evento> buscarTodos(){
        List<Evento> eventos = new ArrayList<>();
        
        try {
            
            Connection con = conectar.ObtConexion();
            String query = "SELECT IDfecha,nombre,fecha,nota FROM evento ORDER BY fecha";
            PreparedStatement stmt = con.prepareStatement(query);
           
            ResultSet resultado = stmt.executeQuery();
            
            while (resultado.next()){
                Evento evento = new Evento();
                evento.setIDevento(resultado.getShort("IDevento"));
                evento.setNombre(resultado.getString("nombre"));
                evento.setFecha(resultado.getDate("fecha"));
                evento.setNota(resultado.getString("nota"));
                
                eventos.add(evento);
            }
            resultado.close();
            stmt.close();
            con.close();
            
        } catch (SQLException e) {
            
            System.out.println("Error en SQL al Listar"+e.getMessage());
        }
        return eventos;
    }
    
}
