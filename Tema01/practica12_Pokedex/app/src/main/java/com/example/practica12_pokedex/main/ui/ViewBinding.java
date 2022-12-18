package com.example.practica12_pokedex.main.ui;

import android.graphics.Color;
import android.graphics.Typeface;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.practica12_pokedex.main.ui.utils.TypeUtil;
import com.example.practica12_pokedex.main.ui.models.Pokemon;
import com.skydoves.androidribbon.RibbonRecyclerView;
import com.skydoves.androidribbon.RibbonView;
import com.skydoves.progressview.ProgressView;

import java.util.List;

public class ViewBinding {
    @BindingAdapter("paletteImage")
    public static void bindLoadImagePalette(ImageView view, String url) {
        Glide.with(view.getContext())
                .load(url)
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(view);
    }

    @BindingAdapter("bindPokemonTypes")
    public static void bindPokemonTypes(RibbonRecyclerView recyclerView, List<Pokemon.TypeResponse> types) {
        if (types != null) {
            if (!types.isEmpty()) {
                recyclerView.clear();
                for (Pokemon.TypeResponse type : types) {
                    recyclerView.addRibbon(new RibbonView.Builder(recyclerView.getContext())
                            .setText(type.getType().getName())
                            .setTextColor(Color.WHITE)
                            .setPaddingLeft(84f)
                            .setPaddingRight(84f)
                            .setPaddingTop(2f)
                            .setPaddingBottom(10f)
                            .setTextSize(16f)
                            .setRibbonRadius(120f)
                            .setTextStyle(Typeface.BOLD)
                            .setRibbonBackgroundColorResource(
                                    TypeUtil.getTypeColor(type.getType().getName())
                            ).build());
                }
            }
        }
    }

    @BindingAdapter("progressView_labelText")
    public static void bindProgressViewLabelText(ProgressView progressView, String text) {
        progressView.setLabelText(text);
    }

    @BindingAdapter("progressView_progress")
    public static void bindProgressViewProgress(ProgressView progressView, Integer value) {
        if (value != null) {
            progressView.setProgress((float) value);
        }
    }

    @BindingAdapter("progressView_max")
    public static void bindProgressViewMax(ProgressView progressView, Integer value) {
        if (value != null) {
            progressView.setMax((float) value);
        }
    }
}
