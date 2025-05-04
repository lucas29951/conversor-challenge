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

    public void convertirMoneda(String base, String target, double monto) {
        JsonObject respuesta = consulta.realizarConsulta("/pair/" + base + "/" + target + "/" + monto);

        String estado = respuesta.get("result").getAsString();
        double tasa = respuesta.get("conversion_rate").getAsDouble();

        double resultado = monto * tasa;
    }

    public void obtenerMonedas() {
        JsonObject respuesta = consulta.realizarConsulta("/codes");

        String estado = respuesta.get("result").getAsString();
        
    }
}
