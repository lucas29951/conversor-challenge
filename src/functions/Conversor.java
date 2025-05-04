package functions;

import api_consume.Consultas;
import com.google.gson.JsonObject;

public class Conversor {

    private static final Consultas consulta = new Consultas();

    public void obtenerTasa(String base, String target) {
        JsonObject respuesta = consulta.realizarConsulta("/pair/" + base + "/" + target);

        String estado = respuesta.get("result").getAsString();
        double tasa = respuesta.get("conversion_rate").getAsDouble();
    }
}
