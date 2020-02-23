package com.first.app.pruebaexamen.VIEW;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.first.app.pruebaexamen.DATA.RecetaLab;
import com.first.app.pruebaexamen.InicioViewModel;
import com.first.app.pruebaexamen.MODEL.Receta;
import com.first.app.pruebaexamen.R;

import java.util.List;

public class Inicio extends Fragment {

    private InicioViewModel mViewModel;
    Button addReceta;
    Button deleteReceta;
    Button consulReceta;
    Button verRecetas;
    EditText idConsultar;
    EditText idBorrar;

    private RecetaLab mRecetaLab;
    private Receta mReceta;
    FragmentManager fragManager;

    public static Inicio newInstance() {
        return new Inicio();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);

        mViewModel = ViewModelProviders.of(this).get(InicioViewModel.class);

        View ui = inflater.inflate(R.layout.inicio_fragment,container,false);

        mViewModel.setContext(getContext());

        addReceta = ui.findViewById(R.id.bttnInsert);
        deleteReceta = ui.findViewById(R.id.bttnBorrar);
        consulReceta = ui.findViewById(R.id.bttnConsultar);
        idBorrar = ui.findViewById(R.id.textBorrar);
        idConsultar = ui.findViewById(R.id.textConsultar);
        verRecetas = ui.findViewById(R.id.bttnVer);
        mRecetaLab = mRecetaLab.get(getContext());

        addReceta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Fragment fm = new Add_receta();
            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container,fm);
            transaction.commit();

            }

        });

        deleteReceta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = idBorrar.getText().toString();
                borrar(id);


            }

        });

        consulReceta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = idConsultar.getText().toString();
                consultar(id);

            }

        });

        verRecetas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Receta> recetas = mRecetaLab.getRecetas();
                System.out.println("hola");

            }

        });


        return ui;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(InicioViewModel.class);
        // TODO: Use the ViewModel
    }


    public void borrar(String id){

    }

    public void consultar(String id){

    }



}
