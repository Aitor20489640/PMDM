package com.example.practica12_pokedex.ui.main.pokeapi;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.practica12_pokedex.ui.main.models.Pokemon;
import com.example.practica12_pokedex.ui.main.models.PokemonList;
import com.example.practica12_pokedex.ui.main.models.PokemonSprite;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PokeApiClient {
    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
            .build();
    private static PokeApiService service = retrofit.create(PokeApiService.class);

    public static void getPokemonList(int offset, MutableLiveData<List<PokemonSprite>> listPokemons){
        Call<PokemonList> pokeCall =
                service.getPokemonList(1154, 0);
        pokeCall.enqueue(new Callback<PokemonList>() {
            @Override
            public void onResponse(Call<PokemonList> call, Response<PokemonList> response) {
                if (response.isSuccessful()) {
                    PokemonList list = response.body();
                    if (list != null) {
                        listPokemons.setValue(list.getResults());
                    }

                } else {
                    Log.e("Pokedex12", " onResponse: " + response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<PokemonList> call, Throwable t) {
                Log.e("Pokedex12", " onFailure: " + t.getMessage());
            }
        });
    }

    public static void getPokemonInfo(String name, MutableLiveData<Pokemon> pokemon) {
        Call<Pokemon> pokeCall =
                service.getPokemonById(name);
        pokeCall.enqueue(new Callback<Pokemon>() {
            @Override
            public void onResponse(Call<Pokemon> call, Response<Pokemon> response) {
                if (response.isSuccessful()) {
                    Pokemon p = response.body();
                    if (p != null) {
                        pokemon.setValue(p);
                    }
                } else {
                    Log.e("Pokedex12", " onResponse: " + response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<Pokemon> call, Throwable t) {
                Log.e("Pokedex12", " onFailure: " + t.getMessage());
            }
        });
    }
}
