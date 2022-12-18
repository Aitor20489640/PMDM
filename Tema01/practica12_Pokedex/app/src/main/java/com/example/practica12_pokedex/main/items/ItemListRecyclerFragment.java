package com.example.practica12_pokedex.main.items;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.practica12_pokedex.R;
import com.example.practica12_pokedex.databinding.FragmentItemListRecyclerBinding;
import com.example.practica12_pokedex.databinding.ViewholderItemListBinding;
import com.example.practica12_pokedex.main.items.models.ItemListDetails;

import java.util.List;

public class ItemListRecyclerFragment extends Fragment {
    private FragmentItemListRecyclerBinding binding;
    private ItemsViewModel itemsViewModel;
    private NavController navController;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentItemListRecyclerBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        itemsViewModel = new ViewModelProvider(requireActivity()).get(ItemsViewModel.class);
        navController = Navigation.findNavController(view);
        ItemAdapter itemAdapter = new ItemAdapter();
        binding.recyclerViewItem.setAdapter(itemAdapter);

        // Cuando cambia el viewmodel se actualiza la lista con setList(List<ItemListDetails> itemList)
        itemsViewModel.getAll().observe(getViewLifecycleOwner(), itemAdapter::setList);
    }

    class ItemAdapter extends RecyclerView.Adapter<ItemViewHolder> {
        List<ItemListDetails> itemsList;

        @NonNull
        @Override
        public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new ItemViewHolder(ViewholderItemListBinding.inflate(getLayoutInflater(), parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
            ItemListDetails element = itemsList.get(position);
            holder.binding.setItem(element);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemsViewModel.select(element);
                    navController.navigate(R.id.action_itemListRecyclerFragment_to_itemsDetailsFragment);
                }
            });
        }

        @Override
        public int getItemCount() {
            return itemsList != null ? itemsList.size() : 0;
        }

        public void setList(List<ItemListDetails> itemList){
            this.itemsList = itemList;
            notifyDataSetChanged();
        }
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {
        private final ViewholderItemListBinding binding;

        public ItemViewHolder(ViewholderItemListBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}