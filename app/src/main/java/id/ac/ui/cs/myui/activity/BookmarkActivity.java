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
import java.util.List;
import java.util.Map;

import id.ac.ui.cs.myui.R;
import id.ac.ui.cs.myui.adapter.BookmarkNewsAdapter;
import id.ac.ui.cs.myui.database.DatabaseHandler;
import id.ac.ui.cs.myui.fragment.MainFragment;
import id.ac.ui.cs.myui.model.News;

public class BookmarkActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    DatabaseHandler databaseHandler;

    public DrawerLayout drawerLayout;
    public ListView drawerList;
    public Toolbar toolbar;
    private ActionBarDrawerToggle drawerToggle;
    private Map map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookmark);

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

                    case R.id.bookmark_menu_drawer:
                        Intent anIntent = new Intent(getApplicationContext(), BookmarkNewsActivity.class);
                        startActivity(anIntent);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.news_feed_menu_drawer:
                        Intent anIntent1 = new Intent(getApplicationContext(), NewsHomeActivity.class);
                        startActivity(anIntent1);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.kalender_akademik_drawer:
                        Intent anIntent2 = new Intent(getApplicationContext(), CalendarActivity.class);
                        startActivity(anIntent2);
                        drawerLayout.closeDrawers();
                        break;

                }
                return false;
            }
        });


    }

    private List<News> createSampleMenu(){
        List<News> newsList = databaseHandler.getAllBookmarkedNews();
        return newsList;

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
