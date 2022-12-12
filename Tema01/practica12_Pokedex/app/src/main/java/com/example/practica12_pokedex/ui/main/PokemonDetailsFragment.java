package com.example.practica12_pokedex.ui.main;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.practica12_pokedex.MainViewModel;
import com.example.practica12_pokedex.databinding.FragmentPokemonDetailsBinding;
import com.example.practica12_pokedex.ui.main.constats.Constants;
import com.example.practica12_pokedex.ui.main.constats.TypeUtil;
import com.example.practica12_pokedex.ui.main.models.Pokemon;
import com.example.practica12_pokedex.ui.main.models.PokemonSprite;
import com.skydoves.androidribbon.RibbonView;

import java.util.ArrayList;
import java.util.List;

public class PokemonDetailsFragment extends Fragment {
    private FragmentPokemonDetailsBinding binding;
    PokemonSprite sprite;
    MainViewModel mainViewModel;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mainViewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);


        mainViewModel.spriteSeleccionado().observe(getViewLifecycleOwner(), spritePokemon -> sprite = spritePokemon);
        mainViewModel.Pokemonseleccionado().observe(getViewLifecycleOwner(), pokemon -> {
            List<RibbonView> ribbons = new ArrayList<>();
            for (Pokemon.TypeResponse types : pokemon.getTypes()) {
                RibbonView ribbonView = new RibbonView.Builder(getContext())
                        .setText(types.getType().getName())
                        .setTextColor(Color.BLACK)
                        .setTextSize(13f)
                        .setRibbonBackgroundColor(ContextCompat.getColor(getContext(), TypeUtil.getTypeColor(types.getType().getName())))
                        .build();
                ribbons.add(ribbonView);
            }
            binding.index.setText(pokemon.getId());
            binding.name.setText(sprite.getName());
            Glide.with(getContext())
                    .load(sprite.getImageUrl())
                    .centerCrop()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(binding.image);
            if (ribbons.size() == 1) {
                binding.ribbonRecyclerView.addRibbon(ribbons.get(0));
            } else {
                binding.ribbonRecyclerView.addRibbonList(ribbons);
            }
            binding.weight.setText(pokemon.getWeight());
            binding.height.setText(pokemon.getHeight());
            binding.progressHp.setLabelText(pokemon.getHpString());
            binding.progressHp.setMax(Constants.maxHp);
            binding.progressHp.setProgress(pokemon.getHp());
            binding.progressAttack.setLabelText(pokemon.getAttackString());
            binding.progressAttack.setMax(Constants.maxAttack);
            binding.progressAttack.setProgress(pokemon.getAttack());
            binding.progressDefense.setLabelText(pokemon.getDefenseString());
            binding.progressDefense.setMax(Constants.maxDefense);
            binding.progressDefense.setProgress(pokemon.getDefense());
            binding.progressSpeed.setLabelText(pokemon.getSpeedString());
            binding.progressSpeed.setMax(Constants.maxSpeed);
            binding.progressSpeed.setProgress(pokemon.getSpeed());
            binding.progressExp.setLabelText(pokemon.getExpString());
            binding.progressExp.setMax(Constants.maxExp);
            binding.progressExp.setProgress(pokemon.getExp());

        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return (binding = FragmentPokemonDetailsBinding.inflate(inflater, container, false)).getRoot();
    }
}