package Servicios;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import Entidad.Contactos;
import java.net.URI;
import java.net.http.HttpResponse;

/**
 *
 * @author Desarrollo
 */
public class Api {
    
    private HttpClient httpClient = 
            HttpClient.newBuilder().version(HttpClient.Version.HTTP_2).build();
    
    
    
    public boolean ContactoAlta(Contactos contactos)
    {
        
        try {
   
        String json = new StringBuilder()
                .append("{")
                .append("\"nombre\":\""+ contactos.getNombre()+"\",")
                .append("\"asunto\":\""+contactos.getAsunto()+"\",")
                .append("\"correoElectronico\":\""+contactos.getCorreoElectronico()+"\",")
                .append("\"mensaje\":\""+contactos.getMensaje()+"\"")
                .append("}").toString();
        
        System.out.println(json);
        
        HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .uri(URI.create("http://localhost:47261/api/Contacto"))
                .setHeader("User-Agent", "Java 11 HttpClient Bot") // add request header
                .header("Content-Type", "application/json")
                .build();
        
          HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
         
          System.out.println(response.statusCode());

        // print response body
        System.out.println(response.body());    
        if(response.statusCode()==200){
            return  true;
        }
        else{
            return false;
        }
        
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return false;
    }
    
    public String Llamado(String jsonString, String uriString)
    {
        
        try {
        
        System.out.println(jsonString);
        
        HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(jsonString))
                .uri(URI.create(uriString))
                .setHeader("User-Agent", "Java 11 HttpClient Bot") // add request header
                .header("Content-Type", "application/json")
                .build();
        
          HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
         
          System.out.println(response.statusCode());

        // print response body
        System.out.println(response.body());     
        
        if(response.statusCode()==200){
            //Retorno el estado de la api
            return  response.body();
        }else{
        
            return "Error";
        }
        

        
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}
