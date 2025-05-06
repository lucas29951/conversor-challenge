package functions;

import api_consume.Consultas;
import com.google.gson.JsonObject;

public class Conversor {

    private static final Consultas consulta = new Consultas();

    public void obtenerTasa(String base, String target) {
        JsonObject respuesta = consulta.realizarConsulta("/pair/" + base + "/" + target);

        String estado = respuesta.get("result").getAsString();

        if (estado.compareToIgnoreCase("success") == 0) {
            double tasa = respuesta.get("conversion_rate").getAsDouble();

            System.out.println("La tasa de conversion entre [" + base + "] y [" + target + "] es de: " + tasa);
        }
    }

    public double convertirMoneda(String base, String target, double monto) {
        JsonObject respuesta = consulta.realizarConsulta("/pair/" + base + "/" + target);

        double resultado = 0;
        String estado = respuesta.get("result").getAsString();

        if (estado.compareToIgnoreCase("success") == 0) {
            double tasa = respuesta.get("conversion_rate").getAsDouble();

            resultado = calcularMonto(tasa, monto);
        }
        return resultado;
    }

    private double calcularMonto(double tasa, double monto) {
        return monto * tasa;
    }

    public void obtenerMonedas() {
        JsonObject respuesta = consulta.realizarConsulta("/codes");

        String estado = respuesta.get("result").getAsString();
        
    }
}
