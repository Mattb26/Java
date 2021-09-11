/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
        }
        return false;
    }
    
}
