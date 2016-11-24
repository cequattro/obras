package agenda.castro.willy.globalhub.com.agenda;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Android on 05/11/2016.
 */

//todo hacer en el trabajo guaindose de https://developer.android.com/training/material/lists-cards.html

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.CustomViewHolder> {

    private Contacto[] listaDeContactos;

    public MyRecyclerAdapter(Contacto[] lista)
    {
        listaDeContactos=lista;
    }

    @Override
    public MyRecyclerAdapter.CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row, parent, false);
        CustomViewHolder vh = new CustomViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyRecyclerAdapter.CustomViewHolder holder, int position) {

        holder.txtNombres.setText(listaDeContactos[position].getNombres());
        holder.txtApellidos.setText(listaDeContactos[position].getApellidos());
        holder.txtEdad.setText(listaDeContactos[position].getEdad());
        holder.txtDistrito.setText(listaDeContactos[position].getDistrito());

    }

    @Override
    public int getItemCount() {
        return listaDeContactos.length;
    }

    public static class CustomViewHolder extends RecyclerView.ViewHolder {
        public TextView txtNombres;
        public TextView txtApellidos;
        public TextView txtEdad;
        public TextView txtDistrito;


        public CustomViewHolder(View itemView) {//, TextView continente
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    /*Snackbar.make(v, "Seleccionado es "+ ((TextView) v.findViewById(R.id.txtNombres)).getText(), Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();*/
                    Context context=v.getContext();

                    Intent nuevaVentana = new Intent(context, DetalleActivity.class);
                    nuevaVentana.putExtra("MODO","EDITAR");
                    nuevaVentana.putExtra("NOMBRES",((TextView) v.findViewById(R.id.txtNombres)).getText());
                    nuevaVentana.putExtra("APELLIDOS",((TextView) v.findViewById(R.id.txtApellidos)).getText());
                    nuevaVentana.putExtra("EDAD",((TextView) v.findViewById(R.id.txtEdad)).getText());
                    nuevaVentana.putExtra("DISTRITO",((TextView) v.findViewById(R.id.txtDistrito)).getText());

                    context.startActivity(nuevaVentana);

                }
            });



            txtNombres = (TextView) itemView.findViewById(R.id.txtNombres);
            txtApellidos = (TextView) itemView.findViewById(R.id.txtApellidos);
            txtEdad = (TextView) itemView.findViewById(R.id.txtEdad);
            txtDistrito = (TextView) itemView.findViewById(R.id.txtDistrito);
            //txtUbicacion=continente;
        }
    }

}
