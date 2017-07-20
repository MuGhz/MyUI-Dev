package id.ac.ui.cs.myui.adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import java.util.ArrayList;

import id.ac.ui.cs.myui.R;
import id.ac.ui.cs.myui.model.CalendarItem;
/**
 * Created by Ivan on 7/17/17.
 */

public class ListCalendarAdapter extends ArrayAdapter {
    private final LayoutInflater layoutInflater;
    //private final LinearLayout layout;;
    private ArrayList<CalendarItem> listCalendarItems;
    private LinearLayout layout;

    public ListCalendarAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull ArrayList<CalendarItem> listCalendarItems) {
        super(context, resource, listCalendarItems);
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.listCalendarItems = listCalendarItems;
    }

    @Override
    public int getCount() {
        return listCalendarItems.size();
    }

    @Nullable
    @Override
    public CalendarItem getItem(int position) {
        return listCalendarItems.get(position);
    }

    public int getPosition(@Nullable CalendarItem item) {
        return listCalendarItems.indexOf(item);
    }

    @Override
    public View getView(int position, @Nullable View convertView, ViewGroup parent) {
//        Log.d("tes", "masuk");
        if (convertView == null) {
            layout = (LinearLayout) layoutInflater.inflate(R.layout.content_calender, parent, false);
        }

        else
            layout = (LinearLayout) convertView;

        CalendarItem listCalendarItem = listCalendarItems.get(position);

        TextView label = (TextView) layout.findViewById(R.id.calendarItem_label);
        TextView tanggalMulai = (TextView) layout.findViewById(R.id.tanggalnyamulai);
        TextView tanggalSelesai = (TextView) layout.findViewById(R.id.tanggalnyaselesai);
        layout.setId(position);

        label.setText(listCalendarItem.getNamaKegiatan());
        tanggalMulai.setText(listCalendarItem.getTanggalMulai());
        tanggalSelesai.setText(listCalendarItem.getTanggalSelesai());
        return layout;
    }
}
