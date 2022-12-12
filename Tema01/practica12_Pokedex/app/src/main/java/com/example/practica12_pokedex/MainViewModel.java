package com.example.practica12_pokedex;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.practica12_pokedex.ui.main.models.Pokemon;
import com.example.practica12_pokedex.ui.main.models.PokemonList;
import com.example.practica12_pokedex.ui.main.models.PokemonSprite;
import com.example.practica12_pokedex.ui.main.pokeapi.PokeApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainViewModel extends AndroidViewModel {

    private MutableLiveData<List<PokemonSprite>> listSpritesMutableLiveData = new MutableLiveData<>();
    private MutableLiveData<Pokemon> pokemonSeleccionado = new MutableLiveData<>();
    private MutableLiveData<PokemonSprite> spriteSeleccionado = new MutableLiveData<>();
    private MutableLiveData<Integer> offset;
    private Retrofit retrofit;
    private PokeApiService service;
    private int maxPokemon;
    private List<PokemonSprite> spriteList = new ArrayList<>();

    public MainViewModel(@NonNull Application application) {
        super(application);
        offset = new MutableLiveData<>(0);
        retrofit = new Retrofit.Builder()
                .baseUrl("https://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(PokeApiService.class);

        getPokemonList(service, 20, offset.getValue());
    }

    public void seleccionar(PokemonSprite sprite) {
        getPokemonId(service, sprite.getId());
        spriteSeleccionado.setValue(spriteList.get(Integer.parseInt(sprite.getId()) - 1));
    }

    public MutableLiveData<Integer> getOffset() {
        return offset;
    }

    public void actualizarDatos(int outOffset) {
        getPokemonList(service, 20, outOffset);
    }

    public int getMaxPokemon() {
        return maxPokemon;
    }

    public MutableLiveData<Pokemon> Pokemonseleccionado() {
        return pokemonSeleccionado;
    }

    public MutableLiveData<PokemonSprite> spriteSeleccionado() {
        return spriteSeleccionado;
    }

    public MutableLiveData<List<PokemonSprite>> obtener() {
        return listSpritesMutableLiveData;
    }

    private void getPokemonList(PokeApiService pokeService, int limit, int offset) {
        Call<PokemonList> pokeCall =
                pokeService.getPokemonList(limit, offset);
        pokeCall.enqueue(new Callback<PokemonList>() {
            @Override
            public void onResponse(Call<PokemonList> call, Response<PokemonList> response) {
                if (response.isSuccessful()) {
                    PokemonList list = response.body();
                    if (list != null) {
                        listSpritesMutableLiveData.setValue(list.getResults());
                        maxPokemon = list.getCount();
                        spriteList.addAll(list.getResults());
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

    private void getPokemonId(PokeApiService pokeService, String id) {
        Call<Pokemon> pokeCall =
                pokeService.getPokemonById(id);
        pokeCall.enqueue(new Callback<Pokemon>() {
            @Override
            public void onResponse(Call<Pokemon> call, Response<Pokemon> response) {
                if (response.isSuccessful()) {
                    Pokemon p = response.body();
                    if (p != null) {
                        pokemonSeleccionado.setValue(p);
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
