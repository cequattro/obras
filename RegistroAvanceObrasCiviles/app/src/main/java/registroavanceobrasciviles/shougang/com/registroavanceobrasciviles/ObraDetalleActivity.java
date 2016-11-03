package registroavanceobrasciviles.shougang.com.registroavanceobrasciviles;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ObraDetalleActivity extends AppCompatActivity {

    TextView tvTitulo;
    ListView lvObraDetalle;
    Button btnNuevo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_obra_detalle);

        final Context context = this;
        tvTitulo = (TextView)findViewById(R.id.tvTitulo);
        lvObraDetalle = (ListView)findViewById(R.id.lvObraDetalle);
        btnNuevo = (Button)findViewById(R.id.btnNuevo);

        Bundle extras = getIntent().getExtras();
        if(extras!=null) {
            tvTitulo.setText(extras.getString("Nombre"));
        }

        ObraDet[] ObraDet = {
                new ObraDet(1,1,"Primera revisada", new Date(),"Ok",10.0,0.0,0.0),
                new ObraDet(2,1, "Segunda revisada.", new Date(),"Ok",30.0,0.0,0.0)
        };

        ArrayAdapter<ObraDet> adapter = new ArrayAdapter<ObraDet>(this, android.R.layout.simple_list_item_1,ObraDet);
        lvObraDetalle.setAdapter(adapter);

        btnNuevo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.obradetallepopup);
                dialog.setTitle("Titulo");

                //DatePicker dpFechaRegistro = (DatePicker)dialog.findViewById(R.id.dpFechaRegistro);

                Button btnCancelar = (Button)dialog.findViewById(R.id.btnCancelar);
                btnCancelar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });
    }
}
