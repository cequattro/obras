package agenda.castro.willy.globalhub.com.agenda;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    View row;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/

                Intent nuevaVentana = new Intent(getBaseContext(), DetalleActivity.class);
                nuevaVentana.putExtra("MODO","NUEVO");
                startActivity(nuevaVentana);
            }
        });

        //cargar data emulada en arrays y setear un arraylistt de paises

        mRecyclerView = (RecyclerView) findViewById(R.id.lista);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        Bundle extras=getIntent().getExtras();

        if(extras!=null)
        {
            if("NUEVO".equals(extras.getString("MODO")))
            {
                Contacto[] listaDeContactos={new Contacto("Willy","Castro","29","Lince"),
                        new Contacto("Richard","Garrido","30","Breña"),
                        new Contacto("Karina","Aguilar","29","La Victoria"),
                        new Contacto("Angelo","Rodas","29","San Luis"),
                        new Contacto("Arturo","Moquillaza","29","La Victoria"),
                        new Contacto("Carlos","Pereyra","29","Ventanilla"),
                        new Contacto(extras.getString("NOMBRES"),extras.getString("APELLIDOS"),extras.getString("EDAD"),extras.getString("DISTRITO"))};

                mAdapter = new MyRecyclerAdapter(listaDeContactos);
                mRecyclerView.setAdapter(mAdapter);
            }
        }
        else
        {
            Contacto[] listaDeContactos={new Contacto("Willy","Castro","29","Lince"),
                    new Contacto("Richard","Garrido","30","Breña"),
                    new Contacto("Karina","Aguilar","29","La Victoria"),
                    new Contacto("Angelo","Rodas","29","San Luis"),
                    new Contacto("Arturo","Moquillaza","29","La Victoria"),
                    new Contacto("Carlos","Pereyra","29","Ventanilla")};

            mAdapter = new MyRecyclerAdapter(listaDeContactos);
            mRecyclerView.setAdapter(mAdapter);
        }

        // specify an adapter (see also next example)




        //crear adapter de recycler view y pasarle la lista de paises


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        if (id == R.id.opSaldo) {
            Snackbar.make(getCurrentFocus(), "Saldo", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
            return true;
        }

        if (id == R.id.opApostar) {
            Snackbar.make(getCurrentFocus(), "Apostar", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
            return true;
        }

        if (id == R.id.opProgramacion) {
            Snackbar.make(getCurrentFocus(), "Programacion", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
            return true;
        }

        if (id == R.id.opApuestas) {
            Snackbar.make(getCurrentFocus(), "Apuestas", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
