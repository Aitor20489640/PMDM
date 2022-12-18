package com.example.practica12_pokedex.main.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.practica12_pokedex.main.ui.viewmodel.MainViewModel;
import com.example.practica12_pokedex.databinding.FragmentPokemonDetailsBinding;
import com.example.practica12_pokedex.main.ui.models.Pokemon;
import com.example.practica12_pokedex.main.ui.models.PokemonSprite;

public class PokemonDetailsFragment extends Fragment {
    private FragmentPokemonDetailsBinding binding;
    PokemonSprite sprite;
    Pokemon pokemon;
    MainViewModel mainViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainViewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);

        this.pokemon = mainViewModel.getPokemonSeleccionado().getValue();
        this.sprite = mainViewModel.getSpriteSeleccionado().getValue();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.setPokemon(sprite);
        binding.setPokemonInfo(pokemon);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return (binding = FragmentPokemonDetailsBinding.inflate(inflater, container, false)).getRoot();
    }
}