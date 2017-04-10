package cmv.desarrollo.fragmentsparte1.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import cmv.desarrollo.fragmentsparte1.Fragments.ItemsFragment;
import cmv.desarrollo.fragmentsparte1.Fragments.ListaFragment;
import cmv.desarrollo.fragmentsparte1.R;

public class MainActivity extends AppCompatActivity implements ListaFragment.CallBacks {


    public  boolean mTwoPane;
    private static final String ELEMENTS_TAG="ELEMENTS";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        /*Unda de las formas de cargar un frament es reemplazarlo por otro elemento de la actividad*/
        if(findViewById(R.id.list_item)!=null){
            mTwoPane=true;
            if(savedInstanceState==null)
            {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.list_item,new ItemsFragment(),ELEMENTS_TAG)
                        .commit();
            }
            else{
                mTwoPane=false;
            }
        }
    }

    public boolean getmTwoPane(){
        return this.mTwoPane;
    }


    @Override
    public void onItemSelected(String nombreLista, String lista) {
        if(mTwoPane)
        {
            Bundle bundle= new Bundle();
            bundle.putString("nombreLista",nombreLista);
            bundle.putString("lista",lista);
            ItemsFragment itemsFragment= new ItemsFragment();
            itemsFragment.setArguments(bundle);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.list_item,itemsFragment)
                    .commit();
        }
        else{
            Intent intent= new Intent(this,ItemList.class);
            intent.putExtra("lista",lista);
            intent.putExtra("nombreLista",nombreLista);
            startActivity(intent);
        }
    }
}
