package id.ac.ui.cs.myui.activity;

/**
 * Created by hafiyyansayyidfadhlillah on 7/12/17.
 */

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

import id.ac.ui.cs.myui.R;
import id.ac.ui.cs.myui.task.NewsSceleTask;

/**
 * This class defining Login page Logic
 * This class also need some fixing because Login logic isn't actually complete
 */
public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        
        setTitle("Halaman Login");

        //set action if login button clicked
        Button loginButton = (Button) findViewById(R.id.login);
        loginButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i = new  Intent(LoginActivity.this, CalendarActivity.class);
                startActivity(i);
            }
        });


    }
}
