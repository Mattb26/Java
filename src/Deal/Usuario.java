
package Deal;
import Entidad.*;
import Servicios.*;
/**
 *
 * @author Desarrollo
 */
public class Usuario {

    public boolean LoginValidar(Login login){
        try {
                
            //Llamo a api para validar el usuario
            Servicios.Api llamadoApi = new Api();
            String json = new StringBuilder()
                .append("{")
                .append("\"nombreUsuario\":\""+ login.getNombreUsuario()+"\",")
                .append("\"clave\":\""+ login.getClave() +"\"")
                /*.append("\"idUsuario\":\""+login.getIdUsuario()+"\",")
                .append("\"estado\":\""+ login.getEstado()+"\"")*/
                .append("}").toString();
                        
            String response = llamadoApi.Llamado(json, "http://localhost:47261/api/Persona/login");
            System.out.println(response);
            
            if(!response.trim().toUpperCase().equals("ERROR")){
                System.out.println("Login correcto");
                return  true;
            }
            else{
                System.out.println("Error en el login");
                return false;
            }
            
            
            
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
}
