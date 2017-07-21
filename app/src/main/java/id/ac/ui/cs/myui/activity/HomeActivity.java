package id.ac.ui.cs.myui.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.IdRes;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import id.ac.ui.cs.myui.R;
import id.ac.ui.cs.myui.fragment.JadwalFragment;
import id.ac.ui.cs.myui.fragment.MainFragment;


/**
 * This class is used for Homepage logic
 * The footer tab logic also defined here
 */
public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("ON CREATE", "Home activity");
        sessionDebugger();
        setContentView(R.layout.activity_home);

        final MainFragment mainFragment = new MainFragment();
        //By default, use MainFragment
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, mainFragment).commit();

        BottomBar bottomBar = (BottomBar) findViewById(R.id.bottomBar);

        //what to do if bottom bar or tab is tapped
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {

                //Checking tab Id that has been tapped
                if (tabId == R.id.tab_menu) {
                    //Use MainFragment
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.fragment_container, mainFragment);
                    transaction.addToBackStack(null);
                    transaction.commit();
                    setTitle("MyUI");
                }else if(tabId == R.id.tab_jadwal) {
                    //Use JadwalFragment
                    JadwalFragment jadwalFragment = new JadwalFragment();
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.fragment_container, jadwalFragment);
                    transaction.addToBackStack(null);
                    transaction.commit();
                    setTitle("Jadwal Kuliah");
                }
            }
        });

    }

    @Override
    public void onResume(){
        super.onResume();
        SharedPreferences sp= PreferenceManager.getDefaultSharedPreferences(this);
        getIntent().putExtra("username", sp.getString("username", "password"));
        Log.d("ON RESUME EXTRA", getIntent().getStringExtra("username"));
    }

    public void sessionDebugger() {
        SharedPreferences sp=getSharedPreferences("login",MODE_PRIVATE);

        if(sp.contains("username") && sp.contains("password")){
            Log.d("SESSION", sp.getString("username", "password"));

        }
    }
}
