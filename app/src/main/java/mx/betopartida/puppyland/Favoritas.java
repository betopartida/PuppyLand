package mx.betopartida.puppyland;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Favoritas extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    public RecyclerView rvMascotas;
    public MascotaAdapter adapter;
    Toolbar miActionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritas);


        miActionBar=(Toolbar) findViewById(R.id.miActionBar);
        miActionBar.findViewById(R.id.btnStar).setVisibility(View.GONE);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        //recuperamos el array de mascotas
        Intent intent = this.getIntent();
        mascotas = (ArrayList<Mascota>) intent.getSerializableExtra("mascotas");

        rvMascotas=(RecyclerView) this.findViewById(R.id.rvMascotas);

        LinearLayoutManager llm=new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        rvMascotas.setLayoutManager(llm);

        inicializaAdaptador();

    }

    public void inicializaAdaptador() {
        adapter=new MascotaAdapter(mascotas,this);
        rvMascotas.setAdapter(adapter);
    }

}
