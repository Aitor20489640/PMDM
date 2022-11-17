package com.example.practica09;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PokeApi pokeApi = new PokeApiClient();
        PokemonSpecies bulbasaur = pokeApi.getPokemonSpecies(1);
        System.out.println(bulbasaur);
    }
}