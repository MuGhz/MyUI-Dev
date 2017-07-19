package id.ac.ui.cs.myui.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import id.ac.ui.cs.myui.R;
import id.ac.ui.cs.myui.adapter.ListCalendarAdapter;
import id.ac.ui.cs.myui.helper.DatabaseHelper;
import id.ac.ui.cs.myui.model.CalendarItem;
import id.ac.ui.cs.myui.task.CalendarTask;

public class CalendarActivity extends AppCompatActivity {

    private DatabaseHelper dbHelper;
    ArrayList<CalendarItem> myCalendar;
    final String URL = "https://academic.ui.ac.id/main/Authentication/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_calender);

        final Context ctx = getApplicationContext();
        dbHelper = new DatabaseHelper(ctx);


        new CalendarTask(CalendarActivity.this).execute();
        ListView tanggalList = (ListView) findViewById(R.id.list_tanggal);

        final List<CalendarItem> myCalendar = dbHelper.getAllParentMenu(); //Harus ambil data dari serviceL
     //   Log.i("CALENDAR ACTIVITY", myCalendar.toString());
        ListAdapter adapter = new ListCalendarAdapter(this, R.layout.content_calender, (ArrayList<CalendarItem>) myCalendar);
        tanggalList.setAdapter(adapter);
        tanggalList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                CalendarItem item = (CalendarItem) adapterView.getItemAtPosition(i);
                Intent intent = new Intent(CalendarActivity.this, CalendarDetailActivity.class);
                intent.putExtra("nama kegiatan", item.getNamaKegiatan());
                intent.putExtra("durasi", item.getDurasi());
                intent.putExtra("pelaksana", item.getPelaksana());
                intent.putExtra("tanggal mulai", item.getTanggalMulai());
                intent.putExtra("tanggal selesai", item.getTanggalSelesai());
                startActivity(intent);
            }
        });

    }
}
