package com.example.practica12_pokedex.main.items;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;


import com.example.practica12_pokedex.main.items.models.Item;
import com.example.practica12_pokedex.main.items.models.ItemListDetails;
import com.example.practica12_pokedex.main.ui.pokeapi.PokeApiClient;

import java.util.List;

public class ItemsViewModel extends AndroidViewModel {
    MutableLiveData<Item> selectedItemMutableLiveData = new MutableLiveData<>();
    MutableLiveData<List<ItemListDetails>> listElementosMutableLiveData = new MutableLiveData<>();
    ItemListDetails selected;

    public ItemsViewModel(@NonNull Application application) {
        super(application);
        PokeApiClient.getItemList(listElementosMutableLiveData);
    }

    MutableLiveData<List<ItemListDetails>> getAll(){
        return listElementosMutableLiveData;
    }

    public void select(ItemListDetails itemListDetails) {
        selected = itemListDetails;
    }

    public MutableLiveData<Item> getSelected() {
        PokeApiClient.getItem(selected.getName(), selectedItemMutableLiveData);
        return selectedItemMutableLiveData;
    }
}
