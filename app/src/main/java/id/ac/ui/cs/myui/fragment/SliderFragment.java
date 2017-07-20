package id.ac.ui.cs.myui.fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import id.ac.ui.cs.myui.R;

/**
 * Created by galih.priyambodho on 17/07/17.
 */

public class SliderFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.activity_calendar_detail, container, false);

        return rootView;
    }
}
