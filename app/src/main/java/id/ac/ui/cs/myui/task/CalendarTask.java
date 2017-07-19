package id.ac.ui.cs.myui.task;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import id.ac.ui.cs.myui.activity.CalendarActivity;
import id.ac.ui.cs.myui.helper.DatabaseHelper;
import id.ac.ui.cs.myui.model.CalendarItem;

/**
 * Created by siti.ina on 17/07/17.
 */

public class CalendarTask extends AsyncTask<String, Void, String> {

    ProgressDialog progressDialog;
    String data;
    private Context context;
    private DatabaseHelper dbHelper;
    final String URL2 = "https://academic.ui.ac.id/main/CalendarUI/Index";

    public CalendarTask(Context context) {
        this.context = context;
        dbHelper = new DatabaseHelper(context);
    }

    /*
        Digunakan untuk mengambil data hasil scrap dari website academic.ui.ac.id
        menggunakan jsoup library (masih sotil, kalau kalian punya yang lebih rekomen silakan diganti. masih masalah klo mau scrap pagenya mesti login dulu)
     */

    @Override
    protected String doInBackground(String... params) {
  //      try {
        List<CalendarItem> calendarItemList = createCalenderItem();
        dbHelper.insertMenu(calendarItemList);
//            Connection.Response initial = Jsoup
//                    .connect(params[0])
//                    .method(Connection.Method.GET).execute();
//
//            Connection.Response login = Jsoup
//                    .connect(params[0])
//                    .data("u","sarah.yarismal")
//                    .data("p","berkah2017")
//                    .cookies(initial.cookies())
//                    .method(Connection.Method.POST)
//                    .execute();
//
//            /*Document page = Jsoup
//                    .connect("ANY_PAGE_INSIDE_THE_SITE")
//                    .cookies(login.cookies()) //use this with any page you parse. it will log you in
//                    .get();*/
//
//            Log.d("masuk", "test");
//            Document doc = Jsoup.connect(URL2).cookies(login.cookies()).maxBodySize(0).get();
//            Log.i("ha", doc.title().toString());
////            Elements tableElement = doc.select(".box");
////            Log.d("nama jsoup", tableElement.toString());
////            Elements tableRows = tableElement.select("tr");
////            for (Element row : tableRows) {
////                Elements cells = row.select("td");
////                if (cells.size() >0) {
////                //    System.out.print("haiahai");
////                    Log.d("CALENDAR TASK",cells.get(0).text()+"; "+cells.get(1).text()+"; "+cells.get(2).text()+"; "+cells.get(3).text());
////                }
////            }
//
//            //Element table = doc.select("table").first();
//            Boolean html = doc.html().contains("class\"box\"");
//            Element table = doc.getElementsByClass("box").first();
//
//            if(table == null) {
//                Log.d("hasil", "masih null nih :(" + html);
//            }
//
//            else {
//
//
//            Elements tableRows = table.select("tr");
//            for (int i = 1; i < tableRows.size(); i++) { //first row is the col names so skip it.
//                Element row = tableRows.get(i);
//                Elements cols = row.select("td");
//                Log.d("CALENDAR TASK", cols.get(0).text()+"; "+cols.get(1).text()+"; "+cols.get(2).text()+"; "+cols.get(3).text());
//            }
//            }

//            return "halo halo";
//        }
//
//        catch (IOException e) {
//            e.printStackTrace();
//        }
        return data;
    }


    private List<CalendarItem> createCalenderItem() {
        CalendarItem item1 = new CalendarItem(1, "19 Mei 2017", "01 Jun 2017" ,	14,	"Universitas Indonesia","Registrasi Akademik");
        CalendarItem item2 = new CalendarItem(2, "24 Mei 2017", "01 Jun 2017", 9, "Program Studi S1 Paralel Sistem Informasi","Registrasi Akademik");
        CalendarItem item3 = new CalendarItem(3, "02 Jun 2017",  "02 Jun 2017", 1, "Program Studi S1 Paralel Sistem Informasi", "Lain-lain: Penentuan mata kuliah yang batal dibuka (Peminat Sedikit)");
        CalendarItem item4 = new CalendarItem(4, "02 Jun 2017", "04 Jun 2017", 3, "Program Studi S1 Paralel Sistem Informasi", "Masa Drop IRS");
        CalendarItem item5 = new CalendarItem(5, "02 Jun 2017", "09 Jun 2017", 8, "Universitas Indonesia", "Registrasi Administrasi");
        CalendarItem item6 = new CalendarItem(6, "02 Jun 2017",  "04 Jun 2017", 3, "Program Studi S1 Paralel Sistem Informasi", "Masa Add IRS");
        CalendarItem item7 = new CalendarItem(7, "03 Jun 2017", "09 Jun 2017", 7, "Program Studi S1 Paralel Sistem Informasi", "Lain-lain: Registrasi Administrasi (Pembayaran Biaya Semester Pendek)");
        CalendarItem item8 = new CalendarItem(8, "09 Jun 2017", "09 Jun 2017", 1, "Universitas Indonesia", "Batas Akhir Registrasi Akademik SP");
        CalendarItem item9 = new CalendarItem(9, "12 Jun 2017", "18 Agt 2017", 68, "Program Studi S1 Paralel Sistem Informasi", "Perkuliahan");
        CalendarItem item10 = new CalendarItem(10, "12 Jun 2017", "18 Agt 2017", 68, "Universitas Indonesia", "Perkuliahan");
        CalendarItem item11 = new CalendarItem(11, "22 Agt 2017", "22 Agt 2017", 1, "Universitas Indonesia", "Batas Akhir Pengunggahan Nilai");
        CalendarItem item12 = new CalendarItem(12, "22 Agt 2017", "22 Agt 2017", 1, "Program Studi S1 Paralel Sistem Informasi", "Lain-lain: Batas pengunggahan nilai ke SIAK NG");
        CalendarItem item13 = new CalendarItem(13, "25 Agt 2017", "25 Agt 2017", 1, "Universitas Indonesia", "Batas Akhir Penetapan Kelulusan");
        CalendarItem item14 = new CalendarItem(14, "25 Agt 2017", "25 Agt 2017", 1, "Program Studi S1 Paralel Sistem Informasi", "Lain-lain: Batas penetapan kelulusan");

        ArrayList<CalendarItem> items = new ArrayList<>();
        items.add(item1);
        items.add(item2);
        items.add(item3);
        items.add(item4);
        items.add(item5);
        items.add(item6);
        items.add(item7);
        items.add(item8);
        items.add(item9);
        items.add(item10);
        items.add(item11);
        items.add(item12);
        items.add(item13);
        items.add(item14);

        return items;
    }


}
