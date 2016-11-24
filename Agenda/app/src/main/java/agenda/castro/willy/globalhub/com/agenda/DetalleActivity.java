package agenda.castro.willy.globalhub.com.agenda;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class DetalleActivity extends AppCompatActivity {

    TextView lblTituloDetalle;
    EditText txtDetNombres;
    EditText txtDetApellidos;
    EditText txtDetDistrito;
    EditText txtDetEdad;
    int modo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //

        lblTituloDetalle = (TextView) findViewById(R.id.lblTituloDetalle);
        txtDetNombres = (EditText) findViewById(R.id.txtDetNombres);
        txtDetApellidos = (EditText) findViewById(R.id.txtDetApellidos);
        txtDetDistrito = (EditText) findViewById(R.id.txtDetDistrito);
        txtDetEdad = (EditText) findViewById(R.id.txtDetEdad);

        Bundle extras=getIntent().getExtras();

        if(extras!=null)
        {
            if("EDITAR".equals(extras.getString("MODO")))
            {
                lblTituloDetalle.setText("DETALLE DE "+extras.getString("NOMBRES").toUpperCase());
                txtDetNombres.setText(extras.getString("NOMBRES"));
                txtDetApellidos.setText(extras.getString("APELLIDOS"));
                txtDetDistrito.setText(extras.getString("DISTRITO"));
                txtDetEdad.setText(extras.getString("EDAD"));
            }
            if("NUEVO".equals(extras.getString("MODO")))
            {
                lblTituloDetalle.setText("NUEVO CONTACTO");
                txtDetNombres.setText("");
                txtDetApellidos.setText("");
                txtDetDistrito.setText("");
                txtDetEdad.setText("");
            }
        }

        //


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_detalle, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.opGuardar) {
            Snackbar.make(getCurrentFocus(), "Guardar", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
            return true;
        }

        if (id == R.id.opCerrar) {
            finish();

            /*Snackbar.make(getCurrentFocus(), "Cerrar", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();*/
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
