package org.hmis;

import java.io.FileReader;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JsonReader {

    public static Coche[] leerCochesJSON(String archivo) throws IOException {
        if (archivo == null) {
            throw new IllegalArgumentException("Archivo no puede ser null");
        }

        Coche[] coches = null;
        Gson gson = new Gson();
        JsonParser parser = new JsonParser();

        try (FileReader reader = new FileReader(archivo)) {
            JsonObject jsonObject = parser.parse(reader).getAsJsonObject();
            JsonArray cochesJson = jsonObject.getAsJsonArray("coches");
            coches = gson.fromJson(cochesJson, Coche[].class);

        } 
        return coches;
    }
}