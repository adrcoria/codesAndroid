package cmv.desarrollo.fragmentsparte1.Adapters;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import cmv.desarrollo.fragmentsparte1.R;

/**
 * Created by cofa616206 on 05/04/2017.
 */

public class ListaAdapter extends RecyclerView.Adapter<ListaAdapter.ViewHolder> {

    Context myContext;
    CursorAdapter cursorAdapter;

    //constructor para trabajar con un cursor de SQL LITE
    public ListaAdapter(Context context, Cursor cursor){
        this.myContext=context;
        // se declara un cursor adapter y se pasa el contexto y cursor del constructor
        cursorAdapter= new CursorAdapter(context,cursor,0) {
            @Override
            public View newView(Context context, Cursor cursor, ViewGroup parent) {
                // se indica cual el el xml que se utilizara para el item
                LayoutInflater inflater=LayoutInflater.from(parent.getContext());
                View retView=inflater.inflate(R.layout.item,parent,false);
                return retView;
            }

            @Override
            public void bindView(View view, Context context, Cursor cursor) {
                // se obtienen los elementos del item layout
                TextView textView= (TextView) view.findViewById(R.id.title);
                TextView listaNombre= (TextView) view.findViewById(R.id.listaNombre);
                // se setean los datos de la base de datos a los campos especificados
                textView.setText(cursor.getString(cursor.getColumnIndex(cursor.getColumnName(1))));
                listaNombre.setText(cursor.getString(cursor.getColumnIndex(cursor.getColumnName(2))));
            }
        };
    }


    /*public ListaAdapter(String[] data)
    {

    }*/

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        ViewHolder viewHolder= new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
         //holder.textView.setText(myData[position]);
        cursorAdapter.getCursor().moveToPosition(position);
        cursorAdapter.bindView(holder.itemView,myContext,cursorAdapter.getCursor());
    }

    @Override
    public int getItemCount() {
        //return myData.length;
        return cursorAdapter.getCount();
    }



    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView textView,listaNombre;
        public ViewHolder(View itemView) {
            super(itemView);
            textView=(TextView) itemView.findViewById(R.id.title);
            listaNombre=(TextView) itemView.findViewById(R.id.listaNombre);
        }
    }

}
