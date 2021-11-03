package Entidad;

import java.util.Date;

/**
 *
 * @author Desarrollo
 */
public class Persona{
    private int IdPersona;
    private String nombreUsuario;
    private String Nombre ;
    private String Apellido;
    private String CorreoElectronico;
    private Date FechaNacimiento;
    private String FechaNacimientoString;
    
    public int getIdPersona() {
        return IdPersona;
    }

    public void setIdPersona(int IdPersona) {
        this.IdPersona = IdPersona;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getCorreoElectronico() {
        return CorreoElectronico;
    }

    public void setCorreoElectronico(String CorreoElectronico) {
        this.CorreoElectronico = CorreoElectronico;
    }

    public Date getFechaNacimiento() {
        return FechaNacimiento;
    }

    public void setFechaNacimiento(Date FechaNacimiento) {
        this.FechaNacimiento = FechaNacimiento;
    }

    public String getFechaNacimientoString() {
        return FechaNacimientoString;
    }

    public void setFechaNacimientoString(String FechaNacimientoString) {
        this.FechaNacimientoString = FechaNacimientoString;
    }
    
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
}
