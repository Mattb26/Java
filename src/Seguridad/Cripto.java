package Seguridad;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Base64;

/**
 *
 * @author Desarrollo
 */
public class Cripto {
    public String Cadena(String valor){
        try {
                MessageDigest digest = MessageDigest.getInstance("SHA-256");
                byte[] hash = digest.digest(valor.getBytes(StandardCharsets.UTF_8));
                String encoded = Base64.getEncoder().encodeToString(hash);
            
            return encoded;
        } catch (Exception e) {
            
        }
        return null;
    } 
}
