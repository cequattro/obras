package castro.willy.globalhub.pe.apuestaamerica;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Android on 05/11/2016.
 */

//todo hacer en el trabajo guaindose de https://developer.android.com/training/material/lists-cards.html

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.CustomViewHolder> {

    private Pais[] listaDePaises;

    @Override
    public MyRecyclerAdapter.CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(MyRecyclerAdapter.CustomViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        public TextView txtPais;
        public TextView txtContinente;

        public CustomViewHolder(View itemView) {
            super(itemView);
        }
    }
}
