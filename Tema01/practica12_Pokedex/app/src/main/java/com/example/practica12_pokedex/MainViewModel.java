package com.example.practica12_pokedex;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

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

    MutableLiveData<List<PokemonSprite>> listSpritesMutableLiveData = new MutableLiveData<>();

    public MainViewModel(@NonNull Application application) {
        super(application);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        PokeApiService service = retrofit.create(PokeApiService.class);

        getPokemonList(service, 20, 0);
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
                    }

                }


                else {
                    Log.e("Pokedex", " onResponse: " + response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<PokemonList> call, Throwable t) {
                Log.e("Pokedex", " onFailure: " + t.getMessage());
            }
        });
    }
}
