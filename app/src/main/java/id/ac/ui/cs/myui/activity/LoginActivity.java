package id.ac.ui.cs.myui.activity;

/**
 * Created by hafiyyansayyidfadhlillah on 7/12/17.
 */

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Toast;

import id.ac.ui.cs.myui.R;

import static android.preference.PreferenceManager.getDefaultSharedPreferences;

/**
 * This class defining Login page Logic
 * This class also need some fixing because Login logic isn't actually complete
 */
public class LoginActivity extends AppCompatActivity {
    EditText etUsername,etPassword;
    Button btnLogin;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("On create", "log in");
        setContentView(R.layout.activity_login);

        //set title bar
        setTitle("Halaman Login");

        etUsername=(EditText)findViewById(R.id.etUsername);
        etPassword=(EditText)findViewById(R.id.etPassword);
        btnLogin=(Button)findViewById(R.id.btnLogin);

        sp=getDefaultSharedPreferences(this.getApplicationContext());

        //if SharedPreferences contains username and password then directly redirect to Home activity
        if(sp.contains("username") && sp.contains("password")){
            Log.d("SESSION", sp.getString("username", "password"));
            Intent i = new  Intent(LoginActivity.this, HomeActivity.class);
            i.putExtra("username", etUsername.getText().toString());
            Log.d("LOG IN EXTRA", i.getStringExtra("username"));
            startActivity(i);
            finish();   //finish current activity
        }

        Button loginButton = (Button) findViewById(R.id.btnLogin);

        //set action if login button clicked
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginCheck();
            }
        });
    }

    void loginCheck(){
        //check username and password are correct and then add them to SharedPreferences
        if(etUsername.getText().toString().equals("programmer") && etPassword.getText().toString().equals("programmer")){
            SharedPreferences.Editor e=sp.edit();
            e.putString("username","programmer");
            e.putString("password","programmer");
            e.commit();

            Toast.makeText(LoginActivity.this,"Login Successful",Toast.LENGTH_LONG).show();
            Intent i = new  Intent(LoginActivity.this, HomeActivity.class);
            i.putExtra("username", etUsername.getText().toString());

            startActivity(i);
            finish();
        }
        else{
            Toast.makeText(LoginActivity.this,"Incorrect Login Details",Toast.LENGTH_LONG).show();
        }
    }
}

