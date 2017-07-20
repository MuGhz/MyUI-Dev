package id.ac.ui.cs.myui.activity;

/**
 * Created by hafiyyansayyidfadhlillah on 7/12/17.
 */

import android.content.SharedPreferences;
import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
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
    SharedPreferences sp;
    EditText etUsername;
    EditText etPassword;
    Button loginButton;
    String username;
    String password;
    Context context;
    InputMethodManager inputManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("On create", "log in");
        setContentView(R.layout.activity_login);

        //set title bar
        setTitle("Halaman Login");

        etUsername=(EditText)findViewById(R.id.etUsername);
        etPassword=(EditText)findViewById(R.id.etPassword);
        loginButton=(Button)findViewById(R.id.btnLogin);
        context= getApplicationContext();
        inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);

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

        //set action if login button clicked
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),InputMethodManager.HIDE_NOT_ALWAYS);
                loginCheck();
            }
        });
    }

    void loginCheck() {
        username = etUsername.getText().toString();
        password = etPassword.getText().toString();
        //check username and password are correct and then add them to SharedPreferences
        //masih cek manual

        if (isValid()){
            if (username.equals("programmer") && password.equals("programmer")) {
                SharedPreferences.Editor e = sp.edit();
                e.putString("username", "programmer");
                e.putString("password", "programmer");
                e.commit();

                Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_LONG).show();
                Intent i = new Intent(LoginActivity.this, HomeActivity.class);
                i.putExtra("username", etUsername.getText().toString());

                startActivity(i);
                finish();
            } else {
                Toast.makeText(LoginActivity.this, "Incorrect Login Details", Toast.LENGTH_LONG).show();
            }
        } else {
            return;
        }


    }

    // validasi form tidak boleh kosong
    public boolean isValid() {
        boolean valid;

        if (!username.isEmpty() && !password.isEmpty()) {
            valid = true;
        } else {
            valid = false;
            Toast.makeText(LoginActivity.this, "Username and password are required field", Toast.LENGTH_LONG).show();
            //Snackbar.make(view, "Username and password are required field", Snackbar.LENGTH_SHORT).setAction("Action", null).show();
        }

        return valid;
    }
}

