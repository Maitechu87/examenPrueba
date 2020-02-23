package com.first.app.pruebaexamen;
import com.first.app.pruebaexamen.MODEL.Receta;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import com.first.app.pruebaexamen.DATA.RecetaLab;
import com.first.app.pruebaexamen.VIEW.Add_receta;
import com.first.app.pruebaexamen.VIEW.Inicio;

public class MainActivity extends AppCompatActivity {

    FragmentManager fragManager;

      @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);

        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if(id==R.id.menu_home){
            fragManager = getSupportFragmentManager();
            fragManager.beginTransaction().replace(R.id.fragment_container, new Inicio()).commit();
        }

        if(id==R.id.menu_in){
            Toast.makeText(this,"Clock in",Toast.LENGTH_SHORT).show();
            Fragment fm = new Add_receta();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, fm);
            transaction.commit();

        }

        if(id==R.id.menu_list){
            Toast.makeText(this,"List",Toast.LENGTH_SHORT).show();
            Fragment fm = new Inicio();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, fm);
            transaction.commit();
        }


        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //instanciar fragment
        fragManager = getSupportFragmentManager();

        fragManager.beginTransaction().replace(R.id.fragment_container, new Inicio()).commit();


    }
}
