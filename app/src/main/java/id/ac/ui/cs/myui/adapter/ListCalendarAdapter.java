package id.ac.ui.cs.myui.adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import id.ac.ui.cs.myui.R;
import id.ac.ui.cs.myui.model.ListCalendarItem;

/**
 * Created by Ivan on 7/17/17.
 */

public class ListCalendarAdapter extends ArrayAdapter {
    private final LayoutInflater layoutInflater;
    private ArrayList<ListCalendarItem> listCalendarItems;


    public ListCalendarAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull ArrayList<ListCalendarItem> listCalendarItems) {
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
    public ListCalendarItem getItem(int position) {
        return listCalendarItems.get(position);
    }

    public int getPosition(@Nullable ListCalendarItem item) {
        return listCalendarItems.indexOf(item);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LinearLayout layout;
        if (convertView == null)
            layout = (LinearLayout) layoutInflater.inflate(R.layout.content_calender, parent, false);
        else
            layout = (LinearLayout) convertView;
        TextView label = (TextView) layout.findViewById(R.id.calendarItem_label);
        TextView desc = (TextView) layout.findViewById(R.id.calendarItem_desc);
        layout.setId(position);

        ListCalendarItem listCalendarItem = listCalendarItems.get(position);

        label.setText(listCalendarItem.getNamaKegiatan());
        desc.setText(listCalendarItem.getTanggalKegiatan());
        return layout;
    }
}
