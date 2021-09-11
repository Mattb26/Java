package Deal;

import Entidad.Contactos;
import Servicios.Api;

/**
 *
 * @author Desarrollo
 */
public class ContactoDeal {
    
    public boolean Alta(Contactos contactos )
    {
        try {
                Api api = new Api();
                return  api.ContactoAlta(contactos);
                
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
    
}
