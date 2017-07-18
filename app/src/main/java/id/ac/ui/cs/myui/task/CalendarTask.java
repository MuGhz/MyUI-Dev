package id.ac.ui.cs.myui.task;

import android.app.ProgressDialog;
import android.os.AsyncTask;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Created by siti.ina on 17/07/17.
 */

public class CalendarTask extends AsyncTask<String, Void, String> {

    ProgressDialog progressDialog;
    String data;

    /*
        Digunakan untuk mengambil data hasil scrap dari website academic.ui.ac.id
        menggunakan jsoup library (masih sotil, kalau kalian punya yang lebih rekomen silakan diganti. masih masalah klo mau scrap pagenya mesti login dulu)
     */

    @Override
    protected String doInBackground(String... params) {
        try {
            Document doc = Jsoup.connect(params[0]).get();
            Elements tableElement = doc.select(".box");
            Elements tableRows = tableElement.select("tr");
            for (Element row : tableRows) {
                Elements cells = row.select("td");
                if (cells.size() >0) {
                    System.out.println(cells.get(0).text()+"; "+cells.get(1).text()+"; "+cells.get(2).text()+"; "+cells.get(3).text());
                }
            }
        }

        catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }





}
