package com.example.practica12_pokedex.ui.main.pokeapi;

import com.example.practica12_pokedex.ui.main.models.Pokemon;
import com.example.practica12_pokedex.ui.main.models.PokemonList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface PokeApiService {

    String BASE_URL = "https://pokeapi.co/api/v2/";
    @GET("pokemon/{id}")
    Call<Pokemon> getPokemonById(@Path("id") String id);

    @GET("pokemon")
    Call<PokemonList> getPokemonList(@Query("limit") int limit,
                                     @Query("offset") int offset);
}
