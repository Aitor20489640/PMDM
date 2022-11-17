package com.example.practica06;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.practica06.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    NavController drawerNavController;
    NavController bottomNavController;
    NavController optionsNavController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((binding = ActivityMainBinding.inflate(getLayoutInflater())).getRoot());

        setSupportActionBar(binding.toolbar);

        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                // Top-level destinations:
                R.id.drawer1Fragment, R.id.drawer2Fragment
        )
                .setOpenableLayout(binding.drawerLayout)
                .build();

        drawerNavController = ((NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_drawer_fragment)).getNavController();
        NavigationUI.setupWithNavController(binding.navView, drawerNavController);
        NavigationUI.setupWithNavController(binding.toolbar, drawerNavController, appBarConfiguration);

        bottomNavController = ((NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_bottom_fragment)).getNavController();
        NavigationUI.setupWithNavController(binding.bottomNavView, bottomNavController);
        NavigationUI.setupWithNavController(binding.toolbar, bottomNavController);

        AppBarConfiguration optionsAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.options1Fragment, R.id.options2Fragment
        )
                .build();

        optionsNavController = ((NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_options_fragment)).getNavController();
        NavigationUI.setupWithNavController(binding.toolbar, optionsNavController, optionsAppBarConfiguration);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return NavigationUI.onNavDestinationSelected(item, optionsNavController)
                || super.onOptionsItemSelected(item);
    }
}
