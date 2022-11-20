package com.example.practica09;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.practica09.databinding.FragmentPokemon1Binding;


public class Pokemon1Fragment extends Fragment {
    private @NonNull FragmentPokemon1Binding binding;
    private Pokemon pokemon = null;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentPokemon1Binding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final PokemonViewModel pokemonViewModel = new ViewModelProvider(this).get(PokemonViewModel.class);

        binding.btnValidate.setOnClickListener(view1 -> {
            boolean error = false;

            String nombre;
            int hp = 0;
            int atk = 0;
            int def = 0;
            int atkEsp = 0;
            int defEsp = 0;



            nombre = binding.txtNombrePokemon.getText().toString();
            try {
                hp = Integer.parseInt(binding.txtHpPokemon.getText().toString());
            } catch (NumberFormatException e) {
                binding.txtHpPokemon.setError("Introduce un numero");
                error = true;
            }
            try {
                atk = Integer.parseInt(binding.txtAtkPokemon.getText().toString());
            } catch (NumberFormatException e) {
                binding.txtAtkPokemon.setError("Introduce un numero");
                error = true;
            }
            try {
                def = Integer.parseInt(binding.txtDefPokemon.getText().toString());
            } catch (NumberFormatException e) {
                binding.txtDefPokemon.setError("Introduce un numero");
                error = true;
            }
            try {
                atkEsp = Integer.parseInt(binding.txtAtkEspPokemon.getText().toString());
            } catch (NumberFormatException e) {
                binding.txtAtkEspPokemon.setError("Introduce un numero");
                error = true;
            }
            try {
                defEsp = Integer.parseInt(binding.txtDefEspPokemon.getText().toString());
            } catch (NumberFormatException e) {
                binding.txtDefEspPokemon.setError("Introduce un numero");
                error = true;
            }

            if (!error) {
                pokemonViewModel.crearPokemon(nombre, hp, atk, def, atkEsp, defEsp);
            }
        });

        pokemonViewModel.pValidado.observe(getViewLifecycleOwner(), validado -> {
            if (validado) {
                binding.btnSave.setEnabled(true);
            }
        });

        pokemonViewModel.pokemon.observe(getViewLifecycleOwner(), pokemonV -> pokemon = pokemonV);

        pokemonViewModel.errorNombre.observe(getViewLifecycleOwner(), nombre -> {
            if (nombre != null) {
                binding.txtNombrePokemon.setError(nombre);
                binding.btnSave.setEnabled(false);
            } else {
                binding.txtNombrePokemon.setError(null);
            }
        });

        pokemonViewModel.errorHp.observe(getViewLifecycleOwner(), vida -> {
            if (vida != null) {
                binding.txtHpPokemon.setError(vida);
                binding.btnSave.setEnabled(false);
            } else {
                binding.txtHpPokemon.setError(null);
            }
        });

        pokemonViewModel.errorAtk.observe(getViewLifecycleOwner(), atk -> {
            if (atk != null) {
                binding.txtAtkPokemon.setError(atk);
                binding.btnSave.setEnabled(false);
            } else {
                binding.txtAtkPokemon.setError(null);
            }
        });

        pokemonViewModel.errorDef.observe(getViewLifecycleOwner(), def -> {
            if (def != null) {
                binding.txtDefPokemon.setError(def);
                binding.btnSave.setEnabled(false);
            } else {
                binding.txtDefPokemon.setError(null);
            }
        });

        pokemonViewModel.errorAtkEsp.observe(getViewLifecycleOwner(), atkEsp -> {
            if (atkEsp != null) {
                binding.txtAtkEspPokemon.setError(atkEsp);
                binding.btnSave.setEnabled(false);
            } else {
                binding.txtAtkEspPokemon.setError(null);
            }
        });

        pokemonViewModel.errorDefEsp.observe(getViewLifecycleOwner(), defEsp -> {
            if (defEsp != null) {
                binding.txtDefEspPokemon.setError(defEsp);
                binding.btnSave.setEnabled(false);
            } else {
                binding.txtDefEspPokemon.setError(null);
            }
        });

        binding.txtNombrePokemon.addTextChangedListener(new TextChangedListener<EditText>(binding.txtNombrePokemon) {
            @Override
            public void onTextChanged(EditText target, Editable s) {
                binding.btnSave.setEnabled(false);
            }
        });

        binding.txtHpPokemon.addTextChangedListener(new TextChangedListener<EditText>(binding.txtHpPokemon) {
            @Override
            public void onTextChanged(EditText target, Editable s) {
                binding.btnSave.setEnabled(false);
            }
        });

        binding.txtAtkPokemon.addTextChangedListener(new TextChangedListener<EditText>(binding.txtAtkPokemon) {
            @Override
            public void onTextChanged(EditText target, Editable s) {
                binding.btnSave.setEnabled(false);
            }
        });

        binding.txtDefPokemon.addTextChangedListener(new TextChangedListener<EditText>(binding.txtDefPokemon) {
            @Override
            public void onTextChanged(EditText target, Editable s) {
                binding.btnSave.setEnabled(false);
            }
        });

        binding.txtAtkEspPokemon.addTextChangedListener(new TextChangedListener<EditText>(binding.txtAtkEspPokemon) {
            @Override
            public void onTextChanged(EditText target, Editable s) {
                binding.btnSave.setEnabled(false);
            }
        });

        binding.txtDefEspPokemon.addTextChangedListener(new TextChangedListener<EditText>(binding.txtDefEspPokemon) {
            @Override
            public void onTextChanged(EditText target, Editable s) {
                binding.btnSave.setEnabled(false);
            }
        });

        binding.btnSave.setOnClickListener(l -> {
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