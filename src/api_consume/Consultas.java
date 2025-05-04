package api_consume;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Consultas {

    private static final String API_KEY = "c522ae55ca4785086b3b3fa6";
    public static final String BASE_URL = "https://v6.exchangerate-api.com/v6/";

    public JsonObject realizarConsulta(String peticion) {

        URI direccion = URI.create(BASE_URL + API_KEY + peticion);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(direccion).build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            JsonElement element = JsonParser.parseString(response.body());
            return element.getAsJsonObject();
        } catch (Exception e) {
            throw new RuntimeException("Error en la consulta: " + e.getMessage());
        }
    }
}
