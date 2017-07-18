package id.ac.ui.cs.myui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

import id.ac.ui.cs.myui.R;
import id.ac.ui.cs.myui.adapter.BookmarkNewsAdapter;
import id.ac.ui.cs.myui.model.News;

public class BookmarkNewsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookmark_news);
        setTitle("Bookmark News");

        final ListView listView = (ListView) findViewById(R.id.list_bookmark);
        ArrayList<News> listMenuItems = createSampleMenu();
        final BookmarkNewsAdapter listMenuAdapter = new BookmarkNewsAdapter(BookmarkNewsActivity.this, R.layout.bookmark_item, listMenuItems);
        listView.setAdapter(listMenuAdapter);

    }

    private ArrayList<News> createSampleMenu(){
        ArrayList<News> dummy = new ArrayList<>();
        dummy.add(new News("Daftar Calon Lulusan Fasilkom Semester Genap 2016/2017","Dear mahasiswa, \n" +
                "\n" +
                "Kami mengucapkan selamat atas keberhasilan Anda dalam menyelesaikan studi. Berikut ini daftar calon lulusan semester genap 2016/2017. Jika ada yang ingin menyampaikan masukan terhadap data ini bisa mengirimkan email ke akademik@cs.ui.ac.id paling lambat hari Senin tanggal 17 Juli 2017. ","link",1,"Friday, 14 July 2017, 10:46 AM"," Siti Aminah"));
        dummy.add(new News("Persiapan Yudisium dan Kelulusan Semester genap 2016-2017","Kepada mahasiswa calon lulusan semester genap 2016-2017 yang harus diperhatikan sebagai berikut:","link",2,"Friday, 14 July 2017, 10:46 AM"," Muhammad Fauzy"));
        dummy.add(new News("Daftar Calon Lulusan Fasilkom Semester Genap 2016/2017","Dear mahasiswa, \n" +
                "\n" +
                "Kami mengucapkan selamat atas keberhasilan Anda dalam menyelesaikan studi. Berikut ini daftar calon lulusan semester genap 2016/2017. Jika ada yang ingin menyampaikan masukan terhadap data ini bisa mengirimkan email ke akademik@cs.ui.ac.id paling lambat hari Senin tanggal 17 Juli 2017. ","link",1,"Friday, 14 July 2017, 10:46 AM"," Siti Aminah"));
        dummy.add(new News("Persiapan Yudisium dan Kelulusan Semester genap 2016-2017","Kepada mahasiswa calon lulusan semester genap 2016-2017 yang harus diperhatikan sebagai berikut:","link",2,"Friday, 14 July 2017, 10:46 AM"," Muhammad Fauzy"));
        dummy.add(new News("Daftar Calon Lulusan Fasilkom Semester Genap 2016/2017","Dear mahasiswa, \n" +
                "\n" +
                "Kami mengucapkan selamat atas keberhasilan Anda dalam menyelesaikan studi. Berikut ini daftar calon lulusan semester genap 2016/2017. Jika ada yang ingin menyampaikan masukan terhadap data ini bisa mengirimkan email ke akademik@cs.ui.ac.id paling lambat hari Senin tanggal 17 Juli 2017. ","link",1,"Friday, 14 July 2017, 10:46 AM"," Siti Aminah"));
        dummy.add(new News("Persiapan Yudisium dan Kelulusan Semester genap 2016-2017","Kepada mahasiswa calon lulusan semester genap 2016-2017 yang harus diperhatikan sebagai berikut:","link",2,"Friday, 14 July 2017, 10:46 AM"," Muhammad Fauzy"));
        dummy.add(new News("Daftar Calon Lulusan Fasilkom Semester Genap 2016/2017","Dear mahasiswa, \n" +
                "\n" +
                "Kami mengucapkan selamat atas keberhasilan Anda dalam menyelesaikan studi. Berikut ini daftar calon lulusan semester genap 2016/2017. Jika ada yang ingin menyampaikan masukan terhadap data ini bisa mengirimkan email ke akademik@cs.ui.ac.id paling lambat hari Senin tanggal 17 Juli 2017. ","link",1,"Friday, 14 July 2017, 10:46 AM"," Siti Aminah"));
        dummy.add(new News("Persiapan Yudisium dan Kelulusan Semester genap 2016-2017","Kepada mahasiswa calon lulusan semester genap 2016-2017 yang harus diperhatikan sebagai berikut:","link",2,"Friday, 14 July 2017, 10:46 AM"," Muhammad Fauzy"));
        dummy.add(new News("Daftar Calon Lulusan Fasilkom Semester Genap 2016/2017","Dear mahasiswa, \n" +
                "\n" +
                "Kami mengucapkan selamat atas keberhasilan Anda dalam menyelesaikan studi. Berikut ini daftar calon lulusan semester genap 2016/2017. Jika ada yang ingin menyampaikan masukan terhadap data ini bisa mengirimkan email ke akademik@cs.ui.ac.id paling lambat hari Senin tanggal 17 Juli 2017. ","link",1,"Friday, 14 July 2017, 10:46 AM"," Siti Aminah"));
        dummy.add(new News("Persiapan Yudisium dan Kelulusan Semester genap 2016-2017","Kepada mahasiswa calon lulusan semester genap 2016-2017 yang harus diperhatikan sebagai berikut:","link",2,"Friday, 14 July 2017, 10:46 AM"," Muhammad Fauzy"));

        return dummy;

    }

}
