package com.example.practica12_pokedex.main.ui.pokeapi;

import com.example.practica12_pokedex.main.items.models.Item;
import com.example.practica12_pokedex.main.items.models.ItemList;
import com.example.practica12_pokedex.main.ui.models.Pokemon;
import com.example.practica12_pokedex.main.ui.models.PokemonList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface PokeApiService {

    String BASE_URL = "https://pokeapi.co/api/v2/";
    @GET("pokemon/{name}")
    Call<Pokemon> getPokemonByName(@Path("name") String id);

    @GET("pokemon")
    Call<PokemonList> getPokemonList(@Query("limit") int limit,
                                     @Query("offset") int offset);

    @GET("item/{name}")
    Call<Item> getItemByName(@Path("name") String id);

    @GET("item")
    Call<ItemList> getItemList(@Query("limit") int limit, @Query("offset") int offset);

}
