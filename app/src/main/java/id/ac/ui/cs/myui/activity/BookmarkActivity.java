package id.ac.ui.cs.myui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Map;

import id.ac.ui.cs.myui.R;
import id.ac.ui.cs.myui.adapter.BookmarkNewsAdapter;
import id.ac.ui.cs.myui.fragment.MainFragment;
import id.ac.ui.cs.myui.model.News;

public class BookmarkActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public DrawerLayout drawerLayout;
    public ListView drawerList;
    public Toolbar toolbar;
    private ActionBarDrawerToggle drawerToggle;
    private Map map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookmark);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

//        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
//                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
//        drawerLayout.setDrawerListener(toggle);
//        toggle.syncState();
//
//        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
//        navigationView.setNavigationItemSelectedListener(this);
    //=====================================================================================================
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,  R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.setDrawerListener(drawerToggle);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()) {

                    case R.id.news_feed_menu_drawer:
                        Intent anIntent = new Intent(getApplicationContext(), BookmarkNewsActivity.class);
                        startActivity(anIntent);
                        drawerLayout.closeDrawers();
                        break;

                }
                return false;
            }
        });


    }

    private ArrayList<News> createSampleMenu(){
        ArrayList<News> dummy = new ArrayList<>();
        dummy.add(new News("Daftar Calon Lulusan Fasilkom Semester Genap 2016/2017","Dear mahasiswa, \n" +
                "\n" +
                "Kami mengucapkan selamat atas keberhasilan Anda dalam menyelesaikan studi. Berikut ini daftar calon lulusan semester genap 2016/2017. Jika ada yang ingin menyampaikan masukan terhadap data ini bisa mengirimkan email ke akademik@cs.ui.ac.id paling lambat hari Senin tanggal 17 Juli 2017. ","link","Friday, 14 July 2017, 10:46 AM"," Siti Aminah"));
        dummy.add(new News("Persiapan Yudisium dan Kelulusan Semester genap 2016-2017","Kepada mahasiswa calon lulusan semester genap 2016-2017 yang harus diperhatikan sebagai berikut:","link","Friday, 14 July 2017, 10:46 AM"," Muhammad Fauzy"));

        return dummy;

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.bookmark, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        return true;
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        drawerToggle.syncState();
    }
}
