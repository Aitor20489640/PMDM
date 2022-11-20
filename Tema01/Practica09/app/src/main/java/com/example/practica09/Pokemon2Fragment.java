package com.example.practica09;


import android.app.AlertDialog;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.practica09.databinding.FragmentPokemon2Binding;

public class Pokemon2Fragment extends Fragment {

    private @NonNull
    FragmentPokemon2Binding binding;
    private Pokemon pokemon = null;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentPokemon2Binding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final PokemonViewModel pokemonViewModel = new ViewModelProvider(this).get(PokemonViewModel.class);

        binding.btnValidate2.setOnClickListener(view1 -> {
            boolean error = false;

            String nombre;
            int hp = 0;
            int atk = 0;
            int def = 0;
            int atkEsp = 0;
            int defEsp = 0;



            nombre = binding.txtNombrePokemon2.getText().toString();
            try {
                hp = Integer.parseInt(binding.txtHpPokemon2.getText().toString());
            } catch (NumberFormatException e) {
                binding.txtHpPokemon2.setError("Introduce un numero");
                error = true;
            }
            try {
                atk = Integer.parseInt(binding.txtAtkPokemon2.getText().toString());
            } catch (NumberFormatException e) {
                binding.txtAtkPokemon2.setError("Introduce un numero");
                error = true;
            }
            try {
                def = Integer.parseInt(binding.txtDefPokemon2.getText().toString());
            } catch (NumberFormatException e) {
                binding.txtDefPokemon2.setError("Introduce un numero");
                error = true;
            }
            try {
                atkEsp = Integer.parseInt(binding.txtAtkEspPokemon2.getText().toString());
            } catch (NumberFormatException e) {
                binding.txtAtkEspPokemon2.setError("Introduce un numero");
                error = true;
            }
            try {
                defEsp = Integer.parseInt(binding.txtDefEspPokemon2.getText().toString());
            } catch (NumberFormatException e) {
                binding.txtDefEspPokemon2.setError("Introduce un numero");
                error = true;
            }

            if (!error) {
                pokemonViewModel.crearPokemon(nombre, hp, atk, def, atkEsp, defEsp);
            }
        });

        pokemonViewModel.pValidado.observe(getViewLifecycleOwner(), validado -> {
            if (validado) {
                binding.btnSave2.setEnabled(true);
            }
        });

        pokemonViewModel.pokemon.observe(getViewLifecycleOwner(), pokemonV -> pokemon = pokemonV);

        pokemonViewModel.errorNombre.observe(getViewLifecycleOwner(), nombre -> {
            if (nombre != null) {
                binding.txtNombrePokemon2.setError(nombre);
                binding.btnSave2.setEnabled(false);
            } else {
                binding.txtNombrePokemon2.setError(null);
            }
        });

        pokemonViewModel.errorHp.observe(getViewLifecycleOwner(), vida -> {
            if (vida != null) {
                binding.txtHpPokemon2.setError(vida);
                binding.btnSave2.setEnabled(false);
            } else {
                binding.txtHpPokemon2.setError(null);
            }
        });

        pokemonViewModel.errorAtk.observe(getViewLifecycleOwner(), atk -> {
            if (atk != null) {
                binding.txtAtkPokemon2.setError(atk);
                binding.btnSave2.setEnabled(false);
            } else {
                binding.txtAtkPokemon2.setError(null);
            }
        });

        pokemonViewModel.errorDef.observe(getViewLifecycleOwner(), def -> {
            if (def != null) {
                binding.txtDefPokemon2.setError(def);
                binding.btnSave2.setEnabled(false);
            } else {
                binding.txtDefPokemon2.setError(null);
            }
        });

        pokemonViewModel.errorAtkEsp.observe(getViewLifecycleOwner(), atkEsp -> {
            if (atkEsp != null) {
                binding.txtAtkEspPokemon2.setError(atkEsp);
                binding.btnSave2.setEnabled(false);
            } else {
                binding.txtAtkEspPokemon2.setError(null);
            }
        });

        pokemonViewModel.errorDefEsp.observe(getViewLifecycleOwner(), defEsp -> {
            if (defEsp != null) {
                binding.txtDefEspPokemon2.setError(defEsp);
                binding.btnSave2.setEnabled(false);
            } else {
                binding.txtDefEspPokemon2.setError(null);
            }
        });

        binding.txtNombrePokemon2.addTextChangedListener(new TextChangedListener<EditText>(binding.txtNombrePokemon2) {
            @Override
            public void onTextChanged(EditText target, Editable s) {
                binding.btnSave2.setEnabled(false);
            }
        });

        binding.txtHpPokemon2.addTextChangedListener(new TextChangedListener<EditText>(binding.txtHpPokemon2) {
            @Override
            public void onTextChanged(EditText target, Editable s) {
                binding.btnSave2.setEnabled(false);
            }
        });

        binding.txtAtkPokemon2.addTextChangedListener(new TextChangedListener<EditText>(binding.txtAtkPokemon2) {
            @Override
            public void onTextChanged(EditText target, Editable s) {
                binding.btnSave2.setEnabled(false);
            }
        });

        binding.txtDefPokemon2.addTextChangedListener(new TextChangedListener<EditText>(binding.txtDefPokemon2) {
            @Override
            public void onTextChanged(EditText target, Editable s) {
                binding.btnSave2.setEnabled(false);
            }
        });

        binding.txtAtkEspPokemon2.addTextChangedListener(new TextChangedListener<EditText>(binding.txtAtkEspPokemon2) {
            @Override
            public void onTextChanged(EditText target, Editable s) {
                binding.btnSave2.setEnabled(false);
            }
        });

        binding.txtDefEspPokemon2.addTextChangedListener(new TextChangedListener<EditText>(binding.txtDefEspPokemon2) {
            @Override
            public void onTextChanged(EditText target, Editable s) {
                binding.btnSave2.setEnabled(false);
            }
        });

        binding.btnSave2.setOnClickListener(l -> {
            PokemonViewModel.listaPokemon.add(pokemon);
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setMessage("Se ha guardado el " + pokemon.getNombre());
            builder.setPositiveButton("Okay", ((dialogInterface, i) -> {
                dialogInterface.cancel();
            }));
            AlertDialog saved = builder.create();
            saved.setTitle("Guardado");
            saved.show();
        });
    }

}