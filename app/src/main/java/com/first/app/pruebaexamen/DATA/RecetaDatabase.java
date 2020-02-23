package com.first.app.pruebaexamen.DATA;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.first.app.pruebaexamen.MODEL.Receta;


@androidx.room.Database(entities = {Receta.class},version=1)

public abstract class RecetaDatabase extends RoomDatabase {
    public abstract RecetaDao getRecetaDao();
}
