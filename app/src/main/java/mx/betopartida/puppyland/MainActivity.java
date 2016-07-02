package mx.betopartida.puppyland;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

/*
* Notas: son dos activities muy parecidas, la diferencia esta en el toolbar
* Se implementa el mismo RecyclerView en ambas activities
* Se usa el mismo array de mascotas, pasandolo como extra
* Se implementa un contador de likes al hacer tap en el hueso blanco
* Se implementa iniciar nueva activity al hacer tap en la estrella del toolbar
* Se implementa el boton de up o back en la segunda activity
* */

public class MainActivity extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    public RecyclerView rvMascotas;
    public MascotaAdapter adapter;
    Toolbar miActionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        miActionBar=(Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        agregarFAB();

        activaEstrella();

        mascotas=new ArrayList<Mascota>();
        rvMascotas=(RecyclerView) findViewById(R.id.rvMascotas);

        LinearLayoutManager llm=new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        //GridLayoutManager glm=new GridLayoutManager(this,2);

        rvMascotas.setLayoutManager(llm);
        inicializaListaMascotas();
        inicializaAdaptador();

    }

    public void inicializaListaMascotas() {
        mascotas.add(new Mascota("Juno",R.drawable.pet1,0));
        mascotas.add(new Mascota("Frida",R.drawable.pet2,0));
        mascotas.add(new Mascota("Candy",R.drawable.pet3,0));
        mascotas.add(new Mascota("Nina",R.drawable.pet4,0));
        mascotas.add(new Mascota("Tito",R.drawable.pet5,0));

    }

    public void inicializaAdaptador() {
        adapter=new MascotaAdapter(mascotas,this);
        rvMascotas.setAdapter(adapter);
    }



    public void agregarFAB() {
        FloatingActionButton miFAB = (FloatingActionButton) findViewById(R.id.btnFAB);
        miFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Click!", Snackbar.LENGTH_SHORT).show();
            }
        });
    }

    public void activaEstrella() {
        ImageView estrella = (ImageView) MainActivity.this.miActionBar.findViewById(R.id.btnStar);
        estrella.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Favoritas.class);
                //paso el array de mascotas para no tener que volver a crearlo
                intent.putExtra("mascotas",mascotas);
                startActivity(intent);

            }
        });
    }

}
