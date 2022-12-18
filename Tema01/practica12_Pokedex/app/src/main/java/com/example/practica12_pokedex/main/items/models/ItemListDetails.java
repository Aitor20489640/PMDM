package com.example.practica12_pokedex.main.items.models;

public class ItemListDetails {
    private String name;


    public String getName() {
        return name;
    }

    public String getUrl() {
        String index = this.name;
        return String.format("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/items/%s.png", index);
    }
}
