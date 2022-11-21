package com.example.practica10_recyclerview;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

public class ElementosViewModel extends AndroidViewModel {

    ElementosRepositorio elementosRepositorio;

    MutableLiveData<List<Elemento>> listElementosMutableLiveData = new MutableLiveData<>();
    MutableLiveData<Elemento> elementoSeleccionado = new MutableLiveData<>();

    public ElementosViewModel(@NonNull Application application) {
        super(application);

        elementosRepositorio = new ElementosRepositorio();

        listElementosMutableLiveData.setValue(elementosRepositorio.obtener());
    }

    MutableLiveData<List<Elemento>> obtener(){
        return listElementosMutableLiveData;
    }

    void insertar(Elemento elemento){
        elementosRepositorio.insertar(elemento, elementos -> listElementosMutableLiveData.setValue(elementos));
    }

    void eliminar(Elemento elemento){
        elementosRepositorio.eliminar(elemento, elementos -> listElementosMutableLiveData.setValue(elementos));
    }

    void actualizar(Elemento elemento, float valoracion){
        elementosRepositorio.actualizar(elemento, valoracion, elementos -> listElementosMutableLiveData.setValue(elementos));
    }

    void seleccionar(Elemento elemento){
        elementoSeleccionado.setValue(elemento);
    }

    MutableLiveData<Elemento> seleccionado(){
        return elementoSeleccionado;
    }
}
