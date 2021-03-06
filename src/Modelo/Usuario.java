
package Modelo;

/**
 *
 * @author JocelioCalzon
 */
public class Usuario {
    
    private int IDusuario;
    private String nombre;
    private String apellido;
    private String username;
    private String password;

    public Usuario() {
    }

    public Usuario(int IDusuario, String nombre, String apellido, String username, String password) {
        this.IDusuario = IDusuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.username = username;
        this.password = password;
    }

    public int getIDusuario() {
        return IDusuario;
    }

    public void setIDusuario(int IDusuario) {
        this.IDusuario = IDusuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
