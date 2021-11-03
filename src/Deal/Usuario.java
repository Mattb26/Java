package Deal;
import Entidad.*;
import Servicios.*;
import java.net.http.HttpResponse;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.util.List;
import org.json.simple.JSONArray;
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

    public ArrayList<Entidad.Persona> Listado(){
        try {
          
                Servicios.Api llamadoApi = new Api();
                HttpResponse<String> response = llamadoApi.LlamadoHttpResponseGet("http://localhost:47261/api/Persona/usuario");

                System.out.println(response);
                //JSONParser parser = new JSONParser();
                
                
                System.out.println(response.body());
                
                /*List<Entidad.Persona> List;
                List = parser.parse(response.body());   */
                //JSONParser parser = new JSONParser();
               //JSONArray jsonArray = (JSONArray) parser.parse(response.body());      
                      
               
               JSONParser parser = new JSONParser();
               JSONArray jsonArray = (JSONArray) parser.parse(response.body());
               

                ArrayList<Entidad.Persona> List = new ArrayList<Entidad.Persona>();
                DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
                
               for (int i = 0; i < jsonArray.toArray().length; i++) {
                    Entidad.Persona pers= new Entidad.Persona();
                    Date startDate;
                    JSONObject obj2 = (JSONObject)jsonArray.get(i);
                    System.out.println(obj2.get("nombreUsuario"));
                    System.out.println(obj2.get("idPersona"));
                    System.out.println(obj2.get("nombre"));
                    System.out.println(obj2.get("apellido"));
                    System.out.println(obj2.get("correoElectronico"));
                    System.out.println(obj2.get("fechaNacimiento"));
                    
                    pers.setIdPersona(Integer.parseInt(obj2.get("idPersona").toString()));
                    pers.setNombre(obj2.get("nombre").toString());
                    pers.setApellido(obj2.get("apellido").toString());
                    pers.setCorreoElectronico(obj2.get("correoElectronico").toString());
                    pers.setFechaNacimientoString(obj2.get("fechaNacimiento").toString());
                    pers.setNombreUsuario(obj2.get("nombreUsuario").toString());
    
                    List.add(pers);
               }
               
               return  List;

        } catch (Exception e) {
            System.out.println(e);
        }
        
        return null;
    
    }
}