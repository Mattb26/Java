package Deal;
import Entidad.*;
import Servicios.*;
import java.net.http.HttpResponse;
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

    public boolean AgregarUsuario(PersonaUsuario personaUsuario){
        try {
                
                //armo el json
            
                String json = new StringBuilder()
                .append("{")
                .append("\"nombre\":\""+ personaUsuario.getNombre()+"\",")
                .append("\"apellido\":\""+ personaUsuario.getApellido()+"\",")
                .append("\"correoElectronico\":\""+ personaUsuario.getCorreoElectronico()+"\",")
                  .append("\"fechaNacimiento\":\""+ "2021-09-21" +"\",")      
                        .append("\"usuario\":{")
                        .append("\"nombreUsuario\":\""+ personaUsuario.getUsuario().getNombreUsuario()+"\",")
                        .append("\"clave\":\""+ personaUsuario.getUsuario().getClave()+"\",")
                        .append("\"estado\":" + 0)
                        .append("}")
                .append("}").toString();
            
                System.out.println(json);
            //llamo a la api para el alta
            Servicios.Api llamadoApi = new Api();
            HttpResponse<String> response = llamadoApi.LlamadoHttpResponse(json, "http://localhost:47261/api/Persona");
            System.out.println(response);
            
            if(response.statusCode()==200){
            //Retorno el estado de la api
            return  true;
            }else{

                return false;
            }
                   
        } catch (Exception e) {
        }
        return false;
    }
}
