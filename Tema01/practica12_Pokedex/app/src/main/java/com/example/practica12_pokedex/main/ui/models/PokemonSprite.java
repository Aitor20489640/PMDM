package com.example.practica12_pokedex.main.ui.models;

public class PokemonSprite {
    private int page = 0;
    private String name;
    private String url;

    public String getImageUrl() {
        String[] urlSplit = url.substring(7, url.length() - 1).split("/");
        String index = urlSplit[urlSplit.length - 1];
        return String.format("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/%s.png",index);
    }

    public String getName() {
        return name;
    }
}
