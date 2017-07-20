package id.ac.ui.cs.myui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import id.ac.ui.cs.myui.R;
import id.ac.ui.cs.myui.adapter.ListCalendarAdapter;
import id.ac.ui.cs.myui.helper.DatabaseHelper;
import id.ac.ui.cs.myui.model.CalendarItem;

/**
 * Created by faisalagustp on 7/13/17.
 */

/**
 * This class defining Logic of JadwalPage when tab Jadwal is tapped
 */
public class JadwalFragment extends Fragment {
    private ArrayList<CalendarItem> listCalendarItems;
    private DatabaseHelper db;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_calender, container, false);
        db = new DatabaseHelper(getActivity().getApplicationContext());
        final ListView calendarList = (ListView) getView().findViewById(R.id.list_tanggal);
        final List<CalendarItem> myCal = db.getAllParentMenu();
//        final ListCalendarAdapter adapter = new ListCalendarAdapter(getActivity(), R.layout.)
//
//        if (db. != 0)


        return rootView;
        //return inflater.inflate(R.layout.fragment_jadwal, container, false);
    }
}
