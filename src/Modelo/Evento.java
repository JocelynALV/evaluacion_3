
package Modelo;

import java.util.Date;

/**
 *
 * @author Jocelyn
 */
public class Evento {
    
    private int IDevento;
    private String nombre;
    private Date fecha;
    private String nota;
    private int IDusuario; 
    private Usuario usuario; 

    public Evento() {
    }

    public Evento(String nombre, Date fecha, String nota, int IDusuario) {
        this.IDevento = IDevento;
        this.nombre = nombre;
        this.fecha = fecha;
        this.nota = nota;
        this.IDusuario = IDusuario;
    }

    public int getIDevento() {
        return IDevento;
    }

    public void setIDevento(int IDevento) {
        this.IDevento = IDevento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public int getIDusuario() {
        return IDusuario;
    }

    public void setIDusuario(int IDusuario) {
        this.IDusuario = IDusuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    

    
    
}
