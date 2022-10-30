package com.example.practica06Guiada;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import com.example.practica06Guiada.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((binding = ActivityMainBinding.inflate(getLayoutInflater())).getRoot());

        setSupportActionBar(binding.toolbar);

        binding.actionGotoDrawerActivity.setOnClickListener( e -> startActivity(new Intent(MainActivity.this, DrawerActivity.class)));

        binding.actionGotoBottomActivity.setOnClickListener( e -> startActivity(new Intent(MainActivity.this, BottomActivity.class)));

        binding.actionGotoOptionsActivity.setOnClickListener(e -> startActivity(new Intent(MainActivity.this, OptionsActivity.class)));

        binding.actionGotoTabbedActivity.setOnClickListener( e -> startActivity(new Intent(MainActivity.this, TabbedActivity.class)));
    }
}
