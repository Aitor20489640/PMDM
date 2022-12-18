package com.example.practica12_pokedex.main.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.practica12_pokedex.main.ui.viewmodel.MainViewModel;
import com.example.practica12_pokedex.R;
import com.example.practica12_pokedex.databinding.FragmentRecyclerPokemonsBinding;
import com.example.practica12_pokedex.databinding.ViewholderPokemonBinding;
import com.example.practica12_pokedex.main.ui.models.PokemonSprite;

import java.util.List;

public class RecyclerSpritesFragment extends Fragment {
    private FragmentRecyclerPokemonsBinding binding;
    private MainViewModel mainViewModel;
    private NavController navController;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return (binding = FragmentRecyclerPokemonsBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mainViewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);
        navController = Navigation.findNavController(view);

        PokemonAdapter pokemonAdapter = new PokemonAdapter();
        binding.recyclerView.setAdapter(pokemonAdapter);

        mainViewModel.obtener().observe(getViewLifecycleOwner(), pokemonAdapter::establecerLista);
    }

    class PokemonAdapter extends RecyclerView.Adapter<PokemonViewHolder> {
        List<PokemonSprite> pokemonList;


        @NonNull
        @Override
        public PokemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new PokemonViewHolder(ViewholderPokemonBinding.inflate(getLayoutInflater(), parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull PokemonViewHolder holder, int position) {
            PokemonSprite p = pokemonList.get(position);

            holder.binding.setPokemon(p);

            holder.itemView.setOnClickListener(view -> {
                mainViewModel.seleccionar(p);
                navController.navigate(R.id.action_recyclerSpritesFragment_to_pokemonDetailsFragment);

            });
        }

        @Override
        public int getItemCount() {
            return pokemonList != null ? pokemonList.size() : 0;
        }

        public void establecerLista(List<PokemonSprite> pokemonList) {
            this.pokemonList = pokemonList;
            notifyDataSetChanged();
        }
    }

    class PokemonViewHolder extends RecyclerView.ViewHolder {
        private final ViewholderPokemonBinding binding;

        public PokemonViewHolder(ViewholderPokemonBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
