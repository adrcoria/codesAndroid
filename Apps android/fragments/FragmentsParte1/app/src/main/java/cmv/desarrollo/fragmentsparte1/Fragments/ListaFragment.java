package cmv.desarrollo.fragmentsparte1.Fragments;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.IOException;

import cmv.desarrollo.fragmentsparte1.Adapters.ListaAdapter;
import cmv.desarrollo.fragmentsparte1.Helpers.DataBaseHelper;
import cmv.desarrollo.fragmentsparte1.R;
import cmv.desarrollo.fragmentsparte1.RecyclerItemClickListener;

/**
 * Created by cofa616206 on 05/04/2017.
 */

public class ListaFragment extends android.support.v4.app.Fragment {

    private static final String TAG = "RecyclerviewFragment";
    RecyclerView recyclerView;
    DataBaseHelper dbhelper;
    ListaAdapter adapter;


    public interface CallBacks{
        public void onItemSelected(String nombreLista,String lista);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = layoutInflater.inflate(R.layout.lista_fragment, container, false);

        rootView.setTag(TAG);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.lista);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);



        dbhelper = new DataBaseHelper(getActivity().getApplicationContext());

        try {
            dbhelper.createDataBase();
        } catch (IOException e) {
            throw new Error("No se puede crear BD");
        }


        try {
            dbhelper.openDatabase();
            Cursor cursor = dbhelper.fetchAlllist();
            if(cursor!=null){
                adapter= new ListaAdapter(getActivity().getApplicationContext(),cursor);
                recyclerView.setAdapter(adapter);
                recyclerView.addOnItemTouchListener(
                        new RecyclerItemClickListener(getActivity().getApplicationContext(), new RecyclerItemClickListener.OnItemClickListener() {
                            @Override public void onItemClick(View view, int position) {
                                TextView textView=(TextView) view.findViewById(R.id.title);
                                Toast.makeText(getActivity().getApplicationContext(),textView.getText().toString(),Toast.LENGTH_SHORT).show();
                            }
                        })
                );
            }
        }catch(Exception e){
            throw new Error("No se pudo obtener la lista "+e.getMessage());
        }

        return rootView;
    }



}
