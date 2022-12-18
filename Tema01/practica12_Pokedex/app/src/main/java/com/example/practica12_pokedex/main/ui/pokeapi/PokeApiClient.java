package com.example.practica12_pokedex.main.ui.pokeapi;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.example.practica12_pokedex.main.items.models.Item;
import com.example.practica12_pokedex.main.items.models.ItemList;
import com.example.practica12_pokedex.main.items.models.ItemListDetails;
import com.example.practica12_pokedex.main.ui.models.Pokemon;
import com.example.practica12_pokedex.main.ui.models.PokemonList;
import com.example.practica12_pokedex.main.ui.models.PokemonSprite;

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
                service.getPokemonByName(name);
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

    public static void getItemList(MutableLiveData<List<ItemListDetails>> listItems) {
        Call<ItemList> pokeCall = service.getItemList(1607, 0);
        pokeCall.enqueue(new Callback<ItemList>() {
            @Override
            public void onResponse(@NonNull Call<ItemList> call, @NonNull Response<ItemList> response) {
                if (response.isSuccessful()) {
                    ItemList list = response.body();
                    if (list != null) {
                        listItems.setValue(list.getResults());
                    }

                } else {
                    Log.e("QWERTY", " onResponse: " + response.errorBody());
                }
            }

            @Override
            public void onFailure(@NonNull Call<ItemList> call, @NonNull Throwable t) {
                Log.e("QWERTY", " onFailure: " + t.getMessage());
            }
        });
    }

    public static void getItem(String name, MutableLiveData<Item> item) {
        Call<Item> pokeCall = service.getItemByName(name);
        pokeCall.enqueue(new Callback<Item>() {
            @Override
            public void onResponse(@NonNull Call<Item> call, @NonNull Response<Item> response) {
                if (response.isSuccessful()) {
                    Item obj = response.body();
                    if (obj != null) {
                        item.setValue(obj);
                    }
                } else {
                    Log.e("QWERTY", " onResponse: " + response.errorBody());
                }
            }

            @Override
            public void onFailure(@NonNull Call<Item> call, @NonNull Throwable t) {
                Log.e("QWERTY", " onFailure: " + t.getMessage());
            }
        });
    }
}
