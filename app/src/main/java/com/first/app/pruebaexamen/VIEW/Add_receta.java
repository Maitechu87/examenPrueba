package com.first.app.pruebaexamen.VIEW;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.first.app.pruebaexamen.AddRecipeViewModel;
import com.first.app.pruebaexamen.DATA.RecetaLab;
import com.first.app.pruebaexamen.MODEL.Receta;
import com.first.app.pruebaexamen.R;


public class Add_receta extends Fragment {

    private AddRecipeViewModel mViewModel;
    CheckBox esVegan;
    EditText tiempo;
    EditText ingredientes;
    EditText nombre;
    Button guardar;

    private RecetaLab mRecetaLab;
    private Receta mReceta;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        mViewModel = ViewModelProviders.of(this).get(AddRecipeViewModel.class);

        View ui2 = inflater.inflate(R.layout.fragment_add_receta,container, false);

        esVegan = ui2.findViewById(R.id.isVegan);
        tiempo = ui2.findViewById(R.id.txtTime);
        ingredientes = ui2.findViewById(R.id.txtIngred);
        nombre = ui2.findViewById(R.id.txtName);
        guardar = ui2.findViewById(R.id.bttnSave);


        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean vegano = esVegan.isSelected();
                String time = tiempo.getText().toString();
                String ingred = ingredientes.getText().toString();
                String name = nombre.getText().toString();

                addRecipe(vegano,time,ingred,name);
            }
        });


        return ui2;

    }

    public void addRecipe(Boolean vegano, String tiempo, String nombre, String ingredientes){

        mRecetaLab = RecetaLab.get(getContext());

        mReceta = new Receta(nombre,ingredientes, tiempo, vegano);



        }


}
