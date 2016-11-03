package registroavanceobrasciviles.shougang.com.registroavanceobrasciviles;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class ObrasActivity extends AppCompatActivity {

    ListView lvObras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_obras);

        lvObras = (ListView)findViewById(R.id.lvObras);

        ObraCab[] obrasCab = {
                new ObraCab(1, "Techado de planta baja."),
                new ObraCab(2, "Perforación Sector 9."),
                new ObraCab(3, "Saneado Urb. San José."),
                new ObraCab(4, "Iluminación eléctrica loza deportiva."),
                new ObraCab(5, "Asfaltado Av. Heraclio Tapia."),
                new ObraCab(6, "Pintado de Gerencia General."),
                new ObraCab(7, "Desarrollo Urbano AA.HH El Milagro."),
                new ObraCab(8, "Perforación Sector 11"),
                new ObraCab(9, "Demolición Casa de la suegra del jefe."),
                new ObraCab(10, "Rellenar socavon ")
        };

         ArrayAdapter<ObraCab> adapter = new ArrayAdapter<ObraCab>(this, android.R.layout.simple_list_item_1,obrasCab);
        lvObras.setAdapter(adapter);

        lvObras.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent detalle = new Intent(ObrasActivity.this, ObraDetalleActivity.class);

                String itemSeleccionado = lvObras.getItemAtPosition(position).toString();

                detalle.putExtra("Nombre",itemSeleccionado);
                startActivity(detalle);
            }
        });
    }
}
