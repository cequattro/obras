package castro.willy.globalhub.pe.apuestaamerica;

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

    private Pais[] listaDePaises;

    public MyRecyclerAdapter(Pais[] lista)
    {
        listaDePaises=lista;
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
        holder.txtPais.setText(listaDePaises[position].getNombre());
        holder.txtUbicacion.setText(listaDePaises[position].getDescripcion());
    }

    @Override
    public int getItemCount() {
        return listaDePaises.length;
    }

    public static class CustomViewHolder extends RecyclerView.ViewHolder {
        public TextView txtPais;
        public TextView txtUbicacion;

        public CustomViewHolder(View itemView) {//, TextView continente
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Snackbar.make(v, "Seleccionado es "+ ((TextView) v.findViewById(R.id.txtPais)).getText(), Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            });



            txtPais = (TextView) itemView.findViewById(R.id.txtPais);
            txtUbicacion = (TextView) itemView.findViewById(R.id.txtUbicacion);
            //txtUbicacion=continente;
        }
    }

}
