package Entidad;

/**
 *
 * @author Desarrollo
 */
public class PersonaUsuario extends Persona {
    private Login Usuario;

    public Login getUsuario() {
        return Usuario;
    }

    public void setUsuario(Login Usuario) {
        this.Usuario = Usuario;
    }
}
