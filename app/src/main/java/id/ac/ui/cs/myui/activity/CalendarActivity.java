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
import java.util.ArrayList;
import java.util.List;

import id.ac.ui.cs.myui.R;
import id.ac.ui.cs.myui.adapter.ListCalendarAdapter;
import id.ac.ui.cs.myui.model.ListCalendarItem;
import id.ac.ui.cs.myui.task.CalendarTask;

public class CalendarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender);

        Context ctx = getApplicationContext();

        ListView tanggalList = (ListView) findViewById(R.id.list_tanggal);

        List<ListCalendarItem> myCalendar = null; //Harus ambil data dari service
        ListAdapter adapter = new ListCalendarAdapter(this, R.layout.content_calender, (ArrayList<ListCalendarItem>) myCalendar);
        tanggalList.setAdapter(adapter);
        tanggalList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


                Intent intent = new Intent(/*this, HomeActivity.class*/);  //Harus tau data yang diterima detail calendar
                startActivity(intent);
            }
        });

    }
}
