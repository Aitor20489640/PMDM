package com.example.practica09;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.practica09.databinding.FragmentPokemonContinueBinding;


public class PokemonContinueFragment extends Fragment {
    private FragmentPokemonContinueBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentPokemonContinueBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        StringBuilder message = new StringBuilder();

        for (int i = 0; i < PokemonViewModel.listaPokemon.size(); i++) {
            message.append("Jugador " + (i+1) +"\n");
            message.append("Nombre: " + PokemonViewModel.listaPokemon.get(i).getNombre() +"\n");
            message.append("Vida: " + PokemonViewModel.listaPokemon.get(i).getHp() +"\n");
            message.append("Ataque: " + PokemonViewModel.listaPokemon.get(i).getAtk() +"\n");
            message.append("Defensa: " + PokemonViewModel.listaPokemon.get(i).getDef() +"\n");
            message.append("Ataque Especial: " + PokemonViewModel.listaPokemon.get(i).getAtkEsp() +"\n");
            message.append("Defensa Especial: " + PokemonViewModel.listaPokemon.get(i).getDefEsp() +"\n");
            message.append("------------------------\n");

        }


        binding.btnFight.setOnClickListener(l -> {
            if (PokemonViewModel.listaPokemon.size() == 2) {
                NavController navController =  NavHostFragment.findNavController(this);
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setMessage(message)
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        });
                AlertDialog showPokemons = builder.create();
                showPokemons.setTitle("Pokemons");
                showPokemons.show();
                navController.navigate(R.id.action_pokemonContinueFragment_to_main_graph);
            } else {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setMessage("Solo pueden haber dos pokemons en la lista")
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        });
                AlertDialog errorDialog = builder.create();
                if (PokemonViewModel.listaPokemon.size() > 2) {
                    errorDialog.setTitle("Error: Demasiados pokemons");
                } else {
                    errorDialog.setTitle("Error: Insuficientes pokemons");
                }
                errorDialog.show();
            }

        });
    }

}