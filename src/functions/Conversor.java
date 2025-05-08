package functions;

import api_consume.Consultas;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import models.Moneda;

import java.util.ArrayList;
import java.util.List;

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
        List<Moneda> monedas = new ArrayList<>();

        JsonObject respuesta = consulta.realizarConsulta("/codes");

        String estado = respuesta.get("result").getAsString();
        if (estado.compareToIgnoreCase("success") == 0) {
            JsonArray codigos = respuesta.get("supported_codes").getAsJsonArray();

            for (JsonElement e : codigos) {
                JsonArray moneda = e.getAsJsonArray();
                String codigo = moneda.get(0).getAsString();
                String pais = moneda.get(1).getAsString();

                monedas.add(new Moneda(codigo, pais));
            }

            for (Moneda m : monedas) {
                System.out.println(m);
            }
        }
    }
}
