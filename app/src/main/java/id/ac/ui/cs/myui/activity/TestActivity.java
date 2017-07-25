package id.ac.ui.cs.myui.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import net.smartam.leeloo.client.request.OAuthClientRequest;
import net.smartam.leeloo.common.exception.OAuthSystemException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import id.ac.ui.cs.myui.R;

public class TestActivity extends AppCompatActivity {

    final String url = "https://akun.cs.ui.ac.id/oauth/authorize?response_type=code&client_id=2bfJDNTlHhR9TJO6kQ5OsINqeMpNqFrudWOC8Vg9&state=random_state_string";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        OAuthClientRequest request = null;
        try {
            request = OAuthClientRequest
                    .authorizationLocation("https://akun.cs.ui.ac.id/oauth/authorize")
                    .setClientId("2bfJDNTlHhR9TJO6kQ5OsINqeMpNqFrudWOC8Vg9")
                    .buildQueryMessage();
        } catch (OAuthSystemException e) {
            e.printStackTrace();
        }

        Intent intent = new Intent(Intent.ACTION_VIEW,
                Uri.parse(request.getLocationUri() + "&response_type=code"));
        startActivity(intent);


        
    }

    private class MyWebViewClient extends WebViewClient {

        private String contain_code;
        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            if (request.getUrl().toString().contains("localhost")) {
                String[] splitter = request.getUrl().toString().split("&");
                String code = splitter[1];
                Log.d("LOG",code);
                view.setVisibility(View.GONE);
                return true;
            }

            Log.d("LOG",request.getUrl().toString());
//            Log.d("LOG",contain_code.toString());
//            String[] splitter = contain_code.split("&");
//            Log.d("LOG",splitter[0]);
//            String client_id = splitter[1];
//            Log.d("LOG",client_id);
//
            return false;
        }
    }
}
