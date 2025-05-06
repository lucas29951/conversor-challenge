package utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GeneradorArchivo {

    private final String ARCHIVO = "src/resources/historial.json";
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    private List<String> cargarHistorial() {
        try (Reader reader = new FileReader(ARCHIVO)) {
            String[] historialArray = gson.fromJson(reader, String[].class);
            List<String> historial = new ArrayList<>();
            if (historialArray != null) {
                for (String s : historialArray) {
                    historial.add(s);
                }
            }
            return historial;
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    public void guardarConversion(String conversion) {
        List<String> historial = cargarHistorial();
        historial.add(conversion);
        try (Writer writer = new FileWriter(ARCHIVO)) {
            gson.toJson(historial, writer);
        } catch (IOException e) {
            System.out.println("Error al guardar el historial: " + e.getMessage());
        }
    }
}
