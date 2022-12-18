package com.example.practica12_pokedex.main.items;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.practica12_pokedex.databinding.FragmentItemDetailsBinding;
import com.example.practica12_pokedex.main.items.models.Item;

public class ItemsDetailsFragment extends Fragment {

    private FragmentItemDetailsBinding binding;
    private ItemsViewModel itemsViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        itemsViewModel = new ViewModelProvider(requireActivity()).get(ItemsViewModel.class);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        itemsViewModel.getSelected().observe(getViewLifecycleOwner(), new Observer<Item>() {
            @Override
            public void onChanged(Item obj) {
                binding.setItem(obj);
            }
        });
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return (binding = FragmentItemDetailsBinding.inflate(inflater, container, false)).getRoot();

    }
}