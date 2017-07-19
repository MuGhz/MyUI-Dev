package id.ac.ui.cs.myui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import id.ac.ui.cs.myui.R;

public class NewsDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);

        Intent intent = getIntent();

        TextView pubDate = (TextView) findViewById(R.id.pubdate);
        pubDate.setText(intent.getStringExtra("pubDate"));

        TextView news_title = (TextView) findViewById(R.id.news_title);
        news_title.setText(intent.getStringExtra("title"));

        TextView news_author = (TextView) findViewById(R.id.news_author);
        news_author.setText(intent.getStringExtra("author"));
        news_author.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("CLICK","Next update can see author profile");
            }
        });

        TextView news_content = (TextView) findViewById(R.id.news_content);
        if (Build.VERSION.SDK_INT >= 24) {
            news_content.setText(Html.fromHtml(intent.getStringExtra("content"),Html.FROM_HTML_MODE_LEGACY));
        }
        else {
            news_content.setText(Html.fromHtml(intent.getStringExtra("content")));
        }

        final Context newsDetailActivity = getApplicationContext();

        Button button_wa = (Button) findViewById(R.id.inibuttonwa);
        button_wa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent whatsappIntent = new Intent(Intent.ACTION_SEND);
                whatsappIntent.setType("text/plain");
                whatsappIntent.setPackage("com.google.android.gm");
                whatsappIntent.putExtra(Intent.EXTRA_TEXT, "The text you wanted to share");
                try {
                    newsDetailActivity.startActivity(whatsappIntent);
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(newsDetailActivity, "Whatsapp have not been installed.", Toast.LENGTH_LONG);
                    Log.d("DEBUG BUTTON", "onClick: lalala " );

                }

                Log.d("DEBUG BUTTON", "onClick: lILILI " );

            }
        });



    }
}
