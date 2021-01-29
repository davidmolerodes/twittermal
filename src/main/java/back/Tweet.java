package back;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Tweet {

    private String nombre;
    private String mensaje;
    private String fecha;

    public Tweet(String nombre, String mensaje, String fecha) {
        this.nombre = nombre;
        this.mensaje = mensaje;
        this.fecha = fecha;
    }

    public boolean comprobar(String t){
        if (t.length() > 140)
            return false;
        else {
            return true;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
