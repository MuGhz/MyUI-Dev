package id.ac.ui.cs.myui.activity;

/**
 * Created by hafiyyansayyidfadhlillah on 7/12/17.
 */

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Toast;

import id.ac.ui.cs.myui.R;

/**
 * This class defining Login page Logic
 * This class also need some fixing because Login logic isn't actually complete
 */
public class LoginActivity extends AppCompatActivity {

    EditText etUsername;
    EditText etPassword;
    String username;
    String password;
    Context context;
    InputMethodManager inputManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //set title bar
        setTitle("Halaman Login");

        //initiation
        etUsername = (EditText) findViewById(R.id.username);
        etPassword = (EditText) findViewById(R.id.password);
        context= getApplicationContext();
        inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);

        //set action if login button clicked
        Button loginButton = (Button) findViewById(R.id.login);
        loginButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),InputMethodManager.HIDE_NOT_ALWAYS);
                login(v);
            }
        });
    }

    public void login(View view){
        username = etUsername.getText().toString();
        password = etPassword.getText().toString();

        if (isValid(view)){
            Intent intent = new  Intent(LoginActivity.this, HomeActivity.class);
            finish(); //setelah login jika di back, tidak kembali ke login
            context.startActivity(intent);
        } else {
            return;
        }

    }

    // validasi form tidak boleh kosong
    public boolean isValid(View view) {
        boolean valid;

        if (!username.isEmpty() && !password.isEmpty()) {
            valid = true;
        } else {
            valid = false;
            Snackbar.make(view, "Username and password are required field", Snackbar.LENGTH_SHORT)
                    .setAction("Action", null).show();
        }

        return valid;
    }
}
