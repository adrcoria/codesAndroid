package cmv.desarrollo.fragmentsparte1.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cmv.desarrollo.fragmentsparte1.R;

/**
 * Created by cofa616206 on 07/04/2017.
 */

public class ItemsFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView= inflater.inflate(R.layout.items_fragment,container,false);
        return rootView;
    }
}
