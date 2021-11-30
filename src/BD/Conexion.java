
package BD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Jocelyn
 */
public class Conexion {
    
    public Connection ObtConexion(){
        
        Connection coneccion = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            coneccion = DriverManager.getConnection("jdbc:mysql://localhost:3306/agenda","root","");
            System.out.println("¡Se obtuvo conexión!");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("¡Error de conexión"+ e.getMessage());
        }
        return coneccion;
    }
    
    public static void main(String[] args) { 
        Conexion conectar = new Conexion(); //Probando si conecta.
        conectar.ObtConexion();
    }
}
