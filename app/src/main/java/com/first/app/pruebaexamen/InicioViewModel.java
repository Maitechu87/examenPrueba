package com.first.app.pruebaexamen;

import android.content.Context;

import androidx.lifecycle.ViewModel;

public class InicioViewModel extends ViewModel {

    Repository miRepositorio = Repository.get();

    public void setContext(Context context) {
        miRepositorio.setContext(context);
    }
    // TODO: Implement the ViewModel
}
