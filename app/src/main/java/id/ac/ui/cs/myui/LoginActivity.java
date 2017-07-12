package id.ac.ui.cs.myui;

/**
 * Created by hafiyyansayyidfadhlillah on 7/12/17.
 */

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button loginButton = (Button) findViewById(R.id.login);
        loginButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i = new  Intent(LoginActivity.this, HomeActivity.class);
                startActivity(i);
            }
        });
    }
}
