package id.ac.ui.cs.myui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import id.ac.ui.cs.myui.R;

/**
 * Created by faisalagustp on 7/13/17.
 */

/**
 * This class defining Logic of JadwalPage when tab Jadwal is tapped
 */
public class JadwalFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_jadwal, container, false);
    }
}
