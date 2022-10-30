package com.example.practica05;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class Onboarding0Fragment extends Fragment {

    Button botonStart;
    NavController navController;
    Button botonSkip;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_onboarding0, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);

        botonStart = view.findViewById(R.id.botonStart);

        botonSkip = view.findViewById(R.id.Skip);

        botonStart.setOnClickListener(e -> navController.navigate(R.id.action_onboarding0Fragment_to_onboarding1Fragment));

        botonSkip.setOnClickListener(e -> navController.navigate(R.id.action_onboarding0Fragment_to_homeFragment));
    }
}