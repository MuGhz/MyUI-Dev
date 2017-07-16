package id.ac.ui.cs.myui.activity;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import id.ac.ui.cs.myui.R;

/**
 * Created by faisalagustp on 7/13/17.
 */

/**
 * This class is used as a Response of pushing Academic Tracker button in HomeActivity
 * You may change or delete this class in the future if it's necessary
 */
public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //Set title bar
        setTitle("My Academic Tracker");

        //Set back button redirection
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
