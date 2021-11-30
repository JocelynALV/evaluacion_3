
package Modelo;

import java.util.Date;

/**
 *
 * @author Cristian
 */
public class Evento {
    
    private int IDevento;
    private String nombre;
    private Date echa;
    private String nota;

    public Evento() {
    }

    public Evento(int IDevento, String nombre, Date echa, String nota) {
        this.IDevento = IDevento;
        this.nombre = nombre;
        this.echa = echa;
        this.nota = nota;
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

    public Date getEcha() {
        return echa;
    }

    public void setEcha(Date echa) {
        this.echa = echa;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }
    
}
