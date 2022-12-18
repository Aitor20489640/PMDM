package com.example.practica12_pokedex.main.items.CustomDeserializer;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

public class EfectosDeserializer implements JsonDeserializer<String> {
    @Override
    public String deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        StringBuilder str = new StringBuilder();
        JsonArray array = json.getAsJsonArray();

        for (JsonElement element : array) {
            str.append(element.getAsJsonObject().get("short_effect").getAsString());
        }

        return str.toString();
    }
}
