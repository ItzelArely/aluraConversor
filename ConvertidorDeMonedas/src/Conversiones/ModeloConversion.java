package Conversiones;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class ModeloConversion {
    private final List<Conversion> listaConversiones = new ArrayList<Conversion>();
     Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();
    public void agregarConversion(String monedaPrincipal, String monedaCambio, float cantidad){
        try{
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://v6.exchangerate-api.com/v6/34f71f9e3071c2ad8635d747/pair/"+monedaPrincipal+"/"+monedaCambio+"/"+cantidad))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();
            ApiConversion conversionApi = gson.fromJson(json, ApiConversion.class);
            Conversion miConversion = new Conversion(conversionApi);
            listaConversiones.add(miConversion);
            System.out.println("La conversion de "+miConversion.getMonedaPrincipal()+" a "+miConversion.getMonedaCambio()+" es: "+miConversion.getResultado());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void mostrarListaConversiones(){
        listaConversiones.forEach(o-> System.out.println(o.toString()));
    }

}
