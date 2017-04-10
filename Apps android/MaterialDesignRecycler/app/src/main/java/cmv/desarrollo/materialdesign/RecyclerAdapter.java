package cmv.desarrollo.materialdesign;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by cofa616206 on 03/04/2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private String[] myData;

    public RecyclerAdapter(String[] Data) {
        this.myData = Data;

    }

    //es el encargado de crear los nuevos elemento para la coleccion
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item,parent,false);

        ViewHolder viewHolder= new ViewHolder(view);

        return viewHolder;
    }

    //actualizar los datos que ya tenemos
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textView.setText(myData[position]);
    }

    //conteo
    @Override
    public int getItemCount() {
        return myData.length;
    }

    // se crea el viewholder personalizado
    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        public TextView textView;
        public ViewHolder(View itemView)
        {
            super(itemView);
            textView=(TextView) itemView.findViewById(R.id.titulo);
        }
    }

}
